package com.jp.music.singer.model;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jp.music.album.model.Album;

@Entity
@Table(name="singers")
public class Singer {
	
	public enum Gender {
		MALE, FEMALE
	}
	
//	private Gender gender;
//	
//	public Gender getGender() {
//		return gender;
//	}
//
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}

	@Id
	@Column(name="SINGERS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer singerId;
	
	@Column(name="NAME")
	@NotNull @Size(min=1, max=20)
	private String name;
	
	@Column(name="DOB")
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@Column(name="SEX")
	@NotNull @Size(min=4, max=6)
	private String sex;
	
	@OneToMany(mappedBy="singer", fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Album> albums;

	public Integer getSingerId() {
		return singerId;
	}

	public void setSingerId(Integer singerId) {
		this.singerId = singerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@ModelAttribute("genderList")
	public Map<String, String> populateGenderList() {
		Map<String, String> genderList = new HashMap<String, String>();
		for(Gender s : Gender.values()) {
			genderList.put(s.toString(), s.toString());
		}
		return genderList;
	}
}
