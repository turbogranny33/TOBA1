package com.toba.bll.database;

import com.toba.bll.authentication.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB
{
    public static void insert(User user)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try
        {
            em.persist(user);
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
    
    public static void update(User user)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try
        {
            em.merge(user);
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
    
    public static User selectUser(String userName)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString =    "SELECT u FROM User u " +
                                "WHERE u.userName = :userName";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("userName", userName);

        User user = null;
        try
        {
            user = query.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally
        {
            em.close();
        }
        return user;
    }
}