/*
 * File: StackerKarel.java
 * -----------------------
 * Karel program named StackerKarel that looks for contiguous 
 * lines of beepers that begin on the left edge of the world 
 * and gathers up those beepers and places them all into a "stack" 
 * at the left edge of the world.
 */

import stanford.karel.*;

public class StackerKarel extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			pickContiguousBeepers();
			goBackward();
			goNetxRows();
		}
	}
	/*
	 * Precondition: Karel facing east (1, 1)
	 * Postcondition: Karel picks the first contiguous beepers
	 */
	private void pickContiguousBeepers() {
		while(beepersPresent()) {
			if(beepersPresent()) {
				while(beepersPresent()) {
					pickBeeper();
				}
			}
			if(frontIsClear()) {
				move();
			}
		}
	}
	/*
	 * Precondition: Karel is facing the wall
	 * Postcondition: Karel goes backward until hit the wall and puts all beepers stacked
	 */
	private void goBackward() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		stackBeepers();
	}
	// Stack beepers in the first square of the row 
	private void stackBeepers() {
		while(beepersInBag()) {
			putBeeper();
		}
	}
	/*
	 * Precondition: Karel is facing west in front of the wall
	 * Postcondition: Karel goes to the next row facing east
	 */
	private void goNetxRows() {
		turnRight();
		if(frontIsClear()) {
			move();
			turnRight();
		}
	} 
}
