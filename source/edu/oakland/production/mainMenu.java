package edu.oakland.production;

import java.util.*;
import edu.oakland.helper.*;

public class mainMenu{
	
	private int menuInput;
	private String input;
	private String catcher = "go";
	private String fileLocation = "textFiles\\";
	private String mainMenuFile = fileLocation + "mainMenu.txt";
	private String introFile = fileLocation + "intro.txt";
	private boolean flag = false;
	private boolean goOn = false;
	private Scanner scan = new Scanner(System.in);
	private textWriter writer = new textWriter();
	private makeFile newGame = new makeFile();
	private gameCore launch;
	private String savedGameLocation;
	private loadGame load;
	private int menuChoice;
	
	public static void main(String[] args){
		mainMenu main = new mainMenu();
		main.intro();
		main.menu();
	}
	
	private void intro(){	
		writer.output(introFile);
		
		do{
			input = scan.nextLine();
			if(input.equals(catcher)){
				flag = true;
			}
			else if(!input.equals(catcher)){
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
				flag = false;
			}
			else{
				System.out.println("Error: something went wrong with the intro.");
				flag = false;
			}

		} while(flag == false);
	}
	
	private void menu(){
		writer.output(mainMenuFile);
		do{
			menuInput = scan.nextInt();
			switch(menuInput){
			case  1:	savedGameLocation = newGame.fileMaker();
					menuChoice = 1;
					goOn = true;
					break;
			case  2:	load = new loadGame();
					savedGameLocation = load.gameLoader();
					menuChoice = 2;	
					goOn = true;
					break;
			case  3:	writer.output(fileLocation + "unavailable.txt");
					goOn = false;
					break;
			default:	System.out.println("I'm sorry, but '" + menuInput + "' is not a valid response");
					goOn = false;
					break;
			}
		} while(goOn==false);
		
		launch = new gameCore(writer, savedGameLocation, load, menuChoice);
		launch.playGame();
	}
}