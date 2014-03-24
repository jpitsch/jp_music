package com.jp.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.music.dao.SingerDao;
import com.jp.music.models.Singer;

@Service("singerService")
@Transactional(readOnly = true)
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDao singerDao;
	
	@Override
	public Singer findSingerByName(String singerName) {
		return singerDao.findSingerByName(singerName);
	}

	@Override
	public Singer findSingerByDateOfBirth(String dob) {
		return singerDao.findSingerByDateOfBirth(dob);
	}

	@Override
	public Singer findSingerBySex(String sex) {
		return singerDao.findSingerBySex(sex);
	}

	@Override
	public void saveSinger(Singer singer) {
		singerDao.saveSinger(singer);
	}

	@Override
	public void deleteSinger(Integer id) {
		Singer singer = singerDao.findById(id);
		singerDao.delete(singer);
	}

	@Override
	public List<Singer> findAllSingers() {
		List<Singer> singerList = singerDao.findAll();
		return singerList;
	}

	@Override
	public void saveAllSingers(List<Singer> singerList) {
		singerDao.saveOrUpdateAll(singerList);
	}

	@Override
	public Singer findSingerById(Integer id) {
		return singerDao.findById(id);
	}
}
