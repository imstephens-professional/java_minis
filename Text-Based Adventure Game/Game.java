package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 22 June 2026
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story st = new Story(this, ui, vm);
	
	String nextPos1, nextPos2, nextPos3, nextPos4;
	
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
				st.firstCutscene();
				break;
			case "c1":
				st.selectPosition(nextPos1);
				break;
			case "c2":
				st.selectPosition(nextPos2);
				break;
			case "c3":
				st.selectPosition(nextPos3);
				break;
			case "c4":
				st.selectPosition(nextPos4);
				break;	
			case "restart":
				vm.showTitleScreen();
			}
		}
	}
}
