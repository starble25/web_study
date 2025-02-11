package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.file.FileInfo;

public class FileManager {

	static final String FILE_DIRECTORY_PATH = "e:/fileStorage";
	static final String FILE_URL_PATH = "/fileStorage";
	
	public static FileInfo storeFile(MultipartFile file) throws IllegalStateException, IOException {
		
		//파일 폴더 저장 -> 파일에 대한 정보를 기반 -> DB 저장
		
		FileInfo fileInfo = new FileInfo();
		
		fileInfo.setOriginalFileName(file.getOriginalFilename());
		fileInfo.setFilePath(FILE_DIRECTORY_PATH);
		fileInfo.setUrlFilePath(FILE_URL_PATH);
		
		String extension = extractExtension(file.getOriginalFilename());
		String fileName = createFileName(extension);
			
		fileInfo.setFileName(fileName);
		
		file.transferTo( new File(fileInfo.getFilePath() + fileInfo.getFileName()) );
		
		return fileInfo;
	}
	
	//png	dasfiauhfiowehr.png
	//jpg	aeoiptaetoiqetr.jpg
	private static String createFileName(String extension) {
		String fileName = UUID.randomUUID().toString();
		
		fileName += "." + extension;
		
		return fileName;
	}
	
	private static String extractExtension(String fileName) {
		//tree.jpg
		fileName.substring( fileName.lastIndexOf(".") + 1 );
		return fileName;
	}
	
}
