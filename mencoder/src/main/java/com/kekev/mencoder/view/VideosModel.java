package com.kekev.mencoder.view;

import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.table.AbstractTableModel;

import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.VideoService;

public class VideosModel extends AbstractTableModel {
	
	private final String[] head = {"Video","Subtitle","Ending","Status"};
	
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
			if(videos.get(rowIndex).getSub() != null)
				return videos.get(rowIndex).getSub().getTitle();
			return "";
		case 2:	
			return videos.get(rowIndex).isEnding();		

		case 3:
			return videos.get(rowIndex).getStatus();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/*@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;	
			case 2:
				return Boolean.class;
			case 3:
				return In
			default:
				return Object.class;
		}
	}*/

}
