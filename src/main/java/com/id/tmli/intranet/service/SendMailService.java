package com.id.tmli.intranet.service;

import java.util.List;

/**
 * Created by hito.mario on 9/21/2017.
 */
public interface SendMailService {

    public void sendEmailAttachment(String subject, String message, List<String> listAttachment, String emailTo);
    public void sendEmailAgent(String subject, String message, String emailTo);
    public void sendEmailError(String subject, String message, String emailTo);

}
