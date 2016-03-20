package edu.oakland.helper;

import edu.oakland.helper.*;
import java.util.*;

public class John{
	
	private int today = 1;
	private int relJ = 0;
	private int avg = 0;
	private int money = 50;
	private int input = 0;
	
	private String file;
	private String fileLocation = "textFiles\\";	
	private textWriter writer;
	private Scanner scan = new Scanner(System.in);
	
	
	
	public John(textWriter text){
		writer = text;
	}
	
	public int talkToJohn(int day, int relationJ, int average, int cash){
		today = day;
		relJ = relationJ;
		avg = average;
		money = cash;
		
		interact();
		return(relJ);
		
	}
	
	
	private void interact(){
		if(relJ == 0){
			file = fileLocation + "john0.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "jActivity0_1.txt";
				writer.output(file);
				relJ += 3;
			}
			else if(input == 2){
				file = fileLocation + "jActivity0_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relJ > 0){
				System.out.println("\n\n\nCongratulations, you have become friends with John.");
			}
			
		}
		else if((relJ > 0) && (relJ <= 20)){
			file = fileLocation + "john1.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "jActivity1_1.txt";
				writer.output(file);
				relJ += 3;
			}
			else if(input == 2){
				file = fileLocation + "jActivity1_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relJ > 20){
				System.out.println("\n\n\nCongratulations, you have become close friends with John.");
			}
			
		}
		else if((relJ > 20) && (relJ <= 30)){
			file = fileLocation + "john2.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "jActivity2_1.txt";
				writer.output(file);
				relJ += 3;
			}
			else if(input == 2){
				file = fileLocation + "jActivity2_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relJ > 30){
				System.out.println("\n\n\nCongratulations, you have become best friends with John.");
			}
			
		}
		else if (relJ > 30){
			file = fileLocation + "john3.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "jActivity3_1.txt";
				writer.output(file);
				if((relJ + 3) > 40){
					relJ = 40;
				}
				else{
					relJ += 3;
				}
			}
			else if(input == 2){
				file = fileLocation + "jActivity3_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			
		}
		else{
			System.out.println("Error: something went wrong with John");
		}
		
		
	}
		
}