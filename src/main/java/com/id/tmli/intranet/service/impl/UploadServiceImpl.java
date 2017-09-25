package com.id.tmli.intranet.service.impl;

import com.id.tmli.intranet.dao.DocsubmitDao;
import com.id.tmli.intranet.model.data.docsubmit.UploadsNewsDtr;
import com.id.tmli.intranet.model.form.UpdateFileAmendment;
import com.id.tmli.intranet.util.PropertyConfig;
import com.id.tmli.intranet.util.SessionUtilMySQL;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hito.mario on 4/7/2017.
 */
public class UploadServiceImpl {

    @Autowired
    private DocsubmitDao docsubmitDao;

    final static Logger log = Logger.getLogger(UploadServiceImpl.class);
    public void uploadAmanmendFile(UpdateFileAmendment data) throws RuntimeException {
        PropertyConfig pc = new PropertyConfig();
        try {

            String spajNo = data.getSpaj_no();

            if (spajNo != null && spajNo != "") {
                spajNo = data.getSpaj_no();
            } else {
                throw new RuntimeException("303");
            }
            log.info("spajNo : " + spajNo);

            log.info("spaj exists : " + isSpajNoExists(data.getSpaj_no()));

            if (isSpajNoExists(spajNo)) {
                String spajA3s = "";

                UploadsNewsDtr dataBranchDocsubmit = getBranchNameDocSubmit(data.getSpaj_no());

                log.info("Branch : " + isSpajNoExists(dataBranchDocsubmit.getKantorUpload()));

                String subDir = dataBranchDocsubmit.getKantorUpload().replace(" ", "_");
                String filePath = pc.getDirFile();
                File dirout = new File(filePath + File.separator + subDir + File.separator + data.getSpaj_no());
                log.info("Directory Output Directory DTR DOC SUBMIT: " + dirout);

                if (!dirout.exists()) {
                    dirout.mkdirs();
                }


                File fileAmendMend = new File(dirout + File.separator + data.getSpaj_no() + "-SPAJ_a3.pdf");
                UploadsNewsDtr uploadsUpdateData = new UploadsNewsDtr();
                if (!fileAmendMend.exists()) {
                    URL websiteA3 = new URL(data.getFile());
                    ReadableByteChannel a3 = Channels.newChannel(websiteA3.openStream());
                    spajA3s = data.getSpaj_no() + "-SPAJ_a3.pdf";
                    log.info("File A3 : " + dirout + File.separator + spajA3s);
                    FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA3s);
                    fos.getChannel().transferFrom(a3, 0, Long.MAX_VALUE);
                    log.info("Successfull Upload A3 ");
                    fos.close();
                    uploadsUpdateData.setNamaFileA1(dataBranchDocsubmit.getNamaFileA1());
                    uploadsUpdateData.setNamaFileA2(dataBranchDocsubmit.getNamaFileA2());
                    uploadsUpdateData.setNamaFileA3(dataBranchDocsubmit.getNamaFileA3());
                    uploadsUpdateData.setNamaFileA4(dataBranchDocsubmit.getNamaFileA4());
                    uploadsUpdateData.setNamaFileA5(dataBranchDocsubmit.getNamaFileA5());
                    uploadsUpdateData.setNamaFileB1(dataBranchDocsubmit.getNamaFileB1());
                    uploadsUpdateData.setNamaFileB2(dataBranchDocsubmit.getNamaFileB2());
                    uploadsUpdateData.setNamaFileB3(dataBranchDocsubmit.getNamaFileB3());
                    uploadsUpdateData.setNamaFileB4(dataBranchDocsubmit.getNamaFileB4());
                    uploadsUpdateData.setNamaFileB5(dataBranchDocsubmit.getNamaFileB5());
                } else {
                     /*Log Date*/
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMddHHmmss");
                    Date dateNow = new Date();
                    String logDate = dateFormat.format(dateNow);
                    spajA3s = data.getSpaj_no() + "-SPAJ_a3.pdf";
                    fileAmendMend.renameTo(new File(dirout + File.separator + data.getSpaj_no() + "-SPAJ_a3_" + logDate + ".pdf"));

                    URL websiteA3 = new URL(data.getFile());
                    ReadableByteChannel a3 = Channels.newChannel(websiteA3.openStream());
                    log.info("File A3 : " + dirout + File.separator + spajA3s);
                    FileOutputStream fos = new FileOutputStream(dirout + File.separator + spajA3s);
                    fos.getChannel().transferFrom(a3, 0, Long.MAX_VALUE);
                    log.info("Successfull Upload A3 ");
                    fos.close();

                    uploadsUpdateData.setNamaFileA1(dataBranchDocsubmit.getNamaFileA1());
                    uploadsUpdateData.setNamaFileA2(dataBranchDocsubmit.getNamaFileA2());
                    uploadsUpdateData.setNamaFileA3(dataBranchDocsubmit.getNamaFileA3());
                    uploadsUpdateData.setNamaFileA4(dataBranchDocsubmit.getNamaFileA4());
                    uploadsUpdateData.setNamaFileA5(dataBranchDocsubmit.getNamaFileA5());
                    uploadsUpdateData.setNamaFileB1(dataBranchDocsubmit.getNamaFileB1());
                    uploadsUpdateData.setNamaFileB2(dataBranchDocsubmit.getNamaFileB2());
                    uploadsUpdateData.setNamaFileB3(dataBranchDocsubmit.getNamaFileB3());
                    uploadsUpdateData.setNamaFileB4(dataBranchDocsubmit.getNamaFileB4());
                    uploadsUpdateData.setNamaFileB5(dataBranchDocsubmit.getNamaFileB5());
                }
                uploadsUpdateData.setId(dataBranchDocsubmit.getId());
                uploadsUpdateData.setKantorUpload(dataBranchDocsubmit.getKantorUpload());
                uploadsUpdateData.setStatus(dataBranchDocsubmit.getStatus());
                uploadsUpdateData.setNomor(dataBranchDocsubmit.getNomor());
                uploadsUpdateData.setTglUpload(dataBranchDocsubmit.getTglUpload());
                uploadsUpdateData.setUserUpload(dataBranchDocsubmit.getUserUpload());
                uploadsUpdateData.setUserUpdateUpload(data.getUser_update());
                uploadsUpdateData.setSpajNo(data.getSpaj_no());
                uploadsUpdateData.setNamaFileA3(spajA3s);
                uploadsUpdateData.setTglUpdateUpload(new Date());
                uploadsUpdateData.setKategori(dataBranchDocsubmit.getKategori());

                docsubmitDao.updateAmanmend(uploadsUpdateData);

            } else {
                throw new RuntimeException("304");
            }
        } catch (RuntimeException e) {
            log.info("error service Runtime : " + e.getMessage());
            e.printStackTrace();
            if (e.getMessage() == null) {
                throw new RuntimeException("304");
            } else if ("303".equals(e.getMessage())) {
                throw new RuntimeException("303");
            } else if ("508".equals(e.getMessage())) {
                throw new RuntimeException("508");
            }
        } catch (IOException ex) {
            log.info("error service IOException : " + ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException("404");
        }

    }
    public boolean isSpajNoExists(String spajNo) {
        boolean result = false;
        Session session = SessionUtilMySQL.getSession();
        try {
            String queryString = "from UploadsNewsDtr where spajNo = :spajNo";
            Query query = session.createQuery(queryString);
            query.setString("spajNo", spajNo);
            log.info("**** result **** " + query.uniqueResult());
            if (query.uniqueResult() != null) {
                result = true;
            } else {
                return result;
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public UploadsNewsDtr getBranchNameDocSubmit(String spajNo) {

        UploadsNewsDtr uploadsNewsDtr = null;
        Session session = SessionUtilMySQL.getSession();
        try {
            String queryString = "from UploadsNewsDtr where spajNo = :spajNo";
            Query query = session.createQuery(queryString);
            query.setString("spajNo", spajNo);
            uploadsNewsDtr = (UploadsNewsDtr) query.uniqueResult();
            log.info("Kantor upload : " + uploadsNewsDtr.getKantorUpload());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return uploadsNewsDtr;
    }

}
