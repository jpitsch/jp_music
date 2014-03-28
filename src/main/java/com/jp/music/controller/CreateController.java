package com.jp.music.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.music.album.model.Album;
import com.jp.music.album.service.AlbumService;
import com.jp.music.recordcompany.model.RecordCompany;
import com.jp.music.recordcompany.service.RecordCompanyService;
import com.jp.music.service.UserService;
import com.jp.music.singer.model.Singer;
import com.jp.music.singer.service.SingerService;
import com.jp.music.user.model.User;

@Controller
public class CreateController {
	private static final Logger logger = LoggerFactory.getLogger(CreateController.class);
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	RecordCompanyService recordCompanyService;
	
	@Autowired
	SingerService singerService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String getAlbumCreateForm(Map<String, Object> map) {
		map.put("album", new Album());
		map.put("albumList", albumService.findAllAlbums());
		map.put("singerList", singerService.findAllSingers());
		map.put("recordCompanyList", recordCompanyService.findAllRecordCompanies());
		
		map.put("singerId", new Object());
		map.put("albumId", new Object());
		
		return "create/album";
	}
	
	@RequestMapping(value = "/create-album", method = RequestMethod.POST)
	public String createAlbum(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/create/album";
		}
		
		if(album != null) {
			albumService.saveAlbum(album);
		}
		
		return "redirect:/album.htm";
	}
	
	@RequestMapping(value = "/delete-album/{id}")
	public String deleteAlbum(@PathVariable("id") Integer id) {
		albumService.delteAlbum(id);
		
		return "redirect:/album.htm";
	}
	
	@RequestMapping(value = "/singer", method = RequestMethod.GET)
	public String getSingerCreateForm(Map<String, Object> map) {
		map.put("singer", new Singer());
		map.put("singersList", singerService.findAllSingers());
		
		return "create/singer";
	}
	
	@RequestMapping(value = "/create-singer", method = RequestMethod.POST)
	public String createSinger(@ModelAttribute("singer") @Valid Singer singer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/create/singer";
		}
		
		if(singer != null) {
			singerService.saveSinger(singer);
		}
		
		return "redirect:/singer.htm";
	}
	
	@RequestMapping(value = "/delete-singer/{id}")
	public String deleteSinger(@PathVariable("id") Integer id) {
		
		singerService.deleteSinger(id);
		
		return "redirect:/singer.htm";
	}
	
	@RequestMapping(value = "/record-company", method = RequestMethod.GET)
	public String getRecordCompanyCreateForm(Map<String, Object> map) {
		map.put("recordCompany", new RecordCompany());
		map.put("recordCompanyList", recordCompanyService.findAllRecordCompanies());
		
		return "create/record-company";
	}
	
	@RequestMapping(value = "/create-record-company", method = RequestMethod.POST)
	public String createRecordCompany(@ModelAttribute("recordCompany") @Valid RecordCompany recordCompany, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/create/record-company";
		}
		
		if(recordCompany != null) {
			recordCompanyService.saveRecordCompany(recordCompany);
		}
		
		return "redirect:/record-company.htm";
	}
	
	@RequestMapping(value = "/delete-record-company/{id}")
	public String deleteRecordCompany(@PathVariable("id") Integer id) {
		recordCompanyService.deleteRecordCompany(id);
		
		return "redirect:/record-company.htm";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getUserCreateForm(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", userService.findAllUsers());
		
		return "create/user";
	}
	
	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/create/user";
		}
		
		if(user != null) {
			userService.saveUser(user);
		}
		
		return "redirect:/user.htm";
	}
	
	@RequestMapping(value = "/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		
		return "redirect:/user.htm";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
