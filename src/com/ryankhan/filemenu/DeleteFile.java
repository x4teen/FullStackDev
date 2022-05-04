package com.ryankhan.filemenu;

import com.ryankhan.menu.*;
import java.io.File;
import java.io.IOException;


public class DeleteFile implements MenuItem{
	private String title;
	private String baseDir;
	
	public DeleteFile(String baseDir) {
		this.baseDir = baseDir;
		setTitle("Delete a File ");
	}

	
	@Override
	public void run() {
		File myDir = new File(baseDir);
		myDir.mkdir();
		String fName = getUserResponse();
		File myFile = new File(myDir, fName);
		
		if (myFile.exists()) {
			try {
				myFile.delete();
				System.out.println(fName + " was deleted.");}
			catch(Exception e) {
				System.out.println(fName + " could not be deleted. "
						+ e.getMessage());
			}
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
			System.out.println("Enter the File Name to Delete : ");
			run();
		}
	}

	
	@Override
	public boolean returnToMain(){
		System.out.println("Enter y to delete a file and n to go back:");
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
