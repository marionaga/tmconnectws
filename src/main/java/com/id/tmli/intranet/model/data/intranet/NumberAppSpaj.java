package com.id.tmli.intranet.model.data.intranet;

import com.id.tmli.intranet.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_NUMBER_APPLICATION")
public class NumberAppSpaj extends BaseEntity implements Serializable {


	private static final long serialVersionUID = 5507970041889300196L;
	
	/*@ManyToOne
	@JoinColumn(name="Process_id")
	private GenerateNumberSpaj process;*/

    @Column(name="Process_id")
    private Long processId;
	
	@Column(name="HeadKey")
	private String headKey;
	
	@Column(name="SequenceNumber")
	private String sequenceNumber;
	
	@Column(name="KeyNumber")
	private String keyNumber;
	
	@Column(name="GenNumber")
	private String genNumber;
	
	@Column(name="isUse")
	private Integer isUse;
	
	@Column(name="VirtualAccount")
	private String va;

	/*public GenerateNumberSpaj getProcess() {
		return process;
	}

	public void setProcess(GenerateNumberSpaj process) {
		this.process = process;
	}*/

	public String getHeadKey() {
		return headKey;
	}

	public void setHeadKey(String headKey) {
		this.headKey = headKey;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getKeyNumber() {
		return keyNumber;
	}

	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
	}

	public String getGenNumber() {
		return genNumber;
	}

	public void setGenNumber(String genNumber) {
		this.genNumber = genNumber;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getVa() {
		return va;
	}

	public void setVa(String va) {
		this.va = va;
	}

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }
}
