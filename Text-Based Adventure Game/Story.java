package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 22 June 2026
 * 
 */

public class Story {
	Game game;
	UI ui;
	VisibilityManager vm;
	String nextPosition;
	int choiceCounter = 0;
	
	public Story(Game game, UI ui, VisibilityManager vm) {
		this.game = game;
		this.ui = ui;
		this.vm = vm;
	}
	
	/*
	 * story event methods
	 */
	public void selectPosition(String nextPos) {
		nextPosition = nextPos; 
		
		switch(nextPos) {
			case "swim up": 		twoSwimUp(); 			break;
			case "walk deeper": 	oneWalkDeeper(); 		break;
			case "breach surface": 	twoBreachSurface(); 	break;
			case "ocean traversal": oceanTraversal();		break;
			case "continue deeper": walkDeeperAgain();		break;
			case "ask caretaker why", "ask caretaker how", "ask caretaker when", "ask caretaker where": askTheCaretaker(); break;
			case "resting": 		gameOverRest();			break;
			case "farther":			gameOverFarther();		break;
		}
	}
	
	// FIND A WAY TO MAKE THE PLAYER HAVE TO PRESS ENTER FOR THE TEXT
	public void firstCutscene() {
		ui.mainTextArea.setText("We will meet.");
		ui.mainTextArea.setText("Down, down, down past where the river bends into the ocean. There, we will meet.");
		ui.mainTextArea.setText("Come find me.");
		ui.choiceButtonPanel.setVisible(true);
		
		ui.chOne.setText("I Will");
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "ocean traversal";
	}
	
	public void oceanTraversal() {
		ui.mainTextArea.setText("The water is wine dark.");
		ui.mainTextArea.setText("The pressure on your skin is immense, soothing as it is intense.");
		ui.mainTextArea.setText("Sand smooths your soft feet, sneaking under your nails and stabbing like the salt heavy on your tongue.");
		ui.mainTextArea.setText("Where will you go?");
		ui.choiceButtonPanel.setVisible(true);
		
		ui.chOne.setText("Swim Up");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("Walk Deeper");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "swim up";
		game.nextPos2 = "walk deeper";
	}
	
	public void twoSwimUp() {
		ui.mainTextArea.setText("You reach out with your hands and feet and push against the water.");
		ui.mainTextArea.setText("The wine dark lightens to bright blue. The water's surface ripples the sunlight filtering through.");
		ui.mainTextArea.setText("You made it. Now what will you do?");
		
		ui.chOne.setText("Breach the Surface");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("Sink Back Down");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "breach surface";
		game.nextPos2 = "ocean traversal";
	}
	
	public void twoBreachSurface() {
		ui.mainTextArea.setText("Your hands reach toward the surface, but you cannot breach it, no matter how hard you push.");
		ui.mainTextArea.setText("It is like fluid glass against your palms.");
		ui.mainTextArea.setText("There is no returning to the open air.");
		
		ui.chOne.setText("Sink Back Down");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "ocean traversal";
	}
	
	public void oneWalkDeeper() {
		ui.mainTextArea.setText("It's harder to walk on the ocean floor than on land, you realize.");
		ui.mainTextArea.setText("Every step is another fight. The water presses on your back and shoulders like a coffin lid waiting to close");
		ui.mainTextArea.setText("You know that the moment you stop standing that you'll stop moving at all, so you continue.");
		
		ui.chOne.setText("Continue Deeper");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "continue deeper";
	}
	
	public void walkDeeperAgain() {
		ui.mainTextArea.setText("");
		ui.mainTextArea.setText("You meet a strange figure in a strange house. It asks what you want to know regarding your presence here");
		
		ui.chOne.setText("Ask Why You're Here");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("Ask How You're Here");
		ui.chTwo.setVisible(true);
		ui.chThree.setText("Ask Where You Are");
		ui.chThree.setVisible(true);
		ui.chFour.setText("Ask When You Can Leave");
		ui.chFour.setVisible(true);
		
		game.nextPos1 = "ask caretaker why";
		game.nextPos2 = "ask caretaker how";
		game.nextPos3 = "ask caretaker where";
		game.nextPos4 = "ask caretaker when";
	}
	
	public void askTheCaretaker() {
		if(nextPosition.equals("ask caretaker why")) {
			ui.mainTextArea.setText("'You are here because you perished. Now, you are here because you seek something.'");
			ui.chOne.setVisible(false);
			
		} else if(nextPosition.equals("ask caretaker how")) {
			ui.mainTextArea.setText("'You '");
			ui.chTwo.setVisible(false);
			
		} else if(nextPosition.equals("ask caretaker where")) {
			ui.mainTextArea.setText("'Down, down, down past the river and deep into where you originated from.'");
			ui.chThree.setVisible(false);
			
		} else if(nextPosition.equals("ask caretaker when")) {
			ui.mainTextArea.setText("'You can leave whenever you want. You just may never go back to where you were.");
			ui.chFour.setVisible(false);
			
		} else {
			ui.mainTextArea.setText("ERROR");
		}
		
		choiceCounter++;
		
		if(choiceCounter >= 4) {
			choiceCounter = 0;
			finalChoice();
		}
	}
	
	public void finalChoice() {
		ui.mainTextArea.setText("lmao");
		
		ui.chOne.setText("I want to rest");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("I want to explore");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "resting";
		game.nextPos2 = "farther";
	}
	
	public void gameOverRest() {
		
		gameReset();
	}
	
	public void gameOverFarther() {
		ui.mainTextArea.setText("You fall deeper, and deeper, and deeper.");
		
		gameReset();
	}
	
	public void gameReset() {
		vm.showEndScreen();
	}
}
