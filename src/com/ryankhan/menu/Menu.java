package com.ryankhan.menu;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuItem> menuItemList;
	private int exitCode = 99;
	
	public Menu(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}


	public void showChoices() {
		int index = 1;
		System.out.println("***** Enter a choice number or " + getExitCode() 
		+ " to exit the program.*****\n");
		for (MenuItem item: menuItemList) {
			System.out.println("\t" + index + ". " + item.getTitle() );
			index++;
		}
		System.out.print("\nEnter your choice here : ");
	}
	
	
	public void showMainScreen() {
		int choice = 0;
		
		while (!isValidChoice(choice)) {
			showChoices();
			choice = getUserChoice();
			
			if (choice == getExitCode()) {
				System.out.println("\n\nUser Terminated the Program.");
				System.exit(0);
			} else if (isValidChoice(choice)) {
				this.menuItemList.get(choice-1).showContextMenu();
				choice=0;
			} else {
				System.out.println("\nYou made an invalid selection. - " + choice);
			}
		}
	}
	
	
	private int getUserChoice(){
		int choice;
		String response;
		
		try {
			try {
				response = UserInput.getInput();
			} catch (IOException e) {
				return 0;
			}
			choice = Integer.parseInt(response);
			return choice;
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice, please try again.");;
			return 0;
		}
	}


	private boolean isValidChoice(int choice) {
		if (choice > 0) 
			return choice <= menuItemList.size();
		else
			return false;
	}
	
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}


	public int getExitCode() {
		return exitCode;
	}


	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}
	
}
