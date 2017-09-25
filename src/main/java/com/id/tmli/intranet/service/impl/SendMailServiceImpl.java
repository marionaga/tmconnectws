package com.id.tmli.intranet.service.impl;

import com.id.tmli.intranet.service.SendMailService;
import com.id.tmli.intranet.util.PropertyConfig;
import com.sun.mail.imap.IMAPFolder;
import org.apache.commons.mail.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by hito.mario on 29/12/2016.
 */
public class SendMailServiceImpl implements SendMailService {

    final static Logger log = Logger.getLogger(SendMailServiceImpl.class);


    final static PropertyConfig pc = new PropertyConfig();

    public void sendEmailAttachment(String subject, String message, List<String> listAttachment, String emailTo) {
        try {
//            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
//            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
//            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
//            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
//            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
//            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
//            CommandMap.setDefaultCommandMap(mc);
//
//            Properties properties = new Properties();
//            properties.put("mail.smtp.host", pc.getEmailSmtpHost());
//            properties.put("mail.smtp.port", pc.getEmailSmtpPort());
//            properties.put("mail.smtp.auth", "true");
//
//
//            final String username = pc.getEmailUsernameTMConnect();
//            final String password = pc.getEmailPasswordTMConnect();
//            Authenticator authenticator = new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(username, password);
//                }
//            };
//
//            final Session session = Session.getInstance(properties, authenticator);


            HtmlEmail email = new HtmlEmail();
            email.setHostName(pc.getEmailSmtpHost());
            email.setSmtpPort(pc.getEmailSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(pc.getEmailUsernameTMConnect(), pc.getEmailPasswordTMConnect()));
            email.setFrom(pc.getEmailFromTMConnect());
            email.setSubject(subject);
            email.addTo(emailTo);
            System.out.println("email message:" + message);
            email.setHtmlMsg(message);

            if (listAttachment.size() > 0) {
                for (String listPath : listAttachment) {
                    EmailAttachment attachment = new EmailAttachment();
                    attachment.setPath(listPath);
                    attachment.setDisposition(EmailAttachment.ATTACHMENT);
                    email.attach(attachment);
                }
            }
            email.send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailAgent(String subject, String message, String emailTo) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(pc.getEmailSmtpHost());
            email.setSmtpPort(pc.getEmailSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(pc.getEmailUsernameTMConnect(), pc.getEmailPasswordTMConnect()));
            email.setFrom(pc.getEmailFromTMConnect());
            email.setSubject(subject);
            for (String emailToSender : emailTo.split(";")) {
                email.addTo(emailToSender);
            }
            email.setHtmlMsg(message);
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendEmailError(String subject, String message, String emailTo) {
        log.info("message : "+message);
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName(pc.getEmailSmtpHost());
            email.setSmtpPort(pc.getEmailSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(pc.getEmailUsernameTMConnect(), pc.getEmailPasswordTMConnect()));
            email.setFrom(pc.getEmailFromTMConnect());
            email.setSubject(subject);
            for (String emailToSender : emailTo.split(";")) {
                email.addTo(emailToSender);
            }
            email.setMsg(message);
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
