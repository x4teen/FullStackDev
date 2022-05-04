package com.ryankhan.filemenu;

import com.ryankhan.menu.*;
import java.io.File;
import java.io.IOException;


public class CreateFile implements MenuItem{
	private String title;
	private String baseDir;
	
	public CreateFile(String baseDir) {
		this.baseDir = baseDir;
		setTitle("Create a New File ");
	}

	
	@Override
	public void run() {
		File myDir = new File(baseDir);
		myDir.mkdir();
		String fName = getUserResponse();
		File myFile = new File(myDir, fName);
		
		try {
			myFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(myFile.getAbsolutePath() + " was created.");
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
			System.out.println("Enter the File Name: ");
			run();
		}
	}

	
	@Override
	public boolean returnToMain(){
		System.out.println("Enter y to create a file and n to go back:");
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
