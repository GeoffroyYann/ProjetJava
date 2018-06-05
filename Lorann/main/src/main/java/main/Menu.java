package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu {
	
	/** The level chosen. */
	public int level;
	
	/** The boolean choice. */
	public boolean choix = false;
	
	/**
     * Instantiates a new menu.
     * 
     */
	public Menu() {

		JFrame frame = new JFrame("Play Lorann");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\jad.gif"));
		JLabel labell = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\lorann.gif"));
		JLabel label1 = new JLabel("Level :   ");
		label1.setForeground(Color.WHITE);
		
		JTextField niveau = new JTextField("");
		niveau.setPreferredSize(new Dimension(190, 30));
		niveau.setBackground(Color.WHITE);

		JButton button = new JButton();
		button.setText("Play");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(niveau.getText()) >0 && Integer.parseInt(niveau.getText()) < 7) {
					level = Integer.parseInt(niveau.getText());
					choix = true;
					frame.setVisible(false);
				}	
			}
		});
		
		JLabel label2 = new JLabel("<html>Conceptors: Debieux Johan,<br>Laurenson Quentin, Geoffroy Yann<html>");
		label2.setHorizontalTextPosition(JLabel.CENTER);
		Font font = new Font("Arial",Font.BOLD,12);
		label2.setFont(font);		 
		label2.setForeground(Color.WHITE);
		
		panel.add(label1);
		panel.add(niveau);
		panel.add(label);
		panel.add(button);
		panel.add(labell);
		panel.add(label2);
		
		frame.add(panel);
		frame.setSize(290, 160);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.DARK_GRAY);
		frame.setVisible(true);

	}
}
