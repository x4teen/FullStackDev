package com.simplilearn.assignment;

import com.ryankhan.filemenu.FileMenu;

public class TestMenu {

	public static void main(String[] args) {
		FileMenu fileMenu = new FileMenu("/mydir");
		fileMenu.showMainScreen();
	}

}
