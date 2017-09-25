package com.id.tmli.intranet.dao.impl;

import com.id.tmli.intranet.dao.IntranetDao;
import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.model.data.intranet.*;
import com.id.tmli.intranet.model.form.DailySubmissionForm;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by hito.mario on 3/22/2017.
 */

@Repository("intranetDao")
public class IntranetDaoImpl implements IntranetDao {

    @Autowired
    @Qualifier("sessionFactoryIntranet")
    private SessionFactory sessionFactoryIntranet;

    @Autowired
    @Qualifier("sessionFactoryDocsubmit")
    private SessionFactory sessionFactoryDocsubmit;

    final static Logger log = Logger.getLogger(IntranetDaoImpl.class);

    @Transactional(value = "transactionManagerIntranet",rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    @Override
    public String addSubmissionDao(DailySubmission dailySubmission, UploadsNewsDtr uploadDTR, NumberAppSpaj generateNumberSpaj, DailySubmissionForm bean) throws Exception {
        DailySubmissionLog logSubmit = new DailySubmissionLog();
        UploadsNewsDtr uploadsInsertData = new UploadsNewsDtr();
        DailySubmissionReceivePolicy policySubmit = new DailySubmissionReceivePolicy();
        SendMailServiceImpl sendNotif = new SendMailServiceImpl();
        Session sessionIntranet = sessionFactoryIntranet.openSession();
        Session sessionDocsubmit = sessionFactoryDocsubmit.openSession();
        PropertyConfig pc = new PropertyConfig();
        String result = "";
        /*Transaction txSqlServer = sessionSqlServer.beginTransaction();
        Transaction txMysql = sessionMysql.beginTransaction();*/
        Transaction txIntranet = sessionIntranet.beginTransaction();
        Transaction txDocsubmit = sessionDocsubmit.beginTransaction();


        try {

            /*Insert E-Submission*/
            dailySubmission.setState(new StateSpaj());
            dailySubmission.getState().setId("3");
            dailySubmission.getState().setNameState("Submit");
            dailySubmission.setProcessTime(new Date());
            dailySubmission.setSubmitDate(new Date());
            dailySubmission.setStatusDate(new Date());

            log.info("**** START INSERT T_DAILYSUBMIT ****");
            sessionIntranet.persist(dailySubmission);
            sessionIntranet.flush();
            log.info("**** END INSERT T_DAILYSUBMIT ****");
            log.info("id : " + dailySubmission.getId());
            log.info("**** START INSERT T_DAILYSUBMIT_POLICY ****");
            policySubmit.setSubmission(dailySubmission);
            sessionIntranet.persist(policySubmit);
            log.info("**** END INSERT T_DAILYSUBMIT_POLICY ****");
//
            logSubmit.setSubmission(dailySubmission);
            logSubmit.setProcessTime(new Date());
            logSubmit.setCreateUser(dailySubmission.getCreateUser());
            logSubmit.setState(new StateSpaj());
            logSubmit.getState().setId("3");
            log.info("**** START INSERT T_DAILYSUBMIT_LOG ****");
            sessionIntranet.persist(logSubmit);
            log.info("**** END INSERT T_DAILYSUBMIT_LOG ****");

            /* Insert SPAJ Docsubmit*/
            uploadsInsertData.setTglUpload(new Date());
            uploadsInsertData.setNomor("1");
            uploadsInsertData.setKategori("1");
            uploadsInsertData.setRemarks("");
            uploadsInsertData.setKantorUpload(uploadDTR.getKantorUpload());
            uploadsInsertData.setUserUpload(uploadDTR.getUserUpload());
            uploadsInsertData.setStatus("1");
            uploadsInsertData.setSpajNo(uploadDTR.getSpajNo());
            uploadsInsertData.setNamaFileA1(uploadDTR.getNamaFileA1());
            uploadsInsertData.setNamaFileA2(uploadDTR.getNamaFileA2());
            uploadsInsertData.setNamaFileA3(uploadDTR.getNamaFileA3());
            uploadsInsertData.setNamaFileA4(uploadDTR.getNamaFileA4());
            uploadsInsertData.setNamaFileA5(uploadDTR.getNamaFileA5());
            uploadsInsertData.setNamaFileB1(uploadDTR.getNamaFileB1());
            uploadsInsertData.setNamaFileB2(uploadDTR.getNamaFileB2());
            uploadsInsertData.setNamaFileB3(uploadDTR.getNamaFileB3());
            uploadsInsertData.setNamaFileB4(uploadDTR.getNamaFileB4());
            uploadsInsertData.setNamaFileB5(uploadDTR.getNamaFileB5());
            uploadsInsertData.setUserUpdateUpload("");
            uploadsInsertData.setTglUpdateUpload(null);

            System.out.println("**** START INSERT FILE DTR ****");
            sessionDocsubmit.persist(uploadsInsertData);
            System.out.println("**** END INSERT FILE DTR ****");
            sessionDocsubmit.flush();

            System.out.println("**** START INSERT VA Number ****");
            sessionIntranet.persist(generateNumberSpaj);
            System.out.println("**** END INSERT VA Number ****");
            sessionIntranet.flush();

            txDocsubmit.commit();
            txIntranet.commit();

            sessionIntranet.evict(policySubmit);
            sessionIntranet.evict(dailySubmission);
            result = "OK";

        } catch (Exception e) {

            txDocsubmit.rollback();
            txIntranet.rollback();

            log.error("Error addSubmissionDao database : " + e.getMessage());
            String title = "Error System ";

            StringWriter a = new StringWriter();
            PrintWriter b = new PrintWriter(a);
            e.printStackTrace(b);

            try {
                sendNotif.sendEmailError(title, e.getMessage(), pc.getEmailTo());
            } catch (IOException io) {
                io.printStackTrace();
            }

            result = "NOK";
            throw new RuntimeException("508");
        }
        sessionDocsubmit.close();
        sessionIntranet.close();
        return result;
    }


    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public void addSMSBroadcastPhone(TSmsBroadcast sms) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();

        Transaction txSqlServer = sessionIntranet.beginTransaction();

        try {

           /* Insert SMSBroadcast */
            TSmsBroadcast sendSMS = new TSmsBroadcast();

            sendSMS.setPolicyNumber("");
            sendSMS.setMobilePhone(sms.getMobilePhone());

            sendSMS.setMessage(sms.getMessage());
            sendSMS.setTypeMsg(sms.getTypeMsg());
            sendSMS.setResponseCode("");
            sendSMS.setCreatedtime(new Date());

            System.out.println("**** START INSERT SMS ****");
            sessionIntranet.persist(sendSMS);
            System.out.println("**** END INSERT SMS****");

            /* Insert SPAJ Docsubmit*/


            txSqlServer.commit();

        } catch (Exception e) {

            txSqlServer.rollback();

            log.error("Error addSMSBroadcastPhone database : " + e.getMessage());
            String title = "Error System ";

            StringWriter a = new StringWriter();
            PrintWriter b = new PrintWriter(a);
            e.printStackTrace(b);

            try {
                sendNotif.sendEmailError(title, e.getMessage(), pc.getEmailTo());
            } catch (IOException io) {
                io.printStackTrace();
            }

            throw new RuntimeException("508");

        }
        sessionIntranet.close();

    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public int getCountSpajDailySubmit(String spajNo) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        log.info("Count spaj Daily submit");
        int totalCount = 0;
        try {
            String queryString = "select count(a) from DailySubmission a where spajNo = :spajNo ";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("spajNo", spajNo);
            log.info("Total spaj Daily submit : " + ((Long) query.uniqueResult()).intValue());
            totalCount = ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            log.error("Error getCountSpajDailySubmit database : " + e.getMessage());
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
        sessionIntranet.close();
        return totalCount;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor = Exception.class)
    @Override
    public Product getProductFromProductCode(String productCode) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        Product product = null;
        try {
            String queryString = "from Product where productCode like :productCode and productHide='1' ";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("productCode", "%" + productCode + "%");
            product = (Product) query.uniqueResult();
            log.info("product name : " + product.getProductName());
        } catch (Exception e) {
            log.error("Error getProductFromProductCode database : " + e.getMessage());
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
        sessionIntranet.close();
        return product;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public TBranchTMConnect getBranchCode(String officeCode) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();

        TBranchTMConnect tBranchTMConnect = null;
        try {
            String queryString = "from TBranchTMConnect where officeCode = :officeCode";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("officeCode", officeCode);
            tBranchTMConnect = (TBranchTMConnect) query.uniqueResult();
            log.info("Branch Code TBranchTMConnect: " + tBranchTMConnect.getBranchCode() + "branch name : " + tBranchTMConnect.getBranchName());
        } catch (Exception e) {
            log.error("Error getBranchCode database : " + e.getMessage());
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
        sessionIntranet.close();
        return tBranchTMConnect;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public Branch getBranchFromBranchId(String branchCode) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        log.info("Tbranch BranchCode Input : " + branchCode);
        Branch branch = null;
        try {
            String queryString = "from Branch where branchCode = :branchCode";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("branchCode", branchCode.trim());
            branch = (Branch) query.uniqueResult();
            log.info("Tbranch name : " + branch.getBranchName());
        } catch (Exception e) {

            log.error("Error getBranchFromBranchId database : " + e.getMessage());
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
        sessionIntranet.close();
        return branch;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public Currency getCurrencyFromCurrencyCode(String currencyCode) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        Currency currency = null;
        try {
            String queryString = "from Currency where currency_code = :currencyCode";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("currencyCode", currencyCode);
            currency = (Currency) query.uniqueResult();
            log.info("currency desc : " + currency.getCurrency_desc());
        } catch (Exception e) {
            log.error("Error getCurrencyFromCurrencyCode database : " + e.getMessage());
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
        sessionIntranet.close();
        return currency;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public Long getIdTmConnect() {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Long resultId;
        Session sessionIntranet = sessionFactoryIntranet.openSession();
        GenerateNumberSpaj idTMConnect = null;
        try {
            String queryString = " from GenerateNumberSpaj a where a.headKey='8' ";
            Query query = sessionIntranet.createQuery(queryString);
            idTMConnect = (GenerateNumberSpaj) query.uniqueResult();
            log.info("Id TM Connect  : " + idTMConnect.getId());
        } catch (Exception e) {
            log.error("Error getIdTmConnect database : " + e.getMessage());
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
        resultId = idTMConnect.getId();
        sessionIntranet.close();
        return resultId;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor= Exception.class)
    @Override
    public int getCountNumberApplication(String spajNo) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        log.info("Count Number Application");
        int totalCount = 0;
        try {

            String queryString = "select count(*) from NumberAppSpaj a where genNumber = :spajNo ";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("spajNo", spajNo);
            log.info("total spaj number application : " + ((Long) query.uniqueResult()).intValue());
            totalCount = ((Long) query.uniqueResult()).intValue();

        } catch (Exception e) {
            log.error("Error getCountNumberApplication database : " + e.getMessage());
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
        sessionIntranet.close();
        return totalCount;
    }

    @Transactional(value = "transactionManagerIntranet",rollbackFor = Exception.class)
    @Override
    public Agent getAgentFromAgentCode(String agentCode) {

        SendMailServiceImpl sendNotif = new SendMailServiceImpl();

        PropertyConfig pc = new PropertyConfig();

        Session sessionIntranet = sessionFactoryIntranet.openSession();
        Agent agent = null;
        try {
            String queryString = "from Agent where agentCode = :agentCode";
            Query query = sessionIntranet.createQuery(queryString);
            query.setString("agentCode", agentCode);
            agent = (Agent) query.uniqueResult();
            log.info("agent name : " + agent.getAgentName());
        } catch (Exception e) {
            log.error("Error getAgentFromAgentCode database : " + e.getMessage());
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
        sessionIntranet.close();
        return agent;
    }

}
