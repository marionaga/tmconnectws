package com.id.tmli.intranet.model.data.intranet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hito.mario on 6/15/2017.
 */
@Entity
@Table(name="T_COMPONENT")
public class CoverageComp implements Serializable {

    private static final long serialVersionUID = -1955155596034419740L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="ITEM",length=100)
    private String item;

    @Column(name="ITEMDESC",length=100)
    private String itemDesc;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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
        CoverageComp other = (CoverageComp) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



}
