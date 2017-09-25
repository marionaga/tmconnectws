package com.id.tmli.intranet.util;

import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by hito.mario on 2/28/2017.
 */
public abstract class AbstractBean<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractBean(Class<T> classE) {
        this.entityClass = classE;
    }

    public AbstractBean() {

    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void create(T entity) {
        try {
            this.entityManager.persist(entity);
            this.entityManager.flush();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void createFlush(T entity) {
        try {
            this.entityManager.persist(entity);
            this.entityManager.flush();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void edit(T entity) {
        try {
            this.entityManager.merge(entity);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void remove(T entity) {
        try {
            this.entityManager.remove(this.entityManager.merge(entity));
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
