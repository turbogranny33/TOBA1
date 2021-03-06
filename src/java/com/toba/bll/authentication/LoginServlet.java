package com.toba.bll.authentication;

import com.toba.bll.database.AccountDB;
import com.toba.bll.database.TransactionDB;
import com.toba.bll.database.UserDB;
import com.toba.bll.transaction.Account;
import com.toba.bll.transaction.Transaction;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
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
            throws ServletException, IOException
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //User user = (User)request.getSession().getAttribute("user");
        User user = UserDB.selectUser(userName);
        if (user != null)
        {
            String salt = user.getSalt();
            String hashedAndSaltedPassword = null;
            try {
                hashedAndSaltedPassword = PasswordUtil.hashAndSaltPassword(password, salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // login successful
            if (hashedAndSaltedPassword.equals(user.getPassword()))
            {
                List<Account> accounts = AccountDB.selectAccounts(user);
                List<Transaction> transactions = TransactionDB.selectTransactions(user);

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("accounts", accounts);
                session.setAttribute("transactions", transactions);

                response.sendRedirect("Account_activity.jsp");
            }
            // login failed
            else
            {
                response.sendRedirect("Login_failure.jsp");
            }
        }
        // user does not exist
        else
        {
            response.sendRedirect("New_customer.jsp");
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