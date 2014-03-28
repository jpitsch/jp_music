package com.jp.music.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jp.music.album.model.Album;

@Repository
public class AlbumDaoImpl extends GenericDaoImpl<Album, Serializable> implements AlbumDao {

	protected AlbumDaoImpl() {
		super(Album.class);
	}
	
	@Override
	public void saveAlbum(Album album) {
		saveOrUpdate(album);
	}
	
	@Override
	public Album findAlbumByName(String albumName) {
		return findByCriteria(Restrictions.like("albumName", albumName, MatchMode.START));
	}
	
	@Override
	public List<Album> findAlbumsByYear(String year) {
		return findByCriteriaList(Restrictions.like("year", year, MatchMode.START));
	}

	@Override
	public List<Album> findAblumsBySinger(String singer) {
		return findByCriteriaList(Restrictions.like("singer", singer, MatchMode.START));
	}

	@Override
	public List<Album> findAlbumsByCompany(String company) {
		return findByCriteriaList(Restrictions.like("company", company, MatchMode.START));
	}
}
