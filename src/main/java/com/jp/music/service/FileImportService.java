package com.jp.music.service;

import java.util.List;

public interface FileImportService {
	public boolean importAlbumsFromFile(List<String[]> fileList);
	public boolean importRecordCompaniesFromFile(List<String[]> fileList);
	public boolean importSingersFromFile(List<String[]> fileList);
	public boolean importUsersFromFile(List<String[]> fileList);
}
