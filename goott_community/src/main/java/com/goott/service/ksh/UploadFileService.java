package com.goott.service.ksh;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import com.goott.vodto.ksh.UploadFiles;



public interface UploadFileService {
	// 실제 파일 업로드
	UploadFiles uploadFile(String originalFileName, long size, String contentType, byte[] data, String realPath) throws IOException;
	// 기존 파일이 DB에 존재하는지 확인
	boolean isExist(String newFileName) throws SQLException, NamingException;
	// 특정 파일 삭제
	void deleteUploadedFile(List<String> deleteFileList, String realPath) throws IOException;
	// 파일 경로 얻기
	String[] getRealPath(HttpServletRequest request, String subPath);
	// 실제 파일 삭제
	boolean deleteFile(String subPath, List<UploadFiles> fileList, HttpServletRequest request);
	
}