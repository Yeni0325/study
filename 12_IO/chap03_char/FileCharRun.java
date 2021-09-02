package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDao;

public class FileCharRun {

	public static void main(String[] args) {
		
		FileCharDao dao = new FileCharDao();
		//dao.fileSave();
		dao.fileRead();
	}

}
