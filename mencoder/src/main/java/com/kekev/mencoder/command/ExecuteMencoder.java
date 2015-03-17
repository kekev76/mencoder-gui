package com.kekev.mencoder.command;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.VideoService;

public class ExecuteMencoder extends Thread{
	
	private static final String COMMAND = "./ressources/mencoderAvi.sh";
	
	
	public void run(){
		for(Video video : VideoService.getInstance().findLastVideo()){
			convert(video);
			
		}
	}
	
	public void convert(Video video){ 	
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
	        	System.out.println(line);
	            if(format(line)!=null){
	            	video.setStatus(Integer.valueOf(format(line).replace(" ", "")));
	            }
	        }
	        video.setEnding(true);
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	private String format(String line){
		Pattern pattern = Pattern.compile("\\(..%\\)");
		Matcher matcher = pattern.matcher(line);
		if( matcher.find()){
			pattern = Pattern.compile("(\\s|\\d)\\d");
			matcher = pattern.matcher(matcher.group(0));
			if( matcher.find()){
				return matcher.group(0);
			}
		}
		return null;
	}

}
