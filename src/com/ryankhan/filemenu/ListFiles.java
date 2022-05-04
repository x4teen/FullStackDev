package com.ryankhan.filemenu;

import com.ryankhan.menu.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ListFiles implements MenuItem{
	private String title;
	private String baseDir;
	
	public ListFiles(String baseDir) {
		this.baseDir = baseDir;
		setTitle("List files in directory");
	}

	
	@Override
	public void run() {
		File myDir = new File(baseDir);
		myDir.mkdir();
		ArrayList<String> foundFile = new ArrayList<String>();
		
		if (myDir.exists()) {
			String[] fileList = myDir.list();
			for (String item: fileList) {
				foundFile.add(item);
			}
			foundFile.sort(null);
			
			for (int i=0; i<foundFile.size(); i++) {
				System.out.println(i+1 + ". " + foundFile.get(i));
			}
		} else
			System.out.println("Directory does not exit.");
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
			System.out.println("Showing Files in Directory ");
			run();
		}
	}

	
	@Override
	public boolean returnToMain(){
		System.out.println("Enter y to list files in base directory or n to go back:");
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
