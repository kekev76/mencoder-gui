package com.kekev.mencoder.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.kekev.mencoder.command.transfert.FtpTransfert;
import com.kekev.mencoder.view.utils.SpringUtilities;

public class FtpFormView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JTextField host, user, password;

	public FtpFormView(){
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		setLocation(300, 200);
		
		
		
		
		//4. Size the frame.
		//setSize(300,300);
		
		
		host = new JTextField(FtpTransfert.host);
		user = new JTextField(FtpTransfert.user);
		password = new JTextField(FtpTransfert.password);
		
		JPanel panel = new JPanel(new SpringLayout());
		panel.add(new JLabel("Host :", JLabel.TRAILING));
		panel.add(host);
		panel.add(new JLabel("UserName :", JLabel.TRAILING));
		panel.add(user);
		panel.add(new JLabel("Password :", JLabel.TRAILING));
		panel.add(password);
		
		
		JButton button = new JButton("Validate");
		button.addActionListener(this);
		
		panel.add(button);
		
		button = new JButton("Test");
		button.addActionListener(this);
		
		panel.add(button);
		
		SpringUtilities.makeGrid(panel, 4, 2, 6, 6, 6, 6);
		
		add(panel);
		
		this.pack();
		
		
		
		//5. Show it.
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Validate")){
			FtpTransfert.host = host.getText();
			FtpTransfert.user = user.getText();
			FtpTransfert.password = password.getText();
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("Test")){
			new FtpTransfert();
		}
		
	}

}
