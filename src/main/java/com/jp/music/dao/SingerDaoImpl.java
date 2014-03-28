package com.jp.music.dao;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.music.singer.model.Singer;

@Repository
public class SingerDaoImpl extends GenericDaoImpl<Singer, String> implements SingerDao {
	
	protected SingerDaoImpl() {
		super(Singer.class);
	}
	
	@Override
	@Transactional
	public void saveSinger(Singer singer) {
		saveOrUpdate(singer);
	}
	
	@Override
	public Singer findSingerByName(String singerName) {
		return findByCriteria(Restrictions.like("name", singerName, MatchMode.START));
	}
	
	@Override
	public Singer findSingerByDateOfBirth(String dob) {
		return findByCriteria(Restrictions.like("dateOfBirth", dob, MatchMode.START));
	}
	
	@Override
	public Singer findSingerBySex(String sex) {
		return findByCriteria(Restrictions.like("sex", sex, MatchMode.START));
	}

	public List<Singer> returnAll() {
		return findAll();
	}
	
	public void saveAllSingers(List<Singer> list) {
		saveOrUpdateAll(list);
	}
}
