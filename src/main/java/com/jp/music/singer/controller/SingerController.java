package com.jp.music.singer.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.music.common.controller.BaseController;
import com.jp.music.singer.model.Singer;
import com.jp.music.singer.service.SingerService;

@Controller
@RequestMapping("/singer")
public class SingerController extends BaseController {
	
	@Autowired
	SingerService singerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getSingerCreateForm(Map<String, Object> map) {
		map.put("singer", new Singer());
		map.put("singersList", singerService.findAllSingers());
		
		return "singer/singer";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSinger(@ModelAttribute("singer") @Valid Singer singer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/singer/singer";
		}
		
		if(singer != null) {
			singerService.saveSinger(singer);
		}
		
		return "redirect:/singer/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteSinger(@PathVariable("id") Integer id) {
		
		singerService.deleteSinger(id);
		
		return "redirect:/singer/";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editAlbum(@PathVariable("id") Integer id) {
		
		return "singer/singer";
	}
}
