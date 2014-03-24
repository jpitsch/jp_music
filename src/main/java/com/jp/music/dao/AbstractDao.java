package com.jp.music.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface AbstractDao<E, I extends Serializable> {

    E findById(Integer id);
    public List<E> findAll();
    void saveOrUpdate(E e);
    void saveOrUpdateAll(List<E> list);
    void delete(E e);
    E findByCriteria(Criterion criterion);
}
