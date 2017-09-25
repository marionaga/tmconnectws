package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hito.mario on 3/21/2017.
 */
@Entity
@Table(name="T_BRANCH_TMCONNECT")
public class TBranchTMConnect {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;

    @Column(name="OFFICE_CODE")
    private String officeCode;

    @Column(name="OFFICE_TYPE")
    private String officeType;

    @Column(name="OFFICE_NAME")
    private String officeName;

    @Column(name="BRANCH_CODE")
    private String branchCode;

    @Column(name="BRANCH_NAME")
    private String branchName;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
