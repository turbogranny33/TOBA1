package com.toba.bll.authentication;

import com.toba.bll.database.AccountDB;
import com.toba.bll.database.UserDB;
import com.toba.bll.transaction.Account;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewCustomerServlet extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.security.NoSuchAlgorithmException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String email = request.getParameter("email");
        
        String validationMessage;
        if (
            firstName == null || firstName.isEmpty()
            || lastName == null || lastName.isEmpty()
            || phone == null || phone.isEmpty()
            || address == null || address.isEmpty()
            || city == null || city.isEmpty()
            || state == null || state.isEmpty()
            || zipCode == null || zipCode.isEmpty()
            || email == null || email.isEmpty())
        {
            validationMessage = "Please fill out all the form fields.";
            request.setAttribute("validationMessage", validationMessage);
            getServletContext().getRequestDispatcher("/New_customer.jsp").forward(request, response);
        }
        else
        {
            String salt = PasswordUtil.getSalt();
            String password = "welcome1";
            String hashedAndSaltedPassword = PasswordUtil.hashAndSaltPassword(password, salt);
            
            User user = new User();
            user.setUserName(lastName + zipCode);
            user.setPassword(hashedAndSaltedPassword);
            user.setSalt(salt);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhone(phone);
            user.setAddress(address);
            user.setCity(city);
            user.setState(state);
            user.setZipCode(zipCode);
            user.setEmail(email);
            user.setRegistrationDate(new Date());

            UserDB.insert(user);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            // create accounts
            Account savingsAccount = new Account("Savings", 25, user);
            Account checkingAccount = new Account("Checking", 0, user);
            AccountDB.insert(savingsAccount);
            AccountDB.insert(checkingAccount);

            response.sendRedirect("Success.jsp");
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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