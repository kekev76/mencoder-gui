package com.kekev.mencoder.command.transfert;

import java.io.File;
import java.io.IOException;

import com.enterprisedt.net.ftp.EventListener;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.kekev.mencoder.entity.Video;

public class FtpTransfert implements EventListener {

	private FileTransferClient ftp;
	
	private static final String REMOTE_PATH = "/Disque dur/Serie/";
	
	public static String host = "hd1.freebox.fr";
	public static String user = "freebox";
	public static String password = "1111";
	
	private File videoFile;
	private Video video;
	
	public FtpTransfert(){
		ftp = new FileTransferClient();
		try{
			ftp.setRemoteHost(host);
			ftp.setUserName(user);
			ftp.setPassword(password);
			ftp.connect();
			ftp.setEventListener(this);
		}catch(FTPException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadFile(Video video){
		try {
			this.video = video;
			this.videoFile = new File("/tmp/"+video.getTitle().replace(".mp4",".avi"));
			ftp.uploadFile("/tmp/"+video.getTitle().replace(".mp4",".avi"), REMOTE_PATH+video.getTitle().replace(".mp4",".avi"));
		} catch (FTPException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bytesTransferred(String arg0, String arg1, long arg2) {
		int percent = (int)(arg2*100/videoFile.length());
		video.setStatus(percent);
		
	}

	@Override
	public void commandSent(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downloadCompleted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downloadStarted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyReceived(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadCompleted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadStarted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
