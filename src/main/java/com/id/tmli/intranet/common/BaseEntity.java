package com.id.tmli.intranet.common;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hito.mario on 06/02/2017.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {


    private static final long serialVersionUID = 1247447748660129845L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATEDTIME")
    private Date processTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATETIME")
    private Date updateTime;

    @Column(name="CREATEUSER")
    private String createUser;

    @Column(name="UPDATEUSER")
    private String updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



}