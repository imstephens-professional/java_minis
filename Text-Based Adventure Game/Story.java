package lookheress;
/*
 * Author: Isabella Stephens
 * Created: 19 June 2026
 * Updated: 27 June 2026
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
			case "strange house": 	strangeHouse();			break;
			case "continue deeper": walkDeeperAgain();		break;
			case "ask caretaker why", "ask caretaker how", "ask caretaker when", "ask caretaker where": askTheCaretaker(); break;
			case "resting": 		gameOverRest();			break;
			case "farther":			gameOverFarther();		break;
			case "reset":			gameReset();			break;
		}
	}
	
	
	public void firstCutscene() {
		ui.mainTextArea.setText("We will meet.\n \n"
				+ "Down, down, down past where the river bends into the ocean. There, we will meet.\n \n"
				+ "Come find me.");
		ui.choiceButtonPanel.setVisible(true);
		
		ui.chOne.setText("I Will");
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(1);
		
		game.nextPos1 = "ocean traversal";
	}
	
	public void oceanTraversal() {
		ui.mainTextArea.setText("The water is wine dark.\n\n"
				+ "The pressure on your skin is immense, soothing as it is intense.\n\n"
				+ "Sand smooths your soft feet, sneaking under your nails and stabbing like the salt heavy on your tongue.\n\n"
				+ "Where will you go?");
		ui.choiceButtonPanel.setVisible(true);
		
		ui.chOne.setText("Swim Up");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("Walk Deeper");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "swim up";
		game.nextPos2 = "walk deeper";
	}
	
	public void twoSwimUp() {
		ui.mainTextArea.setText("You reach out with your hands and feet and push against the water.\n\n"
				+ "The wine dark lightens to bright blue. The water's surface ripples the sunlight filtering through.\n\n"
				+ "You made it. Now what will you do?");
		
		ui.chOne.setText("Breach the Surface");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("Sink Back Down");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "breach surface";
		game.nextPos2 = "ocean traversal";
	}
	
	public void twoBreachSurface() {
		ui.mainTextArea.setText("Your hands reach toward the surface, but you cannot breach it, no matter how hard you push.\n\n"
				+ "It is like fluid glass against your palms.\n\n"
				+ "There is no returning to the open air.");
		
		ui.chOne.setText("Sink Back Down");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "ocean traversal";
	}
	
	public void oneWalkDeeper() {
		ui.mainTextArea.setText("It's harder to walk on the ocean floor than on land, you realize.\n\n"
				+ "Every step is another fight. The water presses on your back and shoulders like a coffin lid waiting to close.\n\n"
				+ "You know that the moment you stop standing that you'll stop moving at all, so you continue.");
		
		ui.chOne.setText("Continue Deeper");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "strange house";
	}
	
	public void strangeHouse() {
		ui.mainTextArea.setText("You walk and walk and walk without end.\n\n"
				+ "You swear something soft brushes against your calves occasionally, but you can never get a glimpse of what it is.\n\n"
				+ "You eventually catch sight of a strange house glowing in the distance.");
		
		ui.chOne.setText("Enter the House");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "continue deeper";
	}
	
	public void walkDeeperAgain() {
		ui.mainTextArea.setText("You enter.\n\n"
				+ "You meet a strange figure. It asks what you want to know regarding your presence here.");
		
		ui.chOne.setText("Why are you here?");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("How are you here?");
		ui.chTwo.setVisible(true);
		ui.chThree.setText("Where are you?");
		ui.chThree.setVisible(true);
		ui.chFour.setText("When Can You Leave?");
		ui.chFour.setVisible(true);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "ask caretaker why";
		game.nextPos2 = "ask caretaker how";
		game.nextPos3 = "ask caretaker where";
		game.nextPos4 = "ask caretaker when";
	}
	
	public void askTheCaretaker() {
		if(nextPosition.equals("ask caretaker why")) {
			ui.mainTextArea.setText("'You are here because you perished.\n\n "
					+ "Now, you are here because you seek something."
					+ "Do you remember what?'");
			ui.chOne.setVisible(false);
			
		} else if(nextPosition.equals("ask caretaker how")) {
			ui.mainTextArea.setText("'You were always here.\n\n"
					+ "You only remember now.'");
			ui.chTwo.setVisible(false);
			
		} else if(nextPosition.equals("ask caretaker where")) {
			ui.mainTextArea.setText("'Down, down, down past the river and deep where you originated from.'");
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
		
		//ui.changeBackground(2);
	}
	
	public void finalChoice() {
		ui.mainTextArea.setText("The strange figure stands back.\n\n"
				+ "'Now that you are back, what do you want to do?\n\n"
				+ "There are only two real options.'");
		
		ui.chOne.setText("I want to rest");
		ui.chOne.setVisible(true);
		ui.chTwo.setText("I want to explore");
		ui.chTwo.setVisible(true);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		//ui.changeBackground(2);
		
		game.nextPos1 = "resting";
		game.nextPos2 = "farther";
	}
	
	public void gameOverRest() {
		ui.mainTextArea.setText("You want to finally rest after a lifetime of toil.\n\n"
				+ "You wish to sink to the bottom.");
		
		//ui.changeBackground(2);
		
		ui.chOne.setText("And So I Disappear");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "reset";
	}
	
	public void gameOverFarther() {
		ui.mainTextArea.setText("You want to know more about this universe you never knew.\n\n"
				+ "You fall deeper, and deeper, and deeper.");
		
		//ui.changeBackground(2);
		
		ui.chOne.setText("And So I Leave");
		ui.chOne.setVisible(true);
		ui.chTwo.setVisible(false);
		ui.chThree.setVisible(false);
		ui.chFour.setVisible(false);
		
		game.nextPos1 = "reset";
	}
	
	public void gameReset() {
		vm.showEndScreen();
	}
}
