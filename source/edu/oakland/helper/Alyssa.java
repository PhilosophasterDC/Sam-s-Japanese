package edu.oakland.helper;

import edu.oakland.helper.*;
import java.util.*;

public class Alyssa{
	
	private int today = 1;
	private int relA = 0;
	private int avg = 0;
	private int money = 50;
	private int input = 0;
	
	private String file;
	private String fileLocation = "textFiles\\";	
	private textWriter writer;
	private Scanner scan = new Scanner(System.in);
	
	
	
	public Alyssa(textWriter text){
		writer = text;
	}
	
	public int talkToAlyssa(int day, int relationA, int average, int cash){
		today = day;
		relA = relationA;
		avg = average;
		money = cash;
		
		interact();
		return(relA);
		
	}
	
	
	private void interact(){
		if(relA == 0){
			file = fileLocation + "alyssa0.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "aActivity0_1.txt";
				writer.output(file);
				relA += 3;
			}
			else if(input == 2){
				file = fileLocation + "aActivity0_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relA > 0){
				System.out.println("\n\n\nCongratulations, you have become friends with Alyssa.");
			}
			
		}
		else if((relA > 0) && (relA <= 20)){
			file = fileLocation + "alyssa1.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "aActivity1_1.txt";
				writer.output(file);
				relA += 3;
			}
			else if(input == 2){
				file = fileLocation + "aActivity1_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relA > 20){
				System.out.println("\n\n\nCongratulations, you have become close friends with Alyssa.");
			}
			
		}
		else if((relA > 20) && (relA <= 30)){
			file = fileLocation + "alyssa2.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "aActivity2_1.txt";
				writer.output(file);
				relA += 3;
			}
			else if(input == 2){
				file = fileLocation + "aActivity2_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			if(relA > 30){
				System.out.println("\n\n\nCongratulations, you have become best friends with Alyssa.");
			}
			
		}
		else if (relA > 30){
			file = fileLocation + "alyssa3.txt";
			writer.output(file);
			input = scan.nextInt();
			
			if(input == 1){
				file = fileLocation + "aActivity3_1.txt";
				writer.output(file);
				if((relA + 3) > 40){
					relA = 40;
				}
				else{
					relA += 3;
				}
			}
			else if(input == 2){
				file = fileLocation + "aActivity3_2.txt";
			}
			else{
				System.out.println("I'm sorry, but '" + input + "' is not a valid response");
			}
			
			
		}
		else{
			System.out.println("Error: something went wrong with Alyssa");
		}
		
		
	}
		
}