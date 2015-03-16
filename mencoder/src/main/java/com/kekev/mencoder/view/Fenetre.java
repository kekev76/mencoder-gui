package com.kekev.mencoder.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class Fenetre {

	private static final String TITLE = "mencoder";
	
	private VideosModel model;
	private JTable table;
	
	public Fenetre(){
		JFrame frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(100, 100);
		
		frame.setLocation(200, 100);
		
		frame.setJMenuBar(createMenuBar());
		
		
		model = new VideosModel();
		
		table = new JTable(model);

		frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		//4. Size the frame.
		frame.setSize(1000,600);
		
		//5. Show it.
		frame.setVisible(true);
	}
	
	
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Add");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("Ajouter des vidéos et sous-titres");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Add Videos", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Add subs", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		
		return menuBar;
	}

}
