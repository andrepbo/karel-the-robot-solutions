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
		turnLeft();
		move();
		turnRight();
		for (int i = 0; i < 4; i++) {
			tipOfSquare();
		}
	}
	/*
	 * Precondition: Karel facing east at position (1,2)
	 * Postcondition: Karel standing in last beeper of the line facing next line
	 */
	private void tipOfSquare() {
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
