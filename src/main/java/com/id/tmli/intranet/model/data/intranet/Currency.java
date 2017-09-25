package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hito.mario on 06/02/2017.
 */
@Entity
@Table(name="T_CURRENCY")
public class Currency implements Serializable {


    private static final long serialVersionUID = 7143144569123730804L;


    @Column(name="CURRENCY_ID")
    private String id;

    @Id
    @Column(name="CURRENCY_CODE")
    private String currency_code;

    @Column(name="CURRENCY_DESC")
    private String currency_desc;

    @Column(name="CURRENCY_SYMBOL" )
    private String currency_symbol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_desc() {
        return currency_desc;
    }

    public void setCurrency_desc(String currency_desc) {
        this.currency_desc = currency_desc;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((currency_code == null) ? 0 : currency_code.hashCode());
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
        Currency other = (Currency) obj;
        if (currency_code == null) {
            if (other.currency_code != null)
                return false;
        } else if (!currency_code.equals(other.currency_code))
            return false;
        return true;
    }

}