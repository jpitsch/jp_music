package com.jp.music.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.jp.music.models.Album;
import com.jp.music.models.RecordCompany;
import com.jp.music.models.Singer;
import com.jp.music.models.User;

public class FileImporter {
	
	public final String DATE_FORMAT = "yyyyMMdd";
	
	public FileImporter() {
		
	}
	
	//Package Private Methods for Unit testing purposes
	public List<Album> createAlbumList(List<String[]> fileList) {
		
		List<Album> albums = new ArrayList<Album>();
		
		if(!CollectionUtils.isEmpty(fileList)) {
			String[] firstLine = fileList.get(0);
			String check = firstLine[0].replace("\t", "").trim();
			
			if(check.equalsIgnoreCase("SINGER")) {
				fileList.remove(0);
				
				for(String[] line : fileList) {
					Album a = new Album();
					a.setAlbumName(line[1].trim());
					a.setReleaseYear(line[2].trim());
					
					Singer s = new Singer();
					s.setName(line[0].trim());
					a.setSinger(s);
					
					RecordCompany r = new RecordCompany();
					r.setRecordCompanyName(line[3].trim());
					a.setRecordCompany(r);
					
					albums.add(a);
				}
			}
		}
		
		return albums;
	}
	
	public List<RecordCompany> createRecordCompaniesList(List<String[]> fileList) {
		
		List<RecordCompany> recordCompanies = new ArrayList<RecordCompany>();
		
		if(!CollectionUtils.isEmpty(fileList)) {
			String[] firstLine = fileList.get(0);
			String check = firstLine[0].replace("\t", "").trim();
			
			if(check.equalsIgnoreCase("COMPANY")) {
				fileList.remove(0);
				
				for(String[] line : fileList) {
					RecordCompany r = new RecordCompany();
					r.setRecordCompanyName(line[0]);
					
					recordCompanies.add(r);
				}
			}
		}
		
		return recordCompanies;
	}
	
	public List<Singer> createSingerList(List<String[]> fileList) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		List<Singer> singers = new ArrayList<Singer>();
		
		if(!CollectionUtils.isEmpty(fileList)) {
			String[] firstLine = fileList.get(0);
			String check = firstLine[0].trim();
			
			if(check.equalsIgnoreCase("NAME")) {
				fileList.remove(0);
				
				for(String[] line : fileList) {
					Singer s = new Singer();
					s.setName(line[0].trim());
					try {
						s.setDateOfBirth(df.parse(line[1]));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					s.setSex(line[2].trim());
					
					singers.add(s);
				}
			}
		}
		
		return singers;
	}
	

	public List<User> createUserList(List<String[]> fileList) {
		// This could have been a good alternative
			
		//		String[] columns = new String[] {"userName", "userPass"};
		//		
		//		ColumnPositionMappingStrategy<User> mapper = new ColumnPositionMappingStrategy<User>();
		//		mapper.setType(User.class);
		//		mapper.setColumnMapping(columns);
		//		
		//		CsvToBean csv = new CsvToBean();
		//		List<User> users = (List<User>)csv.parse(mapper, reader);
		
		List<User> users = new ArrayList<User>();
		
		if(!CollectionUtils.isEmpty(fileList)) {
			String[] firstLine = fileList.get(0);
			String check = firstLine[0].replace("\t", "").trim();
			
			if(check.equalsIgnoreCase("USER")) {
				fileList.remove(0);
				
				for(String[] line : fileList) {
					User u = new User();
					u.setUsername(line[0].trim());
					u.setPassword(line[1].trim());
					
					users.add(u);
				}
			}
		}
		
		return users;
	}
	
}
