package com.id.tmli.intranet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hito.mario on 05/02/2017.
 */
public class SessionUtilCallidusSqlServer {

    private static SessionUtilCallidusSqlServer instance=new SessionUtilCallidusSqlServer();
    private static SessionFactory sessionFactory;
    private static Session session;

    public static SessionUtilCallidusSqlServer getInstance(){
        return instance;
    }

    private SessionUtilCallidusSqlServer(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-callidus-sql-server.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        if(session == null) {
            session =  sessionFactory.openSession();
        }
        return session;
    }
}