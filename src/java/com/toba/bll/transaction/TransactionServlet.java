package com.toba.bll.transaction;

import com.toba.bll.authentication.User;
import com.toba.bll.database.AccountDB;
import com.toba.bll.database.TransactionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet
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
    }

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
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        List<Account> accounts = AccountDB.selectAccounts(user);

        session.setAttribute("accounts", accounts);
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
            throws ServletException, IOException
    {
        String sourceAccountString = request.getParameter("sourceAccount");
        String destinationAccountString = request.getParameter("destinationAccount");
        String amountString = request.getParameter("amount");
        
        Long sourceAccountId = null;
        Long destinationAccountId = null;
        Double amount = null;
        try {
            sourceAccountId = Long.parseLong(sourceAccountString);
            destinationAccountId = Long.parseLong(destinationAccountString);
            amount = Double.parseDouble(amountString);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        // input valid
        if (sourceAccountId != null && destinationAccountId != null && amount != null && !Objects.equals(sourceAccountId, destinationAccountId)) {
            Account sourceAccount = AccountDB.selectAccount(sourceAccountId);
            Account destinationAccount = AccountDB.selectAccount(destinationAccountId);
            
            // transaction valid
            if (amount <= sourceAccount.getBalance()) {
                sourceAccount.debit(amount);
                destinationAccount.credit(amount);
                Transaction transaction = new Transaction(sourceAccount, destinationAccount, amount);
                
                AccountDB.update(sourceAccount);
                AccountDB.update(destinationAccount);
                TransactionDB.insert(transaction);
                
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                List<Account> accounts = AccountDB.selectAccounts(user);
                session.setAttribute("accounts", accounts);
                List<Transaction> transactions = TransactionDB.selectTransactions(user);
                session.setAttribute("transactions", transactions);

                response.sendRedirect("Account_activity.jsp");
                return;
            }
            else {
                request.setAttribute("validationMessage", "Selected account does not have enough available funds.");
            }
        }
        else
        {
            request.setAttribute("validationMessage", "Input was invalid.");
        }

        getServletContext().getRequestDispatcher("/Transaction.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}