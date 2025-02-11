package com.app.service.file;

import org.springframework.stereotype.Service;

import com.app.dto.file.FileInfo;

@Service
public interface FileService {

	public int saveFileInfo(FileInfo fileInfo);
	
	public FileInfo findFileInfoByFileName(String fileName);
}
