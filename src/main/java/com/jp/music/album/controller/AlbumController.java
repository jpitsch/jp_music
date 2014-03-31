package com.jp.music.album.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.music.album.model.Album;
import com.jp.music.album.service.AlbumService;
import com.jp.music.common.controller.BaseController;
import com.jp.music.recordcompany.service.RecordCompanyService;
import com.jp.music.singer.service.SingerService;

@Controller
@RequestMapping("/album")
public class AlbumController extends BaseController {
	
	@Autowired
	AlbumService albumService;

	@Autowired
	RecordCompanyService recordCompanyService;

	@Autowired
	SingerService singerService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAlbumCreateForm(Map<String, Object> map) {
	
		map.put("album", new Album());
		map.put("albumList", albumService.findAllAlbums());
		map.put("singerList", singerService.findAllSingers());
		map.put("recordCompanyList", recordCompanyService.findAllRecordCompanies());
		
		map.put("singerId", new Object());
		map.put("albumId", new Object());
		
		return "/album/album";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createAlbum(@ModelAttribute("album") @Valid Album album, BindingResult result) {
	
		if(result.hasErrors()) {
			return "/album/album";
		}
		
		if(album != null) {
			albumService.saveAlbum(album);
		}
		
		return "redirect:/album/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteAlbum(@PathVariable("id") Integer id) {
		
		albumService.delteAlbum(id);
		
		return "redirect:/album/";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editAlbum(@PathVariable("id") Integer id) {
		
		return "/album/album";
	}
}
