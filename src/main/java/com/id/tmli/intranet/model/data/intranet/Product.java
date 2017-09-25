package com.id.tmli.intranet.model.data.intranet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCT")
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7494231987329352479L;

    @Id
    @Column(name="ITEM_CODE")
    private String productCode;

    @Column(name="ITEM_NAME")
    private String productName;


    @Column(name="ITEM_TYPE")
    private String productType;

    @Column(name="ITEM_HIDE")
    private String productHide;

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductHide() {
        return productHide;
    }

    public void setProductHide(String productHide) {
        this.productHide = productHide;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productCode == null) ? 0 : productCode.hashCode());
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
        Product other = (Product) obj;
        if (productCode == null) {
            if (other.productCode != null)
                return false;
        } else if (!productCode.equals(other.productCode))
            return false;
        return true;
    }


}
