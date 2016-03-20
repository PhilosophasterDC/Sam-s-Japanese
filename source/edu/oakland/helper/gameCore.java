package edu.oakland.helper;

import edu.oakland.helper.*;
import java.util.*;

public class gameCore{
	
	private String gameLocation;
	
	private int today = 1;
	private int relA = 0;
	private int relJ = 0;
	private ArrayList<Integer> grade;
	private int avg = 0;
	private int money = 50;
	private int timesWork = 0;
	private int quizTook = 0;
	private int employmentLevel = 0;
	
	private String lastDay = "\t\t\tTest Day...";
	private int i = 0;
	private boolean goodToGo = false;
	
	private int friend;
	
	private Scanner scan = new Scanner(System.in);
	private int input;
	private String fileLocation = "textFiles\\";
	private String lectureLoaction = "textFiles\\class";
	private String file;
	private textWriter writer;
	private John john;
	private Alyssa alyssa;
	private saveGame save;
	private loadGame load;
	private int menuChoice;
	
	
	
	public gameCore(textWriter text, String saveLocation, loadGame loadedGame, int menu){
		writer = text;
		gameLocation = saveLocation;
		load = loadedGame;
		menuChoice = menu;
	}
	
	public void playGame(){
		if(menuChoice == 2){
			loadSavedData();
		}
		startDay();
	}
	
	public void loadSavedData(){
		today = load.getDay();
		relJ = load.getRelationshipJohn();
		relA = load.getRelationshipAlyssa();
		grade = load.getGrade();
		avg = load.getAvg();
		money = load.getMoney();
		timesWork = load.getTimesWork();
		quizTook = load.getQuizTook();		
	}
	
	private void startDay(){
		john = new John(writer);
		alyssa = new Alyssa(writer);
		if(menuChoice != 2){
			grade = new ArrayList<Integer>();
		}
		
		try{
			while(today <= 100){
				System.out.println("\t\t\tDay:  " + (today));
				goToClass();
				hangOutWithFriends();
				extraTime();
				today += 1;
				
				quizTook = (today/10)-((today%10)/10);
				if(quizTook > 0){
					for(Integer e : grade){
						avg += e;
					}
					
					avg = (avg / quizTook);
				}
				else{
					avg = 0;
				}
				save = new saveGame(gameLocation);
				save.gameSaver(today, relJ, relA, grade, avg, money, timesWork, quizTook);
			}
			
			while(i < (lastDay.length()-3)){
				System.out.print(lastDay.substring(i,i+1));
				Thread.sleep(500);
				i++;
			}
			while(i < lastDay.length()){
				System.out.print(lastDay.substring(i,i+1));
				Thread.sleep(1000);
				i++;
			}
			
			
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}
	
	
	private void goToClass(){
		
		goodToGo = false;
		
		if((today%2) == 1){
			lesson();
		}
		else if((today%2) == 0){
			review();
		}
		else{
			System.out.println("Error: something went wrong with class");
		}
	}
	
	private void lesson(){
		
		file = lectureLoaction + today + ".txt";
		writer.output(file);
		
		do{
			input = scan.nextInt();
			if(input == 1){
				file = fileLocation + "understand.txt";
				writer.output(file);
				goodToGo = true;
			}
			else if(input == 2){
				file = fileLocation + "unavailable.txt";
				writer.output(file);
				goodToGo = false;
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
				goodToGo = false;
			}
		}while(goodToGo == false);
		
	}
	
	private void review(){	
		file = fileLocation + "review" + today + ".txt";
		writer.output(file);
		
	}
	
	private void hangOutWithFriends(){
		if(today == 1){
			file = fileLocation + "newFriends.txt";
		}
		else{
			file = fileLocation + "friends.txt";
		}
		
		writer.output(file);
		friend = scan.nextInt();
		
		
		
		if(friend == 1){
			relJ = john.talkToJohn(today, relJ, avg, money);
		}
		else if(friend == 2){
			relA = alyssa.talkToAlyssa(today, relA, avg, money);
		}
		else{
			System.out.println("I'm sorry, but '" + friend + "' is not a valid response");
		}
	}
	
	private void extraTime(){
		file = fileLocation + "extraTime.txt";
		writer.output(file);
		input = scan.nextInt();
		
		if(input == 1){
			work();
		}
		else if(input == 2){
			study();
		}
		else{
			System.out.println("I'm sorry, but '" + input + "' is not a valid response");
		}
	}
	
	private void study(){
		
		
	}
	
	private void work(){
		if(timesWork <= 5){
			employmentLevel = 0;
			timesWork += 1;
			if(timesWork > 5){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else if(timesWork <= 10){
			employmentLevel = 1;
			timesWork += 1;
			if(timesWork > 10){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else if(timesWork <= 15){
			employmentLevel = 2;
			timesWork += 1;
			if(timesWork > 15){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else if(timesWork <= 20){
			employmentLevel = 3;
			timesWork += 1;
			if(timesWork > 20){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else if(timesWork <= 25){
			employmentLevel = 4;
			timesWork += 1;
			if(timesWork > 25){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else if(timesWork <= 30){
			employmentLevel = 5;
			timesWork += 1;
			if(timesWork > 30){
				System.out.println("Congratulations! Because" +
						   " of all your hard work, " +
						   "you are being promoted " +
						   "effective tomorrow!");
			}
		}
		else{
			employmentLevel = 6;
		}
		
		
		file = fileLocation + employmentLevel + ".txt";
		
	}
	
}