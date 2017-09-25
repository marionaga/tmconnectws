package com.id.tmli.intranet.dao.impl;

import com.id.tmli.intranet.dao.CallidusDao;
import com.id.tmli.intranet.model.data.callidus.AgentProfile;
import com.id.tmli.intranet.service.impl.SendMailServiceImpl;
import com.id.tmli.intranet.util.PropertyConfig;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by hito.mario on 3/22/2017.
 */

@Repository("callidusDao")
public class CallidusDaoImpl implements CallidusDao {

    @Autowired
    @Qualifier("sessionFactoryCallidus")
    private SessionFactory sessionFactoryCallidus;

    final static Logger log = Logger.getLogger(CallidusDaoImpl.class);


    @Transactional(value = "transactionManagerCallidus",rollbackFor = Exception.class)
    @Override
    public AgentProfile getAgentCallidusFromAgentCode(String agentCode) {
        SendMailServiceImpl sendNotif = new SendMailServiceImpl();
        PropertyConfig pc = new PropertyConfig();
        Session sessionCallidus = sessionFactoryCallidus.openSession();
        AgentProfile agent = null;
        try {
            String queryString = " from AgentProfile where payeeid = (select reportag from AgentProfile where payeeid=:agentCode)";
            Query query = sessionCallidus.createQuery(queryString);
            query.setString("agentCode", agentCode);
            agent = (AgentProfile) query.uniqueResult();
            log.info("agent name : " + agent.getLsurname());
        } catch (Exception e) {
            log.error("Error getAgentCallidusFromAgentCode database : " + e.getMessage());
            String title = "Error System ";

            StringWriter a = new StringWriter();
            PrintWriter b = new PrintWriter(a);
            e.printStackTrace(b);

            try {
                sendNotif.sendEmailError(title, e.getMessage(), pc.getEmailTo());
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        sessionCallidus.close();
        return agent;
    }

}
