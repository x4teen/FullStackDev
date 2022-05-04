package com.ryankhan.filemenu;

import com.ryankhan.menu.*;
import java.io.File;
import java.io.IOException;


public class SearchFile implements MenuItem{
	private String title;
	private String baseDir;
	
	public SearchFile(String baseDir) {
		this.baseDir = baseDir;
		setTitle("Search for a File ");
	}

	
	@Override
	public void run() {
		File myDir = new File(baseDir);
		myDir.mkdir();
		String fName = getUserResponse();
		File myFile = new File(myDir, fName);
		
		if (myFile.exists()) {
			String foundFile = myFile.getName();
			System.out.println(foundFile + " was found.");
		} else
			System.out.println(fName +" does not exit.");
	}


	@Override
	public String getTitle() {
		return this.title;
	}

	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	
	@Override
	public void showContextMenu() {
		if (!returnToMain()) {
			System.out.println("Enter the File Name to Find : ");
			run();
		}
	}

	
	@Override
	public boolean returnToMain(){
		System.out.println("Enter y to search for a file and n to go back:");
		char response = getUserResponse().charAt(0);
			if (Character.toLowerCase(response) == 'n') {
				return true;
			} else
				return false;
	}
	
	
	private String getUserResponse(){
		String response;
		try {
			response = UserInput.getInput();
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
