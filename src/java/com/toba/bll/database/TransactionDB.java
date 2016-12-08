package com.toba.bll.database;

import com.toba.bll.authentication.User;
import com.toba.bll.transaction.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class TransactionDB
{
    public static void insert(Transaction transaction)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        try
        {
            em.persist(transaction);
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            System.out.println(e);
            entityTransaction.rollback();
        }
        finally
        {
            em.close();
        }
    }
     
    public static List<Transaction> selectTransactions(User user)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString =    "SELECT t FROM Transaction t " +
                                "INNER JOIN Account sa ON sa.account = t.sourceAccount " +
                                "INNER JOIN Account da ON da.account = t.destinationAccount " +
                                "WHERE sa.accountOwner = :user OR da.accountOwner = :user";
        TypedQuery<Transaction> query = em.createQuery(queryString, Transaction.class);
        query.setParameter("user", user);

        List<Transaction> transactions = null;
        try
        {
            transactions = query.getResultList();
            if (transactions == null || transactions.isEmpty())
            {
                transactions = null;
            }
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally
        {
            em.close();
        }
        return transactions;
    }
}