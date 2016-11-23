package com.toba.bll.database;

import com.toba.bll.authentication.User;
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
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        try
        {
            em.persist(account);
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

    public static void update(Account account)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        try
        {
            em.merge(account);
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

    public static Account selectAccount(Long accountId)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString =    "SELECT a FROM Account a " +
                                "WHERE a.accountId = :accountId";
        TypedQuery<Account> query = em.createQuery(queryString, Account.class);
        query.setParameter("accountId", accountId);

        Account account = null;
        try
        {
            account = query.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally
        {
            em.close();
        }
        return account;
    }
    
    public static List<Account> selectAccounts(User user)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString =    "SELECT a FROM Account a " +
                                "WHERE a.accountOwner = :user";
        TypedQuery<Account> query = em.createQuery(queryString, Account.class);
        query.setParameter("user", user);

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