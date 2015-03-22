package com.kekev.mencoder.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.kekev.mencoder.view.utils.SpringUtilities;

public class FtpFormView extends JFrame {

	private static final long serialVersionUID = 1L;

	public FtpFormView(){
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		setLocation(300, 200);
		
		
		
		
		//4. Size the frame.
		//setSize(300,300);
		
		
		JPanel panel = new JPanel(new SpringLayout());
		panel.add(new JLabel("Host :", JLabel.TRAILING));
		panel.add(new JTextField());
		panel.add(new JLabel("UserName :", JLabel.TRAILING));
		panel.add(new JTextField());
		panel.add(new JLabel("Password :", JLabel.TRAILING));
		panel.add(new JTextField());
		
		SpringUtilities.makeGrid(panel, 3, 2, 6, 6, 6, 6);
		
		add(panel);
		
		this.pack();
		
		//5. Show it.
		setVisible(true);
	}

}
