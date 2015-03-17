package com.kekev.mencoder.command;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.kekev.mencoder.entity.Video;

public class ExecuteMencoder extends Thread{
	
	private static final String COMMAND = "./ressources/mencoderAvi.sh";
	
	private Video video;
	
	public ExecuteMencoder(Video video){
		this.video = video;
	}
	
	public void run(){ 	
		try{
			
			String videoOriginPath = video.getPathToVideo()+"/"+video.getTitle();
			String subOriginPath = video.getSub().getPath()+"/"+video.getSub().getTitle();
			String videofinalPath = "/tmp/"+video.getTitle().replace(".mp4", ".avi");
			
			System.out.println ("Command Execute : "+COMMAND+ " " + videoOriginPath + " " + subOriginPath + " " + videofinalPath);
			
	        Process p = Runtime.getRuntime().exec(COMMAND+ " " + videoOriginPath + " " + subOriginPath + " " + videofinalPath);
	
			 
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
