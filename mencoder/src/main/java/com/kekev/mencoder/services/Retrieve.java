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
				Subtitle sub = new Subtitle(fichier, new Episode(format(fichier)));
				System.out.println(sub.getTitle());
				int index = getIndexVideo(sub.getEpisode().getEpisode(), videos);
				System.out.println(index);
				videos.get(index-1).setSub(sub);
			}
		}
		Fenetre.update();
	}
	
	private static int getIndexVideo(int episode, List<Video> videos){
		if(videos.size() >= episode-1 && videos.get(episode-1).getEpisode().getEpisode() == episode){
			return episode;
		}
		else{
			if(videos.size() >= episode-1 && videos.get(episode-1).getEpisode().getEpisode() > episode){
				for(int i = episode-1; i > 0 ; i--){
					if(videos.get(i).getEpisode().getEpisode() == episode){
						return i;
					}
				}
			}
			else{
				for(int i = 0; i < episode-1 ; i++){
					if(videos.get(i).getEpisode().getEpisode() == episode){
						return i + 1;
					}					
				}				
			}
		}
		return -1;
	}
}
