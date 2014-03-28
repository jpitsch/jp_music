package com.jp.music.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;

import com.jp.music.album.model.Album;
import com.jp.music.album.service.AlbumService;
import com.jp.music.imports.model.ImportFile;
import com.jp.music.imports.model.ImportFile.FileType;
import com.jp.music.recordcompany.model.RecordCompany;
import com.jp.music.recordcompany.service.RecordCompanyService;
import com.jp.music.service.UserService;
import com.jp.music.singer.model.Singer;
import com.jp.music.singer.service.SingerService;
import com.jp.music.user.model.User;
import com.jp.music.utility.FileImporter;
import com.jp.music.validator.FileValidator;

@Controller
public class FileImportController {
	
	@Autowired  
	FileValidator fileValidator;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	RecordCompanyService recordCompanyService;
	
	@Autowired
	SingerService singerService;
	
	@Autowired
	UserService userService;


	private static final Logger logger = LoggerFactory.getLogger(FileImportController.class);
	
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String getImportForm(@ModelAttribute("importFile") ImportFile importFile, BindingResult result) {
		
		return "import/import";
	}
	
	@RequestMapping(value = "/importfile", method = RequestMethod.POST)
	public String importFile(@ModelAttribute("importFile") ImportFile importFile, BindingResult result) {
			
		MultipartFile file = importFile.getFile();  
		fileValidator.validate(importFile, result);  
		  
		if (result.hasErrors()) {  
		   return "import/import";  
		}  
		
		List<String[]> fileList = null;
		try {
			CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()), '|');
			fileList = reader.readAll();
			reader.close();	
		} catch (IOException e) {
			logger.error(e.getMessage());
			return "import/import";
		}
		
		FileImporter fileImportService = new FileImporter();
		
		if(importFile.getFileType() == FileType.ALBUM) {
			List<Album> albumList = fileImportService.createAlbumList(fileList);
			
			for(Album album : albumList) {
				
				Album existingAlbum = albumService.findAlbumByName(album.getAlbumName());
				if(existingAlbum != null) {
					continue;
				}
				
				RecordCompany rc = recordCompanyService.findRecordCompanyByName(album.getRecordCompany().getRecordCompanyName());
				if(rc != null) {
					album.setRecordCompany(rc);
				}
				else {
					recordCompanyService.saveRecordCompany(album.getRecordCompany());
				}
				
				Singer s = singerService.findSingerByName(album.getSinger().getName());
				if(s != null) {
					album.setSinger(s);
				}
				else {
					singerService.saveSinger(album.getSinger());
				}
			}
			
			albumService.saveAllAblums(albumList);
			
		}
		else if(importFile.getFileType() == FileType.RECORD_COMPANY) {
			List<RecordCompany> recordCompanyList = fileImportService.createRecordCompaniesList(fileList);
			
			for(RecordCompany r : recordCompanyList) {
				RecordCompany existing = recordCompanyService.findRecordCompanyByName(r.getRecordCompanyName());
				
				if(existing != null) {
					continue;
				}
				else {
					recordCompanyService.saveRecordCompany(r);
				}
			}
		}
		else if(importFile.getFileType() == FileType.SINGER) {
			List<Singer> singerList = fileImportService.createSingerList(fileList);
			
			for(Singer s : singerList) {
				Singer existing = singerService.findSingerByName(s.getName());
				
				if(existing != null) {
					continue;
				}
				else {
					singerService.saveSinger(s);
				}
			}
		}
		else if(importFile.getFileType() == FileType.USER) {
			List<User> userList = fileImportService.createUserList(fileList);
			
			for(User u : userList) {
				User existing = userService.findUserByName(u.getUsername());
				
				if(existing != null) {
					continue;
				}
				else {
					userService.saveUser(u);
				}
			}
		}
		
		return "import/import-success";
	}
}
