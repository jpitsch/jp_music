package com.jp.music.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

public class ImportFile {
	public static enum FileType {
		ALBUM, SINGER, USER, RECORD_COMPANY
	}
	
	private MultipartFile file;
	private FileType fileType;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
	@ModelAttribute("fileTypes")
	public Map<String, String> populateFileTypeList() {
		Map<String, String> fileTypes = new HashMap<String, String>();
		for(FileType f : FileType.values()) {
			fileTypes.put(f.toString(), f.toString());
		}
		return fileTypes;
	}
}
