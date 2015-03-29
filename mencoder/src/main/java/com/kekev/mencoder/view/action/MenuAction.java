package com.kekev.mencoder.view.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.kekev.mencoder.command.ExecuteMencoder;
import com.kekev.mencoder.command.transfert.FtpTransfert;
import com.kekev.mencoder.entity.Subtitle;
import com.kekev.mencoder.entity.Video;
import com.kekev.mencoder.services.Retrieve;
import com.kekev.mencoder.services.VideoService;
import com.kekev.mencoder.view.Fenetre;
import com.kekev.mencoder.view.FtpFormView;

public class MenuAction implements ActionListener {
	
	private Component parent;
	
	public MenuAction(Component parent){
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case "Add Videos":
			final JFileChooser fcVideo = new JFileChooser("/home/kevin/Vidéos");
			fcVideo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fcVideo.showOpenDialog(parent);
			if(fcVideo.getSelectedFile() != null)
				Video.setPathToVideo(fcVideo.getSelectedFile().getAbsolutePath());
			Fenetre.update();
			break;
		case "Add Subs":
			final JFileChooser fcSub = new JFileChooser((Video.getPathToVideo() != null) ? Video.getPathToVideo() : "/home/kevin/Vidéos");
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
			Thread t = new ExecuteMencoder();
			t.start();
			Fenetre.update();
			break;
		case "FTP":
			new FtpFormView();
			break;
		default:
			break;
		}
	}

}
