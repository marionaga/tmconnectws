package com.id.tmli.intranet.model.data.intranet;

import com.id.tmli.intranet.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hito.mario
 *
 * Project Module Name : Generate Number SPAJ
 * Project Owner Dept. : Bussiness Process
 * Created 			   : 3/8/2017
 * 
 */

@Entity
@Table(name="T_GENERATE_NUMBER")
public class GenerateNumberSpaj extends BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 6872200391395068379L;
	
	/*@ManyToOne
	@JoinColumn(name="HeadKey")
	private AppCodeSpaj headKey;*/

    @Column(name="HeadKey")
    private String headKey;
	
	@Column(name="Alocate")
	private Integer alocate;
	
	@Column(name="CreateBy")
	private String userCreate;
	
	@Column(name="CreateDate")
	private Date createDate;
	
	@Column(name="FlagFile")
	private Integer flagFile;	
	
	/*@ManyToOne
	@JoinColumn(name="DistId")
	private DistCodeSpaj distribution;*/

    @Column(name="DistId")
    private String distribution;
	
	
	@Transient
    @OneToMany(mappedBy = "ID")
	private List<NumberAppSpaj> listNumber;

    public String getHeadKey() {
        return headKey;
    }

    public void setHeadKey(String headKey) {
        this.headKey = headKey;
    }

    public Integer getAlocate() {
		return alocate;
	}

	public void setAlocate(Integer alocate) {
		this.alocate = alocate;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getFlagFile() {
		return flagFile;
	}

	public void setFlagFile(Integer flagFile) {
		this.flagFile = flagFile;
	}

	/*public DistCodeSpaj getDistribution() {
		return distribution;
	}

	public void setDistribution(DistCodeSpaj distribution) {
		this.distribution = distribution;
	}*/

	public List<NumberAppSpaj> getListNumber() {
		return listNumber;
	}

	public void setListNumber(List<NumberAppSpaj> listNumber) {
		this.listNumber = listNumber;
	}

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
}
