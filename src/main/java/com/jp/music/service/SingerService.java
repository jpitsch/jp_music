package com.jp.music.service;

import java.util.List;

import com.jp.music.models.Singer;

public interface SingerService {
	Singer findSingerById(Integer id);
	Singer findSingerByName(String name);
	Singer findSingerByDateOfBirth(String dob);
	Singer findSingerBySex(String sex);
	
	void saveSinger(Singer singer);
	void deleteSinger(Integer id);
	
	List<Singer> findAllSingers();
	void saveAllSingers(List<Singer> singerList);
}
