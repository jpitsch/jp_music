package com.jp.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.music.dao.AlbumDao;
import com.jp.music.models.Album;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	AlbumDao albumDao;
	
	@Override
	public Album findAlbumByName(String albumName) {
		return albumDao.findAlbumByName(albumName);
	}

	@Override
	public List<Album> findAlbumsByYear(String year) {
		return albumDao.findAlbumsByYear(year);
	}

	@Override
	public List<Album> findAlbumsByCompany(String company) {
		return albumDao.findAlbumsByCompany(company);
	}

	@Override
	public List<Album> findAlbumsBySinger(String singer) {
		return albumDao.findAblumsBySinger(singer);
	}

	@Override
	public void saveAlbum(Album album) {
		albumDao.saveAlbum(album);
	}

	@Override
	public void delteAlbum(Integer id) {
		Album album = albumDao.findById(id);
		albumDao.delete(album);
	}

	@Override
	public List<Album> findAllAlbums() {
		return albumDao.findAll();
	}

	@Override
	public void saveAllAblums(List<Album> albumList) {
		albumDao.saveOrUpdateAll(albumList);
	}

	@Override
	public Album findAlbumById(Integer id) {
		return albumDao.findById(id);
	}

}
