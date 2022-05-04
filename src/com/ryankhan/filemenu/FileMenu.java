package com.ryankhan.filemenu;

import java.util.ArrayList;

import com.ryankhan.menu.*;

public class FileMenu extends Menu{
	private static ArrayList<MenuItem> fileMenuList = new ArrayList<MenuItem>();
	
	public FileMenu(String baseDir) {
		super(makeFileMenuList(baseDir));
	}

	
	public static ArrayList<MenuItem> makeFileMenuList(String baseDir) {
		MenuItem listFile = new ListFiles(baseDir);
		MenuItem createFile = new CreateFile(baseDir);
		MenuItem searchFile = new SearchFile(baseDir);
		MenuItem deleteFile = new DeleteFile(baseDir);
		
		fileMenuList.add(listFile);
		fileMenuList.add(createFile);
		fileMenuList.add(searchFile);
		fileMenuList.add(deleteFile);
		return fileMenuList;
	}

}
