package com.toba.bll.database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tobaPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}