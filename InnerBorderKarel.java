/*
 * File: InnerBorderKarel.java
 * ---------------------------
 * Karel program named InnerBorderKarel that creates an inside 
 * border around the world, which is inset by one square from 
 * the outer walls of the world. Each location that is part of 
 * your border should have one (and only one) beeper on it.
 */

import stanford.karel.*;

public class InnerBorderKarel extends SuperKarel {
	public void run() {
		startPosition();
		for (int i = 0; i < 4; i++) {
			makeSquare();
		}
	}
	/*
	 * Precondition: Karel starts at position (1,1)
	 * Postcondition: Karel facing east at position (1,2)
	 */
	private void startPosition() {
		turnLeft();
		move();
		turnRight();
	}
	/*
	 * Precondition: Karel facing east at position (1,2)
	 * Postcondition: Karel standing in last beeper of the line facing next line
	 */
	private void makeSquare() {
		while(frontIsClear()) {
			move();
			if(noBeepersPresent()) {
				putBeeper();
			}
		}
		pickBeeper();
		turnAround();
		move();
		turnAround();
		turnLeft();
	}	
}
