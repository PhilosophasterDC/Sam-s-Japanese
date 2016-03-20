package edu.oakland.helper;

import java.io.*;

public class textWriter{
	
	private String line;
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public void output(String file){
		try{
			fileName = file;
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null){
				System.out.println(line);
			}
		}
		
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" + fileName + "'");
		}
		
		catch(IOException ex){
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}