package com.jp.music.recordcompany.controller;

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
import com.jp.music.recordcompany.model.RecordCompany;
import com.jp.music.recordcompany.service.RecordCompanyService;

@Controller
@RequestMapping("/recordcompany")
public class RecordCompanyController extends BaseController {
	
	@Autowired
	RecordCompanyService recordCompanyService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRecordCompanyCreateForm(Map<String, Object> map) {
		
		map.put("recordCompany", new RecordCompany());
		map.put("recordCompanyList", recordCompanyService.findAllRecordCompanies());
		
		return "recordcompany/record-company";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRecordCompany(@ModelAttribute("recordCompany") @Valid RecordCompany recordCompany, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/recordcompany/";
		}
		
		if(recordCompany != null) {
			recordCompanyService.saveRecordCompany(recordCompany);
		}
		
		return "redirect:/recordcompany/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteRecordCompany(@PathVariable("id") Integer id) {
		
		recordCompanyService.deleteRecordCompany(id);
		
		return "redirect:/record-company.htm";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editAlbum(@PathVariable("id") Integer id) {
		
		return "recordcompany/record-company";
	}
}
