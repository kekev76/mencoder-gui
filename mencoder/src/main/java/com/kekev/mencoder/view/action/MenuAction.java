package com.kekev.mencoder.view.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.Retrieve;

public class MenuAction implements ActionListener {
	
	private Component parent;
	
	public MenuAction(Component parent){
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case "Add Videos":
			final JFileChooser fcVideo = new JFileChooser();
			fcVideo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fcVideo.showOpenDialog(parent);
			if(fcVideo.getSelectedFile() != null)
				Video.setPathToVideo(fcVideo.getSelectedFile().getAbsolutePath());
			break;
		case "Add Subs":
			final JFileChooser fcSub = new JFileChooser();
			fcSub.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fcSub.showOpenDialog(parent);
			if(fcSub.getSelectedFile() != null)
				Subtitle.setPath(fcSub.getSelectedFile().getAbsolutePath());
			break;
		case "Retrieve":
			Retrieve.RetrieveVideo();
			Retrieve.RetrieveSub();
			break;

		default:
			break;
		}
	}

}
