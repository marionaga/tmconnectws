package com.id.tmli.intranet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hito.mario on 05/02/2017.
 */
public class SessionUtilMySQL {

    private static SessionUtilMySQL instance=new SessionUtilMySQL();
    private static SessionFactory sessionFactory;
    private static Session session;

    public static SessionUtilMySQL getInstance(){
        return instance;
    }

    private SessionUtilMySQL(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-mysql.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        if(session == null) {
            session =  sessionFactory.openSession();
        }
        return session;
    }

}