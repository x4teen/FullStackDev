package com.ryankhan.menu;

import java.io.IOException;

public interface MenuItem {
	
	public void run();

	public String getTitle();
	
	public void setTitle(String title);
	
	public boolean returnToMain() throws IOException;
	
	public void showContextMenu();
	
}