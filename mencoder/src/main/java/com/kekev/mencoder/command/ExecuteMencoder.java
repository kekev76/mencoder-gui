package com.kekev.mencoder.command;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kekev.mencoder.command.transfert.FtpTransfert;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.VideoService;
import com.kekev.mencoder.view.Fenetre;

public class ExecuteMencoder extends Thread{
	
	private static final String COMMAND = "./ressources/mencoderAvi.sh";
	
	
	public void run(){
		FtpTransfert ftp = new FtpTransfert();
		for(Video video : VideoService.getInstance().findLastVideo()){
			convert(video);
			ftp.uploadFile(video);
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
	        
	        InputStreamReader readerErr = new InputStreamReader ( p.getErrorStream() );
	        BufferedReader buf_readerErr = new BufferedReader ( readerErr );
	       
	        (new OutputLine(buf_readerErr)).start();
	        String line;
	
	        while ((line = buf_reader.readLine ()) != null)
	        {
	            if(format(line)!=null){
	            	video.setStatus(Integer.valueOf(format(line).replace(" ", "")));
	            }
	            
	        }
	        video.setStatus(100);
	        video.setEnding(true);
	        Fenetre.update();
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
