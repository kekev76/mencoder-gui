package com.kekev.mencoder.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Episode {
	
	private int saison;
	private int episode;
	
	public Episode(String scheme){
		Pattern pattern = Pattern.compile("S\\d\\d");
		Matcher matcher = pattern.matcher(scheme);
		if( matcher.find()){
			saison = Integer.valueOf(matcher.group(0).replaceFirst("S", ""));
		}
		pattern = Pattern.compile("E\\d\\d");
		matcher = pattern.matcher(scheme);
		if( matcher.find()){
			episode = Integer.valueOf(matcher.group(0).replaceFirst("E", ""));
		}
	}
	
	public int getSaison() {
		return saison;
	}

	public int getEpisode() {
		return episode;
	}


}
