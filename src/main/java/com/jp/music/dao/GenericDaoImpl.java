package com.jp.music.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDaoImpl<E, I extends Serializable> implements AbstractDao<E, Serializable> {

    private Class<E> entityClass;

    protected GenericDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public E findById(Integer id) {
    	getCurrentSession().beginTransaction();
    	E e = (E) getCurrentSession().get(entityClass, id);
    	getCurrentSession().getTransaction().commit();
    	
        return e;
    }
    
    public List<E> findAll() {
    	getCurrentSession().beginTransaction();
    	List<E> list = getCurrentSession().createQuery( "from " + entityClass.getName() ).list(); 
    	getCurrentSession().getTransaction().commit();
    	
        return list; 
     }

    public void saveOrUpdate(E e) {
    	getCurrentSession().beginTransaction();
        getCurrentSession().saveOrUpdate(e);
        getCurrentSession().getTransaction().commit();
    }
    
    public void saveOrUpdateAll(List<E> list) {
    	
    	getCurrentSession().beginTransaction();
    	
    	for(E e : list) {
    		getCurrentSession().saveOrUpdate(e);
    	}
    	
    	getCurrentSession().getTransaction().commit();
    }

    public void delete(E e) {
	    getCurrentSession().beginTransaction();
	    
	    try {
	    	getCurrentSession().delete(e);
	    	getCurrentSession().getTransaction().commit();
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    finally {
	    	getCurrentSession().close();
	    }
    }

    public E findByCriteria(Criterion criterion) {
    	getCurrentSession().beginTransaction();
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        E e = (E)criteria.uniqueResult();
        getCurrentSession().getTransaction().commit();
        
        return e;
    }
    
    public List<E> findByCriteriaList(Criterion criterion) {
    	getCurrentSession().beginTransaction();
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        List<E> e = (List<E>)criteria.list();
        getCurrentSession().getTransaction().commit();
        
        return e;
    }
}
