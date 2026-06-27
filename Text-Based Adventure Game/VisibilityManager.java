package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 27 June 2026
 * 
 * Description: Manages the visibility of the UI.
 */

public class VisibilityManager {
	UI ui;
	//ParticleManager pm;

	
	public VisibilityManager(UI userInterface) {
		ui = userInterface;
	}
	
	// shows title screen attributes
	// hides game screen and end screen attributes
	public void showTitleScreen() {
		ui.titleNamePanel.setVisible(true);
		ui.titleNameLabel.setText("Quiet is the Deep");
		ui.changeBackground(1);
		//pm.particlesUpdate();
		//pm.repaint();
		ui.startButtonPanel.setVisible(true);
		ui.restartButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.backgroundPanel.setVisible(true);
		
	}
	
	// shows game screen attributes
	// hides title screen and end screen attributes
	public void showGameScreen() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.restartButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.backgroundPanel.setVisible(true);
	}
	
	// shows end screen attributes
	// hides game screen and title screen attributes
	public void showEndScreen() {
		ui.titleNamePanel.setVisible(true);
		ui.titleNameLabel.setText("The End");
		//ui.changeBackground(11);
		ui.startButtonPanel.setVisible(false);
		ui.restartButtonPanel.setVisible(true);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
	}
}
