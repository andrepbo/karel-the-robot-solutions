/*
 * File: FillerKarel.java
 * ----------------------
 * Karel program named FillerKarel that looks for pairs of beepers 
 * separated by empty horizontal space and "fills in" the space 
 * between them with beepers to create a contiguous line of beepers.
 */

import stanford.karel.*;

public class FillerKarel extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			fillBetween();
			goBackward();
			goNextRow();
		}
	}
	/*
	 * Precondition: Karel is facing east (1, 1)
	 * Postcondition: Karel fills inside beepers
	 */
	private void fillBetween() {
		while(frontIsClear()) {
			if(beepersPresent()) {
				fillInside();
			}
			if(frontIsClear()) {
				move();
			}
		}
	}
	// Karel act to fill inside beepers
	private void fillInside() {
		move();
		while(noBeepersPresent()) {
			putBeeper();
			move();
		}
	}
	/*
	 * Precondition: Karel is facing the wall
	 * Postcondition: Karel turns around and goes back facing west
	 */
	private void goBackward() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
	}
	/*
	 * Precondition: Karel is facing west in front of the wall
	 * Postcondition: Karel goes to the next row facing east
	 */
	private void goNextRow() {
		turnRight();
		if(frontIsClear()) {
			move();
			turnRight();
		}
	}
}
