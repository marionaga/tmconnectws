package com.id.tmli.intranet.service.impl;

import com.id.tmli.intranet.dao.CallidusDao;
import com.id.tmli.intranet.dao.DocsubmitDao;
import com.id.tmli.intranet.dao.IntranetDao;
import com.id.tmli.intranet.model.data.callidus.AgentProfile;
import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.model.data.intranet.*;
import com.id.tmli.intranet.model.form.DailySubmissionForm;
import com.id.tmli.intranet.service.DailySubmissionService;
import com.id.tmli.intranet.util.PropertyConfig;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hito.mario on 3/8/2017.
 */
@Service("dailySubmissionService")
public class DailySubmissionServiceImpl implements DailySubmissionService {

    @Autowired
    @Qualifier("intranetDao")
    IntranetDao intranetDao;

    @Autowired
    @Qualifier("docsubmitDao")
    DocsubmitDao docsubmitDao;

    @Autowired
    @Qualifier("callidusDao")
    CallidusDao callidusDao;

    private Logger log = Logger.getLogger(DailySubmissionServiceImpl.class);
    private DailySubmission spajInsert = new DailySubmission();
    private UploadsNewsDtr dataInsertSpaj = new UploadsNewsDtr();
    private PropertyConfig pc = new PropertyConfig();
    private SendSmsBroadcastServiceImpl sendSms = new SendSmsBroadcastServiceImpl();
    private SendMailServiceImpl sendNotif = new SendMailServiceImpl();

