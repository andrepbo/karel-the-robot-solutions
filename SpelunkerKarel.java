/*
 * File: SpelunkerKarel.java
 * -------------------------
 * Karel program named SpelunkerKarel that dives downward into vertical "caves," 
 * retrieving any beepers found at its bottom, and returning from the cave to 
 * deposit all found beepers above/outside the cave.
 */

import stanford.karel.*;

public class SpelunkerKarel extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			findCaves();
			diveToCollectBeeper();
			goBackward();
			depositBeepersOnTop();
		}
		lastCheck();
	}
	/*
	 * Precondition: Karel starts off facing East in column 1.
	 * Postcondition: Karel stops on top of a cave
	 */
	private void findCaves() {
		while(rightIsBlocked()) {
			if(frontIsClear()) {
				move();
			}
		}
	}
	/*
	 * Precondition: Karel stops on top of a cave
	 * Postcondition: Karel dive in to collect beepers
	 */
	private void diveToCollectBeeper() {
		diveDownward();
		collectBeepers();
	}
	/*
	 * Precondition: Karel stops on top of a cave
	 * Postcondition: Karel stops at the bottom of the cave
	 */
	private void diveDownward(){
		turnRight();
		while(frontIsClear()) {
			move();
		}
	}
	/*
	 * Precondition: Karel is standing on top of beepers
	 * Postcondition: Karel collects all beepers
	 */
	private void collectBeepers() {
		while(beepersPresent()) {
			pickBeeper();
		}
	}
	/*
	 * Precondition: Karel is standing at the bottom of the cave
	 * Postcondition: Karel stops at the top of the cave facing east
	 */
	private void goBackward() {
		turnAround();
		while(rightIsBlocked()) {
			move();
		}
		turnRight();
	}
	/*
	 * Precondition: Karel is standing at the top of the cave
	 * Postcondition: Karel deposit all beepers on top of the cave
	 */
	private void depositBeepersOnTop() {
		while(beepersInBag()) {
			putBeeper();
		}
		if(frontIsClear()) {
			move();
		}
	}
	/*
	 * Precondition: Karel is standing at top of last cave
	 * Postcondition: Karel dive in to collect last beepers
	 */
	private void lastCheck() {
		diveToCollectBeeper();
		turnAround();
		while(leftIsBlocked()) {
			move();
		}
		turnRight();
		depositBeepersOnTop();
	}
}
