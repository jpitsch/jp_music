package com.jp.music.dao;

import java.io.Serializable;

import com.jp.music.singer.model.Singer;

public interface SingerDao extends AbstractDao<Singer, Serializable> {
	void saveSinger(Singer singer);
    Singer findSingerByName(String singerName);
    Singer findSingerByDateOfBirth(String dob);
    Singer findSingerBySex(String sex);
}
