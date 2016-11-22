package com.toba.bll.database;

import com.toba.bll.transaction.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}