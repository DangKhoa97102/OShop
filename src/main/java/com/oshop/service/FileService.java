package com.oshop.service;

import java.nio.file.Path;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	Path getPath(String folder, String fileName);
	byte[] readFile(String folder, String fileName);
	List<String> saveFiles(String folder, MultipartFile[] multipartFiles);
	void deleteFile(String folder, String fileName);
	List<String> getFileNames(String folders);
}
