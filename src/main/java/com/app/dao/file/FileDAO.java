package com.app.dao.file;

import org.springframework.stereotype.Repository;

import com.app.dto.file.FileInfo;

@Repository
public interface FileDAO {
	public int saveFileInfo(FileInfo fileInfo);
	
	public FileInfo findFileInfoByFileName(String fileName);
}
