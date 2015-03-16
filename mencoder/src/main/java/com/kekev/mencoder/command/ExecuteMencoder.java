package com.kekev.mencoder.command;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ExecuteMencoder extends Thread{
	
	private static final String COMMAND = "ping -c 3 google.com";
	
	public void run(){ 	
		try{
	        Process p = Runtime.getRuntime().exec(COMMAND);
	
	        OutputStream fout= p.getOutputStream();
	        OutputStream bout= new BufferedOutputStream(fout);
	        OutputStreamWriter out = new OutputStreamWriter(bout);
	        out.write("locals");
	
	        InputStreamReader reader = new InputStreamReader ( p.getInputStream() );
	        BufferedReader buf_reader = new BufferedReader ( reader );
	        String line;
	
	        while ((line = buf_reader.readLine ()) != null)
	        {
	            System.out.println (line);
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}

}
