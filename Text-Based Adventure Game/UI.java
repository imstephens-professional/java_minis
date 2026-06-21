package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 20 June 2026
 * 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import lookheress.Game.ChoiceHandler;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

public class UI {
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
	JLabel titleNameLabel;
	JButton startButton, chOne, chTwo, chThree, chFour;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	
	public void createUI(ChoiceHandler cHandler) {
		// WINDOW
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		// TITLE SCREEN
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 500);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Quiet is the Deep");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		// GAME SCREEN
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);
		
		chOne = new JButton("first choice");
		chOne.setBackground(Color.black);
		chOne.setForeground(Color.white);
		chOne.setFont(normalFont);
		chOne.setFocusPainted(false);
		chOne.addActionListener(cHandler);
		chOne.setActionCommand("c1");
		choiceButtonPanel.add(chOne);
		
		chTwo = new JButton("second choice");
		chTwo.setBackground(Color.black);
		chTwo.setForeground(Color.white);
		chTwo.setFont(normalFont);
		chTwo.setFocusPainted(false);
		chTwo.addActionListener(cHandler);
		chTwo.setActionCommand("c2");
		choiceButtonPanel.add(chTwo);
		
		chThree = new JButton("third choice");
		chThree.setBackground(Color.black);
		chThree.setForeground(Color.white);
		chThree.setFont(normalFont);
		chThree.setFocusPainted(false);
		chThree.addActionListener(cHandler);
		chThree.setActionCommand("c3");
		choiceButtonPanel.add(chThree);
		
		chFour = new JButton("fourth choice");
		chFour.setBackground(Color.black);
		chFour.setForeground(Color.white);
		chFour.setFont(normalFont);
		chFour.setFocusPainted(false);
		chFour.addActionListener(cHandler);
		chFour.setActionCommand("c4");
		choiceButtonPanel.add(chFour);
		
		window.setVisible(true);
	}
}
