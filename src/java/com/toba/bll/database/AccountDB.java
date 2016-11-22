package com.toba.bll.database;

import com.toba.bll.transaction.Account;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB
{
    public static void insert(Account account)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try
        {
            em.persist(account);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println(e);
            transaction.rollback();
        }
        finally
        {
            em.close();
        }
    }
    
    public static List<Account> selectAccounts(Long userId)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString =    "SELECT a FROM Account a " +
                                "WHERE a.userID = :userId";
        TypedQuery<Account> query = em.createQuery(queryString, Account.class);
        query.setParameter("userId", userId);

        List<Account> accounts = null;
        try
        {
            accounts = query.getResultList();
            if (accounts == null || accounts.isEmpty())
            {
                accounts = null;
            }
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally
        {
            em.close();
        }
        return accounts;
    }
}