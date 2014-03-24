package com.jp.music.dao;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jp.music.models.RecordCompany;

@Repository
public class RecordCompanyDaoImpl extends GenericDaoImpl<RecordCompany, String> implements RecordCompanyDao {
 
    protected RecordCompanyDaoImpl() {
        super(RecordCompany.class);
    }
 
    @Override
    public void saveRecordCompany(RecordCompany user) {
        saveOrUpdate(user);
    }
 
    @Override
    public RecordCompany findRecordCompanyByName(String companyName) {
        return findByCriteria(Restrictions.like("recordCompanyName", companyName, MatchMode.START));
    }

}