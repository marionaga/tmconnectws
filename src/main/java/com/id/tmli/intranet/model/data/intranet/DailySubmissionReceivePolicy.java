package com.id.tmli.intranet.model.data.intranet;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hito.mario on 06/02/2017.
 */
@Entity
@Table(name = "T_DAILYSUBMIT_POLICY")
public class DailySubmissionReceivePolicy implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -1581061429012928194L;

    @Id
    @Column(name="ID")
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",
            parameters=@Parameter(name="property", value="submission"))
    private Long id;

    @Column(name = "CONTACTED")
    private Boolean contacted;

    @Column(name = "CONTACTED_REMARK")
    private String contactedRemark;

    @Column(name = "POLICY_RECEIVE_STATUS")
    private Boolean policyReceiveStatus;

    @Column(name = "CSA_NUMBER")
    private String csaNumber;

    @Column(name = "CSA_STATUS")
    private String csaStatus;

    @Column(name = "COMPENSATION_REMARK")
    private String compensationRemark;

    @Column(name = "AGENCY_SUPPORT_REMARK")
    private String agencySupportRemark;

    @Column(name = "UNDERWRITING_REMARK")
    private String underwritingRemark;

    @Column(name = "COMPENSATION_REMARK_DATE")
    private Date compensationRemarkDate;

    @Column(name = "AGENCY_SUPPORT_REMARK_DATE")
    private Date agencySupportRemarkDate;

    @Column(name = "UNDERWRITING_REMARK_DATE")
    private Date underwritingRemarkDate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DailySubmission submission;

    @Column(name = "POLICY_SEND_DATE")
    private Date policySendDate;

    @Column(name = "SOA_RECEIVE_DATE")
    private Date soaReceiveDate;

    @Column(name = "UNDERWRITING_RECEIVE_DATE")
    private Date underwritingReceiveDate;

    @Column(name = "LAST_STATUS")
    private String lastStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getContacted() {
        return contacted;
    }

    public void setContacted(Boolean contacted) {
        this.contacted = contacted;
    }

    public String getContactedRemark() {
        return contactedRemark;
    }

    public void setContactedRemark(String contactedRemark) {
        this.contactedRemark = contactedRemark;
    }

    public Boolean getPolicyReceiveStatus() {
        return policyReceiveStatus;
    }

    public void setPolicyReceiveStatus(Boolean policyReceiveStatus) {
        this.policyReceiveStatus = policyReceiveStatus;
    }

    public String getCsaNumber() {
        return csaNumber;
    }

    public void setCsaNumber(String csaNumber) {
        this.csaNumber = csaNumber;
    }

    public String getCsaStatus() {
        return csaStatus;
    }

    public void setCsaStatus(String csaStatus) {
        this.csaStatus = csaStatus;
    }

    public String getCompensationRemark() {
        return compensationRemark;
    }

    public void setCompensationRemark(String compensationRemark) {
        this.compensationRemark = compensationRemark;
    }

    public String getAgencySupportRemark() {
        return agencySupportRemark;
    }

    public void setAgencySupportRemark(String agencySupportRemark) {
        this.agencySupportRemark = agencySupportRemark;
    }

    public String getUnderwritingRemark() {
        return underwritingRemark;
    }

    public void setUnderwritingRemark(String underwritingRemark) {
        this.underwritingRemark = underwritingRemark;
    }

    public Date getCompensationRemarkDate() {
        return compensationRemarkDate;
    }

    public void setCompensationRemarkDate(Date compensationRemarkDate) {
        this.compensationRemarkDate = compensationRemarkDate;
    }

    public Date getAgencySupportRemarkDate() {
        return agencySupportRemarkDate;
    }

    public void setAgencySupportRemarkDate(Date agencySupportRemarkDate) {
        this.agencySupportRemarkDate = agencySupportRemarkDate;
    }

    public Date getUnderwritingRemarkDate() {
        return underwritingRemarkDate;
    }

    public void setUnderwritingRemarkDate(Date underwritingRemarkDate) {
        this.underwritingRemarkDate = underwritingRemarkDate;
    }

    public DailySubmission getSubmission() {
        return submission;
    }

    public void setSubmission(DailySubmission submission) {
        this.submission = submission;
    }

    public Date getPolicySendDate() {
        return policySendDate;
    }

    public void setPolicySendDate(Date policySendDate) {
        this.policySendDate = policySendDate;
    }

    public Date getSoaReceiveDate() {
        return soaReceiveDate;
    }

    public void setSoaReceiveDate(Date soaReceiveDate) {
        this.soaReceiveDate = soaReceiveDate;
    }

    public Date getUnderwritingReceiveDate() {
        return underwritingReceiveDate;
    }

    public void setUnderwritingReceiveDate(Date underwritingReceiveDate) {
        this.underwritingReceiveDate = underwritingReceiveDate;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }
}