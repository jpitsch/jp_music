package com.jp.music.dao;

import java.io.Serializable;
import java.util.List;

import com.jp.music.models.Album;
import com.jp.music.models.User;

public interface AlbumDao extends AbstractDao<Album, Serializable> {
	void saveAlbum(Album album);
	Album findAlbumByName(String albumName);
	List<Album> findAblumsBySinger(String singer);
	List<Album> findAlbumsByYear(String year);
	List<Album> findAlbumsByCompany(String company);
}
