package edu.oakland.helper;

import edu.oakland.helper.*;
import java.util.*;
import java.io.*;

public class makeFile{
	
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	private String name;
	private String fileLocation = "saves\\";
	private File file;
	private Scanner scan = new Scanner(System.in);
	private saveGame save;
	
	public String fileMaker(){
		System.out.println("Name your game file (no spaces or special characters):");
		name = scan.nextLine();
		
		fileLocation = fileLocation + name + ".txt";
		file = new File(fileLocation);
		
		save = new saveGame(fileLocation);
		save.gameSaver(0,0,0,grades,0,0,0,0);
		
		return(fileLocation);
	}
}