package com.id.tmli.intranet.model.data.intranet;

import com.id.tmli.intranet.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="T_DIST_CHANEL")
public class DistCodeSpaj extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6810613878723159932L;
	
/*
	@Column(name="ID")
	private String distId;
*/

	@Column(name="DistName")
	private String distName;

/*
	public String getDistId() {
		return distId;
	}

	public void setDistId(String distId) {
		this.distId = distId;
	}
*/

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}
	
	
}
