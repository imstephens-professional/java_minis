package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 22 June 2026
 * 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import lookheress.Game.ChoiceHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI {
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, restartButtonPanel, mainTextPanel, choiceButtonPanel, backgroundPanel;
	JLabel titleNameLabel, backLabel;
	JButton startButton, restartButton, chOne, chTwo, chThree, chFour;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	ImageIcon titleScreen_img, oceanTraversal_img, swimUp_img, breachSurface_img, continueDeeper_img, meetCaretaker_img,
				askCaretaker_img, finalDecision_img, restingEnding_img, fartherEnding_img, theEndScreen_img;
	
	public void createUI(ChoiceHandler cHandler) {
		// WINDOW
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		// TITLE SCREEN
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(90, 100, 600, 110);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Quiet is the Deep");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setOpaque(false); 
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
		mainTextPanel.setBounds(100,30,600,500);
		//mainTextPanel.setBackground(Color.black);
		mainTextPanel.setOpaque(false); 
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		//mainTextArea.setOpaque(false); 
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		//choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setOpaque(false); 
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
		
		// RESTART BUTTON
		restartButtonPanel = new JPanel();
		restartButtonPanel.setBounds(300, 400, 200, 100);
		restartButtonPanel.setOpaque(false); 
		restartButton = new JButton("Restart");
		restartButton.setBackground(Color.black);
		restartButton.setForeground(Color.white);
		restartButton.setFont(normalFont);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(cHandler);
		restartButton.setActionCommand("restart");
		restartButtonPanel.add(restartButton);
		window.add(restartButtonPanel);
		
		// BACKGROUND ANIMATIONS
		backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 800, 600);
		backLabel = new JLabel();
		backLabel.setBounds(0, 0, 800, 600);
		backgroundPanel.add(backLabel);
		window.add(backgroundPanel);
		
		window.setVisible(true);
	}
	
	public void changeBackground(int choice) {
		titleScreen_img = new ImageIcon("Images/titleScreen.png");
		oceanTraversal_img = new ImageIcon("Images/oceanTraversal_img.png");
		swimUp_img = new ImageIcon("Images/swimUp_img.png"); 
		breachSurface_img = new ImageIcon("Images/breachSurface_img.png");
		continueDeeper_img = new ImageIcon("Images/continueDeeper_img.png");
		meetCaretaker_img = new ImageIcon("Images/meetCaretaker_img.png");
		askCaretaker_img = new ImageIcon("Images/askCaretaker_img.png");
		finalDecision_img = new ImageIcon("Images/finalDecision_img.png");
		restingEnding_img = new ImageIcon("Images/restingEnding_img.png");
		fartherEnding_img = new ImageIcon("Images/fartherEnding_img.png");
		theEndScreen_img = new ImageIcon("Images/theEndScreen_img.png");
			
		switch(choice) {
			case 1: 
				backLabel.setIcon(titleScreen_img);
				break;
			case 2:
				backLabel.setIcon(oceanTraversal_img);
				break;
			case 3:
				backLabel.setIcon(swimUp_img);
				break;
			case 4:
				backLabel.setIcon(breachSurface_img);
				break;
			case 5:
				backLabel.setIcon(continueDeeper_img);
				break;
			case 6:
				backLabel.setIcon(meetCaretaker_img);
				break;
			case 7:
				backLabel.setIcon(askCaretaker_img);
				break;
			case 8:
				backLabel.setIcon(finalDecision_img);
				break;
			case 9:
				backLabel.setIcon(restingEnding_img);
				break;
			case 10:
				backLabel.setIcon(fartherEnding_img);
				break;
			case 11:
				backLabel.setIcon(theEndScreen_img);
				break;
			default:
				backLabel.setIcon(titleScreen_img);
		}
	}
}
