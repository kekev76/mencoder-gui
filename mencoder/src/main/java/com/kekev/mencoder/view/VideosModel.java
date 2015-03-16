package com.kekev.mencoder.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.VideoService;

public class VideosModel extends AbstractTableModel {
	
	private final String[] head = {"Video","Subtitle","Ending"};
	
	private VideoService videoService;
	private List<Video> videos;
	
	public VideosModel(){
		videoService = VideoService.getInstance();
		videos = videoService.findLastVideo();
		
	}
	
	public void update(){
		videos = videoService.findLastVideo();
	}
	
	public List<Video> getVideos(){
		return videos;
	}

	@Override
	public int getColumnCount() {
		return head.length;
	}
	
	@Override
	public String getColumnName(int columnIndex){
		return head[columnIndex];
	}

	@Override
	public int getRowCount() {
		return videos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return videos.get(rowIndex).getTitle();
		case 1:	
			return videos.get(rowIndex).getSubTitle();	
		case 2:	
			return videos.get(rowIndex).isEnding();		

		default:
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;	
			case 2:
				return Boolean.class;	
			default:
				return Object.class;
		}
	}

}
