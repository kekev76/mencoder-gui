package com.kekev.mencoder.services;

import java.io.File;
import java.text.Format;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kekev.mencoder.entity.Episode;
import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.view.Fenetre;

public class Retrieve {

	public static void RetrieveVideo(){
		
		File repertoire = new File(Video.getPathToVideo());
		String[] fichiers = repertoire.list();
		
		VideoService service = VideoService.getInstance();
		
		for(String fichier : fichiers){
			if(isVideo(fichier)){
				service.addVideo(new Video(fichier, new Episode(format(fichier))));
			}
		}
		Fenetre.update();
	}
	
	private static String format(String message){
		Pattern pattern = Pattern.compile("S\\d\\dE\\d\\d");
		Matcher matcher = pattern.matcher(message);
		if( matcher.find()){
			return matcher.group(0);
		}
		return "";
	}
	
	private static boolean isVideo(String fichier){
		return fichier.endsWith(".mp4") || fichier.endsWith(".avi") || fichier.endsWith(".mkv");
	}
	
	public static void RetrieveSub(){
		
		File repertoire = new File(Subtitle.getPath());
		String[] fichiers = repertoire.list();

		List<Video> videos = VideoService.getInstance().findLastVideo();
		
		
		for(String fichier : fichiers){
			if(fichier.endsWith(".srt")){
				System.out.println(fichier +":"+format(fichier));
				Subtitle sub = new Subtitle(fichier, new Episode(format(fichier)));
				int index = getIndexVideo(sub.getEpisode().getEpisode(), videos);
				videos.get(index).setSub(sub);
			}
		}
		Fenetre.update();
	}
	
	private static int getIndexVideo(int episode, List<Video> videos){
		System.out.println(episode);
		if(videos.get(episode).getEpisode().getEpisode() == episode){
			return episode;
		}
		else{
			if(videos.get(episode).getEpisode().getEpisode() > episode){
				for(int i = episode; i > 0 ; i--){
					if(videos.get(i).getEpisode().getEpisode() == episode){
						return i;
					}
				}
			}
			else{
				for(int i = 0; i < episode ; i++){
					if(videos.get(i).getEpisode().getEpisode() == episode){
						return i;
					}					
				}				
			}
		}
		return -1;
	}
}
