package edu.oakland.helper;

import java.util.*;
import java.io.*;

public class loadGame{
	
	private int day = 0;
	private int relationshipJohn = 0;
	private int relationshipAlyssa = 0;
	private ArrayList<Integer> grade = new ArrayList<Integer>();
	private int avg = 0;
	private int money = 50;
	private int timesWork = 0;
	private int quizTook = 0;
	
	
	private int i = 1;
	private int m = 0;
	private int input;
	private ArrayList<String> savedGames = new ArrayList<String>();
	private File file[] = new File("saves").listFiles();
	private String fileLocation = "saves";
	private Iterator it = grade.iterator();
	private Scanner scan = new Scanner(System.in);
	private Scanner loadFile;

	
	public String gameLoader(){
		for(File e : file){
			if(e.isFile()){
				savedGames.add(e.getName());
			}
		}
		
		System.out.println("\n\n\t\tSaved Files");
		i = 1;
		for(String e : savedGames){
			System.out.println(i + ")\t" + e);
			i++;
		}
		
		input = scan.nextInt();
		
		loadTheGame();
		return(loadFile.toString());
	}
	
	
	private void loadTheGame(){
		try{
			loadFile = new Scanner(new File(fileLocation + "\\" + savedGames.get(input-1)));
			System.out.println("Loading:  " + savedGames.get(input - 1));
			
			day = Integer.parseInt(loadFile.next());
			relationshipJohn = Integer.parseInt(loadFile.next());
			relationshipAlyssa = Integer.parseInt(loadFile.next());
			for(m=0; m<10; m++){
				grade.add(Integer.parseInt(loadFile.next()));
			}
			avg = Integer.parseInt(loadFile.next());
			money = Integer.parseInt(loadFile.next());
			timesWork = Integer.parseInt(loadFile.next());
			quizTook = Integer.parseInt(loadFile.next());
			
			loadFile.close();
		}
		catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
	}
	
	public int getDay(){
		return day;
	}
	public int getRelationshipJohn(){
		return relationshipJohn;
	}
	public int getRelationshipAlyssa(){
		return relationshipAlyssa;
	}
	public ArrayList<Integer> getGrade(){
		return grade;
	}
	public int getAvg(){
		return avg;
	}
	public int getMoney(){
		return money;
	}
	public int getTimesWork(){
		return timesWork;
	}
	public int getQuizTook(){
		return quizTook;
	}
	
}