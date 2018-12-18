/*
 * File: Roomba.java
 * -----------------
 * Karel program named Roomba that sweeps the entire board of all beepers.
 */

import stanford.karel.*;

public class Roomba extends SuperKarel {
	public void run() {
		pickAvenueBeepers();
		while(frontIsClear()) {
			move();
			pickAvenueBeepers();
		}
	}
	/*
	 * Karel picks up the beepers from the avenue 
	 */
	private void pickAvenueBeepers() {
		turnLeft();
		pickAllBeepers();
		while(frontIsClear()) {
			pickAllBeepers();
			move();
		}
		pickAllBeepers();
		turnAround();
		backToBottom();
		turnLeft();
	}
	/*
	 * Karel goes back to the beginning of the avenue
	 */
	private void backToBottom() {
		while(frontIsClear()) {
			move();
		}
	}
	/*
	 * Karel picks up the beepers from where he's standing
	 */
	private void pickAllBeepers() {
		while(beepersPresent()) {
			pickBeeper();
		}
	}
}
