package com.jp.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.music.dao.RecordCompanyDao;
import com.jp.music.models.RecordCompany;

@Service("recordCompanyService")
@Transactional(readOnly = true)
public class RecordCompanyServiceImpl implements RecordCompanyService {

	@Autowired
	RecordCompanyDao recordCompanyDao;
	
	@Override
	public RecordCompany findRecordCompanyById(Integer id) {
		return recordCompanyDao.findById(id);
	}
	
	@Override
	public RecordCompany findRecordCompanyByName(String name) {
		return recordCompanyDao.findRecordCompanyByName(name);
	}

	@Override
	public void saveRecordCompany(RecordCompany company) {
		recordCompanyDao.saveRecordCompany(company);
	}

	@Override
	public void deleteRecordCompany(Integer recordCompanyId) {
		//List<RecordCompany> recordCompanyList = recordCompanyDao.findRecordCompanyByName(companyName);
		RecordCompany recordCompany = recordCompanyDao.findById(recordCompanyId);
		recordCompanyDao.delete(recordCompany);
	}

	@Override
	public List<RecordCompany> findAllRecordCompanies() {
		List<RecordCompany> recordCompanyList = recordCompanyDao.findAll();
		return recordCompanyList;
	}

	@Override
	public void saveAllRecordCompanies(List<RecordCompany> recordCompanyList) {
		recordCompanyDao.saveOrUpdateAll(recordCompanyList);
	}
}
