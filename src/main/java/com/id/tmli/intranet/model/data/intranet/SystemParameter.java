package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hito.mario on 6/12/2017.
 */
@Entity
@Table(name="T_SYS_PARAM")
public class SystemParameter implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -745922731073098582L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    private String paramName;

    private String paramCategory;

    private String modulName;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamCategory() {
        return paramCategory;
    }

    public void setParamCategory(String paramCategory) {
        this.paramCategory = paramCategory;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
