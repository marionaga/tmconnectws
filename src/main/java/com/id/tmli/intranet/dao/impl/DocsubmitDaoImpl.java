package com.id.tmli.intranet.dao.impl;

import com.id.tmli.intranet.dao.DocsubmitDao;
import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.service.impl.SendMailServiceImpl;
import com.id.tmli.intranet.util.PropertyConfig;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by hito.mario on 4/7/2017.
 */

@Repository("docsubmitDao")
public class DocsubmitDaoImpl implements DocsubmitDao {
    @Autowired
    @Qualifier("sessionFactoryDocsubmit")
    private SessionFactory sessionFactoryDocsubmit;

    final static Logger log = Logger.getLogger(DocsubmitDaoImpl.class);

    @Transactional(value="transactionManagerDocsubmit", rollbackFor = Exception.class)
    @Override
    public void updateAmanmend(UploadsNewsDtr data) {

        Session sessionDocsubmit = sessionFactoryDocsubmit.openSession();
        Transaction txMysql = sessionDocsubmit.beginTransaction();
        try {
            /* Update SPAJ Docsubmit*/
            System.out.println("**** START UPDATE FILE DTR ****");
            sessionDocsubmit.persist(data);
            System.out.println("**** END UPDATE FILE DTR ****");
            sessionDocsubmit.flush();
            txMysql.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txMysql.rollback();
            sessionDocsubmit.close();
            throw new RuntimeException("508");
        }
        sessionDocsubmit.close();
    }

    @Transactional(value="transactionManagerDocsubmit", rollbackFor = Exception.class)
    @Override
    public int getCountSPAJDocsubmit(String spajNo) {
        SendMailServiceImpl sendNotif = new SendMailServiceImpl();
        PropertyConfig pc = new PropertyConfig();
        Session sessionDocsubmit = sessionFactoryDocsubmit.openSession();
        log.info("Count spaj Doc submit");
        int totalCount = 0;

        try {
            String queryString = "select count(*) from UploadsNewsDtr a where spajNo = :spajNo ";
            Query query = sessionDocsubmit.createQuery(queryString);
            query.setString("spajNo", spajNo);
            log.info("total spaj doc submit : " + ((Long) query.uniqueResult()).intValue());
            totalCount = ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            log.error("Error getCountSPAJDocsubmit database : " + e.getMessage());
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
        sessionDocsubmit.close();
        return totalCount;

    }

}