    @Override
    public void insertDataSubmission(DailySubmissionForm bean) throws RuntimeException {
        log.info("Start Process");

        try {
            /*Mandatory branch*/
            String branchId = bean.getBranch_id();

            if (branchId != null && branchId != "") {
                branchId = bean.getBranch_id();
            } else {
                throw new RuntimeException("303");
            }
            log.info("branch : " + bean.getBranch_id());

            /*Mandatory SPAJ NO*/
            String spajNo = bean.getSpaj_no();

            if (spajNo != null && spajNo != "") {
                spajNo = bean.getSpaj_no();
            } else {
                throw new RuntimeException("303");
            }
            log.info("Spaj No : " + bean.getSpaj_no());

            /*Mandatory Agent No*/
            String agentCode = bean.getAgent_code();

            if (agentCode != null && agentCode != "") {
                agentCode = bean.getAgent_code();
            } else {
                throw new RuntimeException("303");
            }
            log.info("Agent : " + bean.getAgent_code());

            /*Mandatory Currentcy*/
            String currency = bean.getCurrency();

            if (currency != null && currency != "") {
                currency = bean.getCurrency();
            } else {
                throw new RuntimeException("303");
            }
            log.info("currency : " + bean.getCurrency());

            /*Mandatory Payment Mode*/
            String pM = bean.getPaymode();

            if (pM != null && pM != "") {
                pM = bean.getPaymode();
            } else {
                throw new RuntimeException("303");
            }
            log.info("paymode : " + bean.getPaymode());


            /*Mandatory Email*/
            String email = bean.getEmail();

            if (email != null && email != "") {
                email = bean.getEmail();
            } else {
                throw new RuntimeException("303");
            }
            log.info("email : " + bean.getEmail());

            /*Mandatory Mobile Phone*/
            String phoneNumber = bean.getPhone_no();

            if (phoneNumber != null && phoneNumber != "") {
                phoneNumber = bean.getPhone_no();
            } else {
                throw new RuntimeException("303");
            }
            log.info("phoneNumber : " + bean.getPhone_no());

            /*Mandatory Product Insurance*/
            String product = bean.getProduct_id();

            if (product != null && product != "") {
                product = bean.getProduct_id();
            } else {
                throw new RuntimeException("303");
            }
            log.info("product insurance : " + bean.getProduct_id());


            /*Mandatory Product Component*//*
            String productComponent = bean.getProduct_id_basic();

            if (productComponent != null && product != "") {
                productComponent = bean.getProduct_id_basic();
            } else {
                throw new RuntimeException("303");
            }
            log.info("product basic insurance : " + bean.getProduct_id_basic());*/

            int countDailySubmit = intranetDao.getCountSpajDailySubmit(spajNo);
            log.info("spaj dailysubmit : " + countDailySubmit);
            int countSPAJDocsubmit = docsubmitDao.getCountSPAJDocsubmit(spajNo);
            log.info("spaj docsubmit : " + countSPAJDocsubmit);
            int countNumberApplication = intranetDao.getCountNumberApplication(spajNo);
            log.info("spaj number application : " + countNumberApplication);

            if (countDailySubmit == 0 && countNumberApplication == 0 && countSPAJDocsubmit == 0) {

                Agent dataAgent = intranetDao.getAgentFromAgentCode(agentCode);
                spajInsert.setAgent(dataAgent);

                log.info("Branch ID Input : " + branchId);

                TBranchTMConnect branchIdTmConnect = intranetDao.getBranchCode(branchId.trim());
                if (branchIdTmConnect == null) {
                    throw new RuntimeException("305");
                }
                log.info("Branch Code : " + branchIdTmConnect.getBranchCode());
                Branch dataBranch = intranetDao.getBranchFromBranchId(branchIdTmConnect.getBranchCode());
                log.info("Branch Code Name : " + dataBranch.getBranchName());


                spajInsert.setBranch(dataBranch);
                spajInsert.setSpajNo(spajNo);
                spajInsert.setPolicyHolder(bean.getPolicy_holder());
                spajInsert.setInsuredName(bean.getInsured());
                spajInsert.setMobileNo(phoneNumber);
                spajInsert.setEmail(email);
                spajInsert.setPaymentMode(pM);
                spajInsert.setSubmitDate(new Date());
                spajInsert.setTypeSpaj("T");
                log.info("PRODUCT ID : " + product);
                Product dataProduct = intranetDao.getProductFromProductCode(product);
                if (dataProduct == null) {
                    throw new RuntimeException("308");
                }
                spajInsert.setProduct(dataProduct);
                log.info("Currency : " + currency);
                Currency dataCurrency = intranetDao.getCurrencyFromCurrencyCode(currency);
                spajInsert.setCurrency(dataCurrency);
                BigDecimal premium = new BigDecimal(bean.getPremium());
                spajInsert.setPremium(premium);
                BigDecimal topupReg = new BigDecimal(bean.getTop_reg());
                spajInsert.setTopupReguler(topupReg);
                BigDecimal topupSekaligus = new BigDecimal(bean.getTop_sekaligus());
                spajInsert.setTopupSingle(topupSekaligus);
                spajInsert.setCreateUser(bean.getUser_upload());
                spajInsert.setProcessTime(new Date());
                spajInsert.setState(new StateSpaj());
                spajInsert.getState().setId("3");
                spajInsert.setStatusDate(new Date());


                List<String> fileEmail = new ArrayList<String>();

                if (!bean.getSpaj_a1().equals("") && !bean.getSpaj_a2().equals("")) {

                    try {
                        log.info("branch name : " + dataBranch.getBranchName());
                        String subDir = dataBranch.getBranchName().replace(" ", "_");
                        String filePath = pc.getDirFile();
                        File dirout = new File(filePath + File.separator + subDir + File.separator + bean.getSpaj_no());
                        log.info("Directory Output Directory DTR DOC SUBMIT: " + dirout);

                        if (!dirout.exists()) {
                            dirout.mkdirs();
                        }


                        String fileOutputEmail = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator;

                        File diroutEmail = new File(fileOutputEmail);
                        System.out.println("Directory Output Directory DTR DOC SUBMIT EMAIL: " + diroutEmail);

                        if (!diroutEmail.exists()) {
                            diroutEmail.mkdirs();
                        }

                        String spajA1s = "";
                        String spajA2s = "";
                        String spajA3s = "";
                        String spajA4s = "";
                        String spajA5s = "";
                        String spajB1s = "";
                        String spajB2s = "";
                        String spajB3s = "";
                        String spajB4s = "";
                        String spajB5s = "";

                        log.info("dir file : " + dirout);
                        log.info("spaj_a1 : " + bean.getSpaj_a1());
                        log.info("spaj_a2 : " + bean.getSpaj_a2());
                        log.info("spaj_a3 : " + bean.getSpaj_a3());
                        log.info("spaj_a4 : " + bean.getSpaj_a4());
                        log.info("spaj_a5 : " + bean.getSpaj_a5());


                        log.info("file a1 & a2 not empty");

                        /*String spajNoPassword = bean.getSpaj_no().substring(bean.getSpaj_no().length() - 2);*/
                        String birthday = bean.getBirth_date_user();
                        String password = birthday.substring(8, 10) + birthday.substring(5, 7) + birthday.substring(2, 4);
                        log.info("result spaj : " + password);


                        if (!bean.getSpaj_a1().equals("")) {

                            URL websiteA1 = new URL(bean.getSpaj_a1());
                            ReadableByteChannel a1 = Channels.newChannel(websiteA1.openStream());
                            spajA1s = bean.getSpaj_no() + "_SPAJ_a1.pdf";
                            log.info("File A1 : " + dirout + File.separator + spajA1s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA1s);
                            fos.getChannel().transferFrom(a1, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload A1 ");
                            fos.close();

                            String pathA1 = dirout + File.separator + spajA1s;
                            PdfReader reader = new PdfReader(pathA1);
                            String pathA1Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_a1.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathA1Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done A1 password");

                            fileEmail.add(pathA1Email);
                        } else {
                            spajA1s = spajA1s;
                        }

                        if (!bean.getSpaj_a2().equals("")) {
                            URL website = new URL(bean.getSpaj_a2());
                            ReadableByteChannel a2 = Channels.newChannel(website.openStream());
                            spajA2s = bean.getSpaj_no() + "_SPAJ_a2.pdf";
                            log.info("File A2 : " + dirout + File.separator + spajA2s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA2s);
                            fos.getChannel().transferFrom(a2, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload A2 ");
                            fos.close();


                            String pathA2 = dirout + File.separator + spajA2s;
                            PdfReader reader = new PdfReader(pathA2);
                            String pathA2Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_a2.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathA2Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done A2 password");
                            fileEmail.add(pathA2Email);
                        } else {
                            spajA2s = spajA2s;
                        }


                        if (!bean.getSpaj_a3().equals("")) {
                            URL website = new URL(bean.getSpaj_a3());
                            ReadableByteChannel a3 = Channels.newChannel(website.openStream());
                            spajA3s = bean.getSpaj_no() + "_SPAJ_a3.pdf";
                            log.info("File A3 : " + dirout + File.separator + spajA3s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA3s);
                            fos.getChannel().transferFrom(a3, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload A3 ");
                            fos.close();

                            String pathA3 = dirout + File.separator + spajA3s;
                            PdfReader reader = new PdfReader(pathA3);
                            String pathA3Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_a3.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathA3Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done A3 password");
                            fileEmail.add(pathA3Email);
                        } else {
                            spajA3s = spajA3s;
                        }

                        if (!bean.getSpaj_a4().equals("")) {
                            URL website = new URL(bean.getSpaj_a4());
                            ReadableByteChannel a4 = Channels.newChannel(website.openStream());
                            spajA4s = bean.getSpaj_no() + "_SPAJ_a4.pdf";
                            log.info("File A4 : " + dirout + File.separator + spajA4s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA4s);
                            fos.getChannel().transferFrom(a4, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload A4 ");
                            fos.close();

                            String pathA4 = dirout + File.separator + spajA4s;
                            PdfReader reader = new PdfReader(pathA4);
                            String pathA4Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_a4.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathA4Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done A4 password");
                            fileEmail.add(pathA4Email);
                        } else {
                            spajA4s = spajA4s;
                        }

                        if (!bean.getSpaj_a5().equals("")) {
                            URL website = new URL(bean.getSpaj_a5());
                            ReadableByteChannel a5 = Channels.newChannel(website.openStream());
                            spajA5s = bean.getSpaj_no() + "_SPAJ_a5.pdf";
                            log.info("File A5 : " + dirout + File.separator + spajA5s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA5s);
                            fos.getChannel().transferFrom(a5, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload A5 ");
                            fos.close();

                            String pathA5 = dirout + File.separator + spajA5s;
                            PdfReader reader = new PdfReader(pathA5);
                            String pathA5Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_a5.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathA5Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done A5 password");
                            fileEmail.add(pathA5Email);
                        } else {
                            spajA5s = spajA5s;
                        }

                        if (!bean.getSpaj_b1().equals("")) {
                            URL websiteB1 = new URL(bean.getSpaj_b1());
                            ReadableByteChannel b1 = Channels.newChannel(websiteB1.openStream());
                            spajB1s = bean.getSpaj_no() + "_SPAJ_b1.pdf";
                            log.info("File B1 : " + dirout + File.separator + spajB1s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajB1s);
                            fos.getChannel().transferFrom(b1, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload B1 ");
                            fos.close();

                            String pathB1 = dirout + File.separator + spajB1s;
                            PdfReader reader = new PdfReader(pathB1);
                            String pathB1Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_b1.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathB1Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done B1 password");
                            fileEmail.add(pathB1Email);
                        } else {
                            spajB1s = spajB1s;
                        }

                        if (!bean.getSpaj_b2().equals("")) {
                            URL websiteB2 = new URL(bean.getSpaj_b2());
                            ReadableByteChannel b2 = Channels.newChannel(websiteB2.openStream());
                            spajB2s = bean.getSpaj_no() + "_SPAJ_b2.pdf";
                            log.info("File B2 : " + dirout + File.separator + spajB2s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajB2s);
                            fos.getChannel().transferFrom(b2, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload B2 ");
                            fos.close();

                            String pathB2 = dirout + File.separator + spajB2s;
                            PdfReader reader = new PdfReader(pathB2);
                            String pathB2Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_b2.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathB2Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done B2 password");
                            fileEmail.add(pathB2Email);
                        } else {
                            spajB2s = spajB2s;
                        }

                        if (!bean.getSpaj_b3().equals("")) {
                            URL websiteB3 = new URL(bean.getSpaj_b3());
                            ReadableByteChannel b3 = Channels.newChannel(websiteB3.openStream());
                            spajB3s = bean.getSpaj_no() + "_SPAJ_b3.pdf";
                            log.info("File B3 : " + dirout + File.separator + spajB3s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajB3s);
                            fos.getChannel().transferFrom(b3, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload B3 ");
                            fos.close();

                            String pathB3 = dirout + File.separator + spajB3s;
                            PdfReader reader = new PdfReader(pathB3);
                            String pathB3Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_b3.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathB3Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done B3 password");
                            fileEmail.add(pathB3Email);
                        } else {
                            spajB3s = spajB3s;
                        }

                        if (!bean.getSpaj_b4().equals("")) {
                            URL websiteB4 = new URL(bean.getSpaj_b4());
                            ReadableByteChannel b4 = Channels.newChannel(websiteB4.openStream());
                            spajB4s = bean.getSpaj_no() + "_SPAJ_b4.pdf";
                            log.info("File B4 : " + dirout + File.separator + spajB4s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajB4s);
                            fos.getChannel().transferFrom(b4, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload B4 ");
                            fos.close();

                            String pathB4 = dirout + File.separator + spajB4s;
                            PdfReader reader = new PdfReader(pathB4);
                            String pathB4Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_b4.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathB4Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done B4 password");
                            fileEmail.add(pathB4Email);
                        } else {
                            spajB4s = spajB4s;
                        }

                        if (!bean.getSpaj_b5().equals("")) {
                            URL websiteB5 = new URL(bean.getSpaj_b5());
                            ReadableByteChannel b5 = Channels.newChannel(websiteB5.openStream());
                            spajB5s = bean.getSpaj_no() + "_SPAJ_b5.pdf";
                            log.info("File B5 : " + dirout + File.separator + spajB5s);
                            FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajB5s);
                            fos.getChannel().transferFrom(b5, 0, Long.MAX_VALUE);
                            log.info("Successfull Upload B5 ");
                            fos.close();

                            String pathB5 = dirout + File.separator + spajB5s;
                            PdfReader reader = new PdfReader(pathB5);
                            String pathB5Email = pc.getDirFileTemp() + bean.getSpaj_no() + File.separator + bean.getSpaj_no() + "-SPAJ_b5.pdf";
                            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathB5Email));
                            stamper.setEncryption(password.getBytes(), null, PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
                            stamper.close();
                            reader.close();
                            log.info("Done B5 password");
                            fileEmail.add(pathB5Email);
                        } else {
                            spajB5s = spajB5s;
                        }


                        dataInsertSpaj.setSpajNo(spajNo);
                        dataInsertSpaj.setNamaFileA1(spajA1s);
                        dataInsertSpaj.setNamaFileA2(spajA2s);
                        dataInsertSpaj.setNamaFileA3(spajA3s);
                        dataInsertSpaj.setNamaFileA4(spajA4s);
                        dataInsertSpaj.setNamaFileA5(spajA5s);
                        dataInsertSpaj.setNamaFileB1(spajB1s);
                        dataInsertSpaj.setNamaFileB2(spajB2s);
                        dataInsertSpaj.setNamaFileB3(spajB3s);
                        dataInsertSpaj.setNamaFileB4(spajB4s);
                        dataInsertSpaj.setNamaFileB5(spajB5s);
                        dataInsertSpaj.setUserUpload(bean.getUser_upload());
                        dataInsertSpaj.setKantorUpload(dataBranch.getBranchName());


                        log.info("Start Send SMS VA Customer");
                        if (phoneNumber.startsWith("0")) {
                            phoneNumber = phoneNumber.replaceFirst("0", "62");
                        }


                        String nominal = bean.getPremium();
                        String noVA = bean.getVa_number();
                        System.out.println("VA_NUMBER : " + noVA);
                        String type_va = bean.getType_va();
                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                        Double nm = Double.parseDouble(nominal);

                        String template = "";
                        if (type_va.equals("S")) {
                            template = pc.getTemplateSyariah();
                        } else if (type_va.equals("C")) {
                            template = pc.getTemplateConventional();
                        }

                        List<NumberAppSpaj> dataSPAJ = new ArrayList<NumberAppSpaj>();

                        NumberAppSpaj TNumberApplicationData = new NumberAppSpaj();


                        TNumberApplicationData.setProcessId(intranetDao.getIdTmConnect());
                        String headKey = String.valueOf(bean.getSpaj_no().charAt(0));
                        String keyNumber = bean.getSpaj_no().substring(bean.getSpaj_no().length() - 1);
                        String sequenceNumber = bean.getSpaj_no().substring(1, bean.getSpaj_no().length() - 1);
                        System.out.println("SpajNo : " + bean.getSpaj_no() + "headKey : " + headKey + " keyNumber : " + keyNumber + " sequenceNumber : " + sequenceNumber);
                        TNumberApplicationData.setHeadKey(headKey);
                        TNumberApplicationData.setSequenceNumber(sequenceNumber);
                        TNumberApplicationData.setKeyNumber(keyNumber);
                        TNumberApplicationData.setCreateUser("TMConnect");
                        TNumberApplicationData.setProcessTime(new Date());
                        TNumberApplicationData.setGenNumber(bean.getSpaj_no());
                        TNumberApplicationData.setVa(bean.getVa_number());
                        TNumberApplicationData.setIsUse(0);

                        dataSPAJ.add(TNumberApplicationData);

                        log.info("**** Start INSERT DATABSE****");

                        String resultTransDB = intranetDao.addSubmissionDao(spajInsert, dataInsertSpaj, TNumberApplicationData, bean);
                        if (resultTransDB.equals("OK")) {

                            String sendMessage = template.replace("[nova]", noVA).replace("[nominal]", formatter.format(Math.ceil(nm)));

                            String url = pc.getUrlSms() + "?userid=" + pc.getUserIdSms() + "&password=" + pc.getPasswordSms() + "&original=" + pc.getMaskingSms() + "&sendto=" + phoneNumber + "&messageid=" + spajNo + "&message=" + URLEncoder.encode(sendMessage, "UTF-8");

                            String resultCode = sendSms.sendSMS(url);

                            if (resultCode.equals("000")) {
                                String typeMessage = "TMCONNECTVA";
                                TSmsBroadcast dataInsertSMS = new TSmsBroadcast();
                                dataInsertSMS.setMobilePhone(phoneNumber);
                                dataInsertSMS.setMessage(sendMessage);
                                dataInsertSMS.setTypeMsg(typeMessage);
                                dataInsertSMS.setResponseCode(resultCode);
                                intranetDao.addSMSBroadcastPhone(dataInsertSMS);
                                log.info("End Send SMS VA Customer");

                            /*Start Insert data T_NUMBER_APPLICATION For SPAJ AND VA NUMBER */

                                log.info("**** Start Send EMAIL ****");
//                            CoverageComp dataProductComponent = getProductComponentFromProductCode(productComponent);
                                sendEmail(bean, dataProduct, dataAgent, fileEmail);
                                log.info("**** END Send EMAIL ****");


                            } else {
                                String typeMessage = "TMCONNECTVA";
                                TSmsBroadcast dataInsertSMS = new TSmsBroadcast();
                                dataInsertSMS.setMobilePhone(phoneNumber);
                                dataInsertSMS.setMessage(sendMessage);
                                dataInsertSMS.setTypeMsg(typeMessage);
                                dataInsertSMS.setResponseCode(resultCode);
                                intranetDao.addSMSBroadcastPhone(dataInsertSMS);
                                throw new RuntimeException("509");
                            }

                        }
                        log.info("**** End INSERT DATABSE****");

                    } catch (Exception ex) {
                        throw new RuntimeException("508");
                    }

                } else {
                    throw new RuntimeException("407");
                }

            } else {
                throw new RuntimeException("408");
            }


        } catch (Exception ex) {
            log.error("Error sendEmail database : " + ex.getMessage());
            String title = "Error System ";
            StringWriter a = new StringWriter();
            PrintWriter b = new PrintWriter(a);
            ex.printStackTrace(b);


            String messageError = "";
            try {

                if ("407".equals(ex.getMessage())) {
                    throw new RuntimeException("407");
                } else if ("408".equals(ex.getMessage())) {
                    throw new RuntimeException("408");
                } else if ("508".equals(ex.getMessage())) {
                    messageError = "Error insert database Database Exception : " + ex.getMessage();
                    throw new RuntimeException("508");
                } else if ("409".equals(ex.getMessage())) {
                    messageError = "Error Send email Customer / Owner Exception : " + ex.getMessage();
                    throw new RuntimeException("409");
                } else if ("509".equals(ex.getMessage())) {
                    messageError = "Error Send SMS Exception : " + ex.getMessage();
                    throw new RuntimeException("509");
                } else if ("303".equals(ex.getMessage())) {
                    throw new RuntimeException("303");
                } else if ("305".equals(ex.getMessage())) {
                    messageError = "Branch Not Found Exception : " + ex.getMessage();
                    throw new RuntimeException("305");
                } else if ("306".equals(ex.getMessage())) {
                    messageError = "Product Not Found Exception : " + ex.getMessage();
                    throw new RuntimeException("306");
                } else if (ex.getMessage() == null) {
                    throw new RuntimeException("304");
                }

                sendNotif.sendEmailError(title, messageError, pc.getEmailTo());
            } catch (IOException io) {
                io.printStackTrace();
            }


        }
        log.info("Done Process");

    }

    public void sendEmail(DailySubmissionForm bean, Product dataProduct, Agent dataAgent, List<String> fileEmail) {
        PropertyConfig pc = new PropertyConfig();
        try {
            /*Send Email to Customer*/
            BufferedReader brCust = null;
            FileReader frCust = null;
            File fileBodyEmail = new File(pc.getDirFileTemplateEmailCustomer());
            frCust = new FileReader(fileBodyEmail.getAbsoluteFile());
            brCust = new BufferedReader(frCust);

            String sCurrentLine;

            String e_ilustrasi_number = bean.getIlustration_no();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dateNow = new Date();
            String dateNowFormat = dateFormat.format(dateNow);
            String spajNum = bean.getSpaj_no();
            String nameProduct = dataProduct.getProductName().trim();
            String namaTertanggung = bean.getInsured();

            String FC_Name = dataAgent.getAgentName();
            String FC_Ph = dataAgent.getMobileNumber();
            if (FC_Ph == null) {
                FC_Ph = "";
            }

            String line = "";

            while ((sCurrentLine = brCust.readLine()) != null) {
                line += sCurrentLine.replace("[E-Ilustrasi number]", e_ilustrasi_number).replace("[E-Ilustrasi date]", dateNowFormat).replace("[E-SPAJ number]", spajNum).replace("[E-SPAJ date]", dateNowFormat).replace("[product name]", nameProduct).replace("[insured name]", namaTertanggung).replace("[FC Name]", FC_Name).replace("[FC HP]", FC_Ph) + "\n";
            }

            String titleMail = "E-SPAJ-" + bean.getSpaj_no() + "-" + dataProduct.getProductName() + "-" + bean.getPolicy_holder();

            SendMailServiceImpl sendMail = new SendMailServiceImpl();
            log.info("Start Email Customer");
            log.info("line message customer:" + line);
            sendMail.sendEmailAttachment(titleMail, line, fileEmail, bean.getEmail());
            log.info("End Email Customer");

            Thread.sleep(100);

            log.info("Start Email Leader");

            AgentProfile dataAgentProfile = callidusDao.getAgentCallidusFromAgentCode(bean.getAgent_code());

            BufferedReader brLeader = null;
            FileReader frLeader = null;
            File fileBodyEmailLeader = new File(pc.getDirFileTemplateEmailLeader());
            frLeader = new FileReader(fileBodyEmailLeader.getAbsoluteFile());
            brLeader = new BufferedReader(frLeader);

            String sCurrentLineLeader;

            String FC_Name_leader = dataAgentProfile.getLgivname() + " " + dataAgentProfile.getLsurname();

            String emailLeader = dataAgentProfile.getRinternet();

            log.info("agent leader : " + FC_Name_leader + " email : " + emailLeader);

            Double totalPremium = 0.00;
            Double totalTopupReguler = 0.00;
            Double total = 0.00;

            totalPremium = Double.parseDouble(bean.getPremium());
            totalTopupReguler = Double.parseDouble(bean.getTop_reg());
            total = totalPremium + totalTopupReguler;

            log.info("total : " + total);

            String lineLeader = "";

            String freq = getBillFreq(bean.getPaymode());

            log.info("frequensi pembayaran : " + freq);

            log.info("String.valueOf(total.longValue()) : " + String.valueOf(total.longValue()));
            log.info("convert premium : " + String.format("%,.2f", Double.parseDouble(bean.getPremium())));
            log.info("convert Top up : " + String.format("%,.2f", Double.parseDouble(bean.getTop_reg())));
            log.info("convert total : " + String.format("%,.2f", total));

            while ((sCurrentLineLeader = brLeader.readLine()) != null) {
                lineLeader += sCurrentLineLeader.replace("[FC name]", dataAgent.getAgentName()).replace("[FC code]", bean.getAgent_code()).replace("[E-SPAJ number]", bean.getSpaj_no()).replace("[product name]", dataProduct.getProductName().trim()).replace("[policyholder name]", bean.getPolicy_holder()).replace("[insured name]", bean.getInsured()).replace("[frequency of premium]", freq).replace("[regular premium]", String.format("%,.2f", Double.parseDouble(bean.getPremium()))).replace("[regular top up]", String.format("%,.2f", Double.parseDouble(bean.getTop_reg()))).replace("[reguler total]", String.format("%,.2f", total)) + "\n";
            }

            String titleMailLeader = "E-SPAJ-" + bean.getSpaj_no() + "-" + dataProduct.getProductName() + "-" + bean.getPolicy_holder();
            log.info("line message leader:" + lineLeader);
            sendMail.sendEmailAgent(titleMailLeader, lineLeader, emailLeader);
            log.info("End Email Leader");
        } catch (Exception e) {
            log.error("Error sendEmail database : " + e.getMessage());
            String title = "Error System ";

            StringWriter a = new StringWriter();
            PrintWriter b = new PrintWriter(a);
            e.printStackTrace(b);

            try {
                sendNotif.sendEmailError(title, e.getMessage(), pc.getEmailTo());
            } catch (IOException io) {
                io.printStackTrace();
            }

            throw new RuntimeException("409");

        }


    }

    public String getBillFreq(String code) {
        if (code.equals("Y")) {
            return "Tahunan";
        }
        if (code.equals("Q")) {
            return "Triwulanan";
        }
        if (code.equals("SA")) {
            return "Semesteran";
        }
        if (code.equals("S")) {
            return "Single";
        }
        return "Bulanan";
    }
}
