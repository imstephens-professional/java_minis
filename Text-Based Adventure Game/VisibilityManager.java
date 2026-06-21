package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 20 June 2026
 * 
 * Description: Manages the visibility of the UI.
 */

public class VisibilityManager {
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		ui = userInterface;
	}
	
	// shows title screen attributes
	// hides game screen and end screen attributes
	public void showTitleScreen() {
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
	}
	
	// shows game screen attributes
	// hides title screen and end screen attributes
	public void showGameScreen() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
	}
	
	// shows end screen attributes
	// hides game screen and title screen attributes
	public void showEndScreen() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
	}
}
