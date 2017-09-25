package com.id.tmli.intranet.model.data.intranet;

import com.id.tmli.intranet.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hito.mario on 06/02/2017.
 */
@Entity
@Table(name="T_BRANCH")
public class Branch extends BaseEntity {

    private static final long serialVersionUID = 1520595057418920444L;

    @Column(name="BRANCH_CODE",length=4)
    private String branchCode;

    @Column(name="BRANCH_NAME",length=60)
    private String branchName;


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

}