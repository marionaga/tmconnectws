package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hito.mario on 3/21/2017.
 */
@Entity
@Table(name="T_SMS_BROADCAST")
public class TSmsBroadcast {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="POLICY_NUMBER")
    private String policyNumber;

    @Column(name="MOBILE_PHONE")
    private String mobilePhone;

    @Column(name="MESSAGE")
    private String message;

    @Column(name="TYPE_MSG")
    private String typeMsg;

    @Column(name="RESPONSE_CODE")
    private String responseCode;

    @Column(name="CREATEDTIME")
    private Date createdtime;

    @Column(name="SENDTIME")
    private Date sendtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeMsg() {
        return typeMsg;
    }

    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}
