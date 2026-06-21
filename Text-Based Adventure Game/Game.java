package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 20 June 2026
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	
	public static void main(String[] args) {
		new Game();
	}
	
	
	public Game() {
		// creates UI for game and then shows only the title screen
		ui.createUI(cHandler);
		vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userChoice = e.getActionCommand();
			
			switch(userChoice) {
			case "start":
				vm.showGameScreen();
				break;
			case "c1":
				break;
			case "c2":
				break;
			case "c3":
				break;
			case "c4":
				break;	
			}
		}
	}
}
