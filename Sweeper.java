/*
 * File: Sweeper.java
 * ==================
 * Write a Karel program named Sweeper with a method
 * named sweep that causes Karel to walk forward until 
 * he hits a wall, picking up any beepers he finds 
 * along the way. Note that a given square might contain 
 * more than one beeper. Don't try to pick up a beeper if
 * there isn't one on the current square.
 */

import stanford.karel.*;

public class Sweeper extends Karel{
	public void run() {
		while(frontIsClear()) {
			pickUpExistingBeepers();
			move();
		}
		pickUpExistingBeepers();
	}
	
	/*
	 * Karel picks beeper if exists
	 */
	private void pickUpExistingBeepers() {
		if(beepersPresent()) {
			while(beepersPresent()) {
				pickBeeper();
			}
		}
	} 
}
