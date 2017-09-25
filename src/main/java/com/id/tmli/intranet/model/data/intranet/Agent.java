package com.id.tmli.intranet.model.data.intranet;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_AGENT")
public class Agent implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 119028293163695276L;

    @Id
    private Long id;

    @Column(name="AGENT_CODE")
    private String agentCode;

    @Column(name="AGENT_NAME")
    private String agentName;

    @Column(name="AGENT_AREA")
    private String agentArea;

    @Column(name="AGENT_BRANCH")
    private String agentBranch;

    @Column(name="AGENT_LEVEL")
    private String agentLevel;

    @Column(name="RD_CODE")
    private String agentRDCode;

    @Column(name="RD_NAME")
    private String agentRDName;

    @Column(name="RM_CODE")
    private String agentRMCode;

    @Column(name="RM_NAME")
    private String agentRMName;

    @Column(name="DM_CODE")
    private String agentDMCode;

    @Column(name="DM_NAME")
    private String agentDMName;

    @Column(name="SM_CODE")
    private String agentSMCode;

    @Column(name="SM_NAME")
    private String agentSMName;

    @Column(name="REPORTAG")
    private String agentReport;

    @Column(name="RECRT_DATE")
    private Date recruitDate;

    @Column(name="TRMNT_DATE")
    private Date terminateDate;

    @Column(name="MOBILE_NO")
    private String mobileNumber;

    @Column(name="EMAIL")
    private String email;

    @Column(name="STATUS", length=30)
    private String status;

    @Column(name="RESIGN_DATE")
    private Date resignDate;

    @Column(name = "STATUS_TERMINATE")
    private String status_terminate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAgentCode() {
        return agentCode;
    }
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    public String getAgentName() {
        return agentName;
    }
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    public String getAgentArea() {
        return agentArea;
    }
    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }
    public String getAgentBranch() {
        return agentBranch;
    }
    public void setAgentBranch(String agentBranch) {
        this.agentBranch = agentBranch;
    }
    public String getAgentLevel() {
        return agentLevel;
    }
    public void setAgentLevel(String agentLevel) {
        this.agentLevel = agentLevel;
    }
    public String getAgentRDCode() {
        return agentRDCode;
    }
    public void setAgentRDCode(String agentRDCode) {
        this.agentRDCode = agentRDCode;
    }
    public String getAgentRDName() {
        return agentRDName;
    }
    public void setAgentRDName(String agentRDName) {
        this.agentRDName = agentRDName;
    }
    public String getAgentRMCode() {
        return agentRMCode;
    }
    public void setAgentRMCode(String agentRMCode) {
        this.agentRMCode = agentRMCode;
    }
    public String getAgentRMName() {
        return agentRMName;
    }
    public void setAgentRMName(String agentRMName) {
        this.agentRMName = agentRMName;
    }
    public String getAgentDMCode() {
        return agentDMCode;
    }
    public void setAgentDMCode(String agentDMCode) {
        this.agentDMCode = agentDMCode;
    }
    public String getAgentDMName() {
        return agentDMName;
    }
    public void setAgentDMName(String agentDMName) {
        this.agentDMName = agentDMName;
    }

    public String getAgentSMCode() {
        return agentSMCode;
    }

    public void setAgentSMCode(String agentSMCode) {
        this.agentSMCode = agentSMCode;
    }

    public String getAgentSMName() {
        return agentSMName;
    }

    public void setAgentSMName(String agentSMName) {
        this.agentSMName = agentSMName;
    }

    public String getAgentReport() {
        return agentReport;
    }

    public void setAgentReport(String agentReport) {
        this.agentReport = agentReport;
    }

    public Date getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(Date recruitDate) {
        this.recruitDate = recruitDate;
    }

    public Date getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(Date terminateDate) {
        this.terminateDate = terminateDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getResignDate() {
        return resignDate;
    }
    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    public String getStatus_terminate() {
        return status_terminate;
    }
    public void setStatus_terminate(String status_terminate) {
        this.status_terminate = status_terminate;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agent other = (Agent) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



}
