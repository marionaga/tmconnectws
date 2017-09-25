package com.id.tmli.intranet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hito.mario on 05/02/2017.
 */
public class SessionUtilDTRSqlServer {

    private static SessionUtilDTRSqlServer instance=new SessionUtilDTRSqlServer();
    private static SessionFactory sessionFactory;
    private static Session session;

    public static SessionUtilDTRSqlServer getInstance(){
        return instance;
    }

    private SessionUtilDTRSqlServer(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-dtr-sql-server.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        if(session == null) {
            session =  sessionFactory.openSession();
        }
        return session;
    }
}