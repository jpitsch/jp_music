package com.jp.music.dao;

import java.io.Serializable;

import com.jp.music.models.RecordCompany;

public interface RecordCompanyDao extends AbstractDao<RecordCompany, Serializable> {
	void saveRecordCompany(RecordCompany recordCompany);
    RecordCompany findRecordCompanyByName(String recordCompanyName);
}
