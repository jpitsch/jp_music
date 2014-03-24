package com.jp.music.service;

import java.util.List;

import com.jp.music.models.RecordCompany;

public interface RecordCompanyService {
	RecordCompany findRecordCompanyById(Integer id);
	RecordCompany findRecordCompanyByName(String name);

	void saveRecordCompany(RecordCompany company);
	void deleteRecordCompany(Integer recordCompanyId);
	
	List<RecordCompany> findAllRecordCompanies();
	void saveAllRecordCompanies(List<RecordCompany> recordCompanyList);
}
