package edu.oakland.helper;

import edu.oakland.helper.*;
import java.util.*;
import java.io.*;

public class saveGame{
	
	private int i = 0;
	private int m = 0;
	private int day = 0;
	private int relationshipJohn = 0;
	private int relationshipAlyssa = 0;
	private ArrayList<Integer> grade = new ArrayList<Integer>();
	private int avg = 0;
	private int money = 50;
	private int timesWork = 0;
	private int quizTook = 0;
	
	private String fileLocation;
	private PrintWriter writer;
	private makeFile maker = new makeFile();
	private Iterator it = grade.iterator();
	
	
	public saveGame(String location){
		fileLocation = location;
	}
	
	public void gameSaver(int saveDay, int saveJohn, int saveAlyssa, ArrayList<Integer> saveGrade, int saveAvg, int saveMoney, int saveTimesWork, int saveQuizTook){
		day = saveDay;
		relationshipJohn = saveJohn;
		relationshipAlyssa = saveAlyssa;
		grade = saveGrade;
		avg = saveAvg;
		money = saveMoney;
		timesWork = saveTimesWork;
		quizTook = saveQuizTook;
		saveTheGame();
	}
	
	private void saveTheGame(){
		try{
			writer = new PrintWriter(fileLocation);
			writer.println(day);
			writer.println(relationshipJohn);
			writer.println(relationshipAlyssa);
			if(it.hasNext()){
				for( Integer e : grade){
					writer.println(e);
				}
			}
			for(m = 0; m < (10 - grade.size()); m++){
				writer.println("0");
			}
			writer.println(avg);
			writer.println(money);
			writer.println(timesWork);
			writer.println(quizTook);
			
			writer.close();
		}
		catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
	}
}