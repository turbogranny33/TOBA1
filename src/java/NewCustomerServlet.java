/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brian_000
 */
@WebServlet(urlPatterns = {"/NewCustomer"})
public class NewCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String phone = request.getParameter("Phone");
        String address = request.getParameter("Address");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        String zipcode = request.getParameter("Zipcode");
        String email = request.getParameter("Email");
        
        String validationMessage;
        if (
            firstName == null || firstName.isEmpty()
            || lastName == null || lastName.isEmpty()
            || phone == null || phone.isEmpty()
            || address == null || address.isEmpty()
            || city == null || city.isEmpty()
            || state == null || state.isEmpty()
            || zipcode == null || zipcode.isEmpty()
            || email == null || email.isEmpty())
        {
            validationMessage = "Please fill out all the form fields.";
            request.setAttribute("validationMessage", validationMessage);
            getServletContext().getRequestDispatcher("/New_customer.html").forward(request, response);
        }
        else
        {
            response.sendRedirect("Success.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
