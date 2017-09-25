package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="T_FORM_CODE")
public class AppCodeSpaj implements Serializable {

	
	private static final long serialVersionUID = 8657250594538317355L;
	
	@Id
	@Column(name="HeadKey")
	private String headKey;
	
	@Column(name="FormName")
	private String formName;
	
	@Column(name="DistName")
	private String distName;
	
	@Column(name="DistId")
	private Long id;
	
	
	public String getHeadKey() {
		return headKey;
	}

	public void setHeadKey(String headKey) {
		this.headKey = headKey;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((headKey == null) ? 0 : headKey.hashCode());
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
		AppCodeSpaj other = (AppCodeSpaj) obj;
		if (headKey == null) {
			if (other.headKey != null)
				return false;
		} else if (!headKey.equals(other.headKey))
			return false;
		return true;
	}

}
