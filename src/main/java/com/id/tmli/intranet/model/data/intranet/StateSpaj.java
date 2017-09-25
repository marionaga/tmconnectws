package com.id.tmli.intranet.model.data.intranet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="T_STATE")
public class StateSpaj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5014361594169859384L;
	
	@Id
	@Column(name="StateId")
	private String id;
	
	@Column(name="NameState")
	private String nameState;
	
	@Column(name="ENUM")
	private String enumState;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public String getEnumState() {
		return enumState;
	}

	public void setEnumState(String enumState) {
		this.enumState = enumState;
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
		StateSpaj other = (StateSpaj) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
