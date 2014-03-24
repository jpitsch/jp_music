package com.jp.music.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ng_albums")
public class Album {
	
	@Id
	@Column(name="NG_ALBUMS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer albumId;
	
	@ManyToOne
	@JoinColumn(name="NG_SINGERS_ID")
	@NotNull
	private Singer singer;
	
	@Column(name="ALBUM_NAME")
	@NotNull @Size(min=2, max=40)
	private String albumName;
	
	@Column(name="RELEASE_YEAR")
	@NotNull @Size(min=4, max=4)
	private String releaseYear;
	
	@ManyToOne
	@JoinColumn(name="RECORD_COMPANY_ID")
	@NotNull
	private RecordCompany recordCompany;

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public RecordCompany getRecordCompany() {
		return recordCompany;
	}

	public void setRecordCompany(RecordCompany recordCompany) {
		this.recordCompany = recordCompany;
	}
}
