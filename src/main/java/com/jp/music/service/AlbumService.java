package com.jp.music.service;

import java.util.List;

import com.jp.music.models.Album;

public interface AlbumService {
	Album findAlbumById(Integer id);
	Album findAlbumByName(String albumName);
	List<Album> findAlbumsByYear(String year);
	List<Album> findAlbumsByCompany(String company);
	List<Album> findAlbumsBySinger(String singer);
	
	void saveAlbum(Album album);
	void delteAlbum(Integer id);
	
	List<Album> findAllAlbums();
	void saveAllAblums(List<Album> albumList);
}
