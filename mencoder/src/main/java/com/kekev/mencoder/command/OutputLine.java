package com.kekev.mencoder.command;

import java.io.BufferedReader;
import java.io.IOException;

public class OutputLine extends Thread {

	private BufferedReader reader;
	
	public OutputLine(BufferedReader reader){
		this.reader = reader;
	}
	
	public void run (){
		String line;
		
        try {
			while ((line = reader.readLine ()) != null)
			{
			    /*if(format(line)!=null){
			    	video.setStatus(Integer.valueOf(format(line).replace(" ", "")));
			    }*/
			    System.out.println("error : "+line);
			    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
