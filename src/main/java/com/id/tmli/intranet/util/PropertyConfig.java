package com.id.tmli.intranet.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {
    Properties prop = new Properties();

    public String getEmailSmtpHost() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("mail.smtp.host");
        return output;
    }
    public int getEmailSmtpPort() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        int output = Integer.parseInt(prop.getProperty("mail.smtp.port"));
        return output;
    }

    public String getDirFile() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("dtr.upload");
        return output;
    }

    public String getEmailUsernameTMConnect() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("mail.username.tmconnect");
        return output;
    }

    public String getEmailPasswordTMConnect() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("mail.password.tmconnect");
        return output;
    }
    public String getEmailFromTMConnect() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("mail.from.tmconnect");
        return output;
    }
    public String getDirFileTemp() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("dir.file.email");
        return output;
    }
    public String getDirFileTemplateEmailCustomer() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("file.template.customer");
        return output;
    }

    public String getDirFileTemplateEmailLeader() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("file.template.leader");
        return output;
    }

    public String getTemplateConventional() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("template.sms.conventional");
        return output;
    }

    public String getTemplateSyariah() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("template.sms.syariah");
        return output;
    }

    public String getUrlSms() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("url.sms.broadcast");
        return output;
    }

    public String getUserIdSms() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("user.id.sms");
        return output;
    }

    public String getPasswordSms() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("user.pass.sms");
        return output;
    }

    public String getMaskingSms() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("masking.sms");
        return output;
    }
    public String getEmailTo() throws IOException {
        Config cfg = new Config();
        cfg.getProperties(prop);
        String output = prop.getProperty("mail.sendto");
        return output;
    }
}