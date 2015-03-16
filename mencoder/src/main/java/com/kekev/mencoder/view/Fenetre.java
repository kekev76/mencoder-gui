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

import com.kekev.mencoder.view.action.MenuAction;

public class Fenetre {

	private static final String TITLE = "mencoder";
	
	private VideosModel model;
	private JTable table;
	private JFrame frame;
	
	public static Fenetre fenetre;
	
	public Fenetre(){
		frame = new JFrame(TITLE);
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
		
		fenetre = this;
	}
	
	public static void update(){
		fenetre.model.fireTableDataChanged();
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
		menuItem.addActionListener(new MenuAction(frame));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Add Subs", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new MenuAction(frame));
		menu.add(menuItem);
		

		menu = new JMenu("Start");
		menu.setMnemonic(KeyEvent.VK_S);
		
		menuItem = new JMenuItem("Retrieve", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new MenuAction(frame));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Convert", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new MenuAction(frame));
		menu.add(menuItem);
		menuBar.add(menu);
		
		return menuBar;
	}

}
