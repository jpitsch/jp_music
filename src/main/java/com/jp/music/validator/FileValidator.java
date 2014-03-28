package com.jp.music.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jp.music.imports.model.ImportFile;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object uploadedFile, Errors errors) {
		ImportFile file = (ImportFile) uploadedFile;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "import.selectFile", "Please select a file to import to the database.");
		}
	}

}
