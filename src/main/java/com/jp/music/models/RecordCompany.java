package com.jp.music.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ng_recordcompany")
public class RecordCompany {
	
	@Id
	@Column(name="NG_RECORD_COMPANY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recordCompanyId;
	
	@Column(name="RECORD_COMPANY_NAME")
	@NotNull @Size(min=2, max=20)
	private String recordCompanyName;
	
	@OneToMany(mappedBy="recordCompany", fetch = FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Album> albumList;

	public Integer getRecordCompanyId() {
		return recordCompanyId;
	}

	public void setRecordCompanyId(Integer recordCompanyId) {
		this.recordCompanyId = recordCompanyId;
	}

	public String getRecordCompanyName() {
		return recordCompanyName;
	}

	public void setRecordCompanyName(String recordCompanyName) {
		this.recordCompanyName = recordCompanyName;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
}
