package com.kekev.mencoder.view.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.kekev.mencoder.command.ExecuteMencoder;
import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.Retrieve;
import com.kekev.mencoder.services.VideoService;
import com.kekev.mencoder.view.Fenetre;

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
			Fenetre.update();
			break;
		case "Add Subs":
			final JFileChooser fcSub = new JFileChooser();
			fcSub.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fcSub.showOpenDialog(parent);
			if(fcSub.getSelectedFile() != null)
				Subtitle.setPath(fcSub.getSelectedFile().getAbsolutePath());
			Fenetre.update();
			break;
		case "Retrieve":
			Retrieve.RetrieveVideo();
			Retrieve.RetrieveSub();
			Fenetre.update();
			break;

		case "Convert":
			Thread t = new ExecuteMencoder(VideoService.getInstance().findLastVideo().get(1));
			t.start();
			Fenetre.update();
		default:
			break;
		}
	}

}
