/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.bll.admin;

import com.toba.bll.authentication.User;
import com.toba.bll.database.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ReportsDownloadServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users Registered in the Past Month");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("User Name");
        row.createCell(1).setCellValue("First Name");
        row.createCell(2).setCellValue("Last Name");
        row.createCell(3).setCellValue("Registration Date");
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date oneMonthAgo = calendar.getTime();
        
        List<User> usersRegisteredInThePastMonth = UserDB.selectUsersRegisteredAfter(oneMonthAgo);
        
        HSSFCellStyle dateCellStyle = (HSSFCellStyle)workbook.createCellStyle();
        short dateDataFormat = workbook.createDataFormat().getFormat("dd/MM/yyyy");
        dateCellStyle.setDataFormat(dateDataFormat);
        
        for (int i = 0; i < usersRegisteredInThePastMonth.size(); i++) {
            User user = usersRegisteredInThePastMonth.get(i);
            
            row = sheet.createRow(1 + i);
            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getFirstName());
            row.createCell(2).setCellValue(user.getLastName());
            row.createCell(3).setCellValue(user.getRegistrationDate());
            row.getCell(3).setCellStyle(dateCellStyle);
        }
        
        workbook.write(response.getOutputStream());
        workbook.close();        

        response.setHeader("content-disposition", "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
