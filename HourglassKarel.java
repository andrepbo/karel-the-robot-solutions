/*
 * File: HourglassKarel.java
 * -------------------------
 * The hourglass consists of straight lines along the entirety 
 * of the top and bottom of the world, a diagonal line from the 
 * top-left to bottom-right, and a diagonal line from the bottom-left 
 * to the top-right.
 */

import stanford.karel.*;

public class HourglassKarel extends SuperKarel {
	public void run() {
		drawToTop();
		turnAround();
		drawToDown();
	}
	/*
	 * Precondition: Karel starts off facing East at (1, 1)
	 * Postcondition: Karel designed the baseline below
	 */
	private void drawToTop() {
		drawBaseLine();
		turnAround();
		while(frontIsClear()) {
			drawDiagonalLineToTop();
		}
	}
	/*
	 * Karel draws base line at bottom facing east
	 */
	private void drawBaseLine() {
		while(frontIsClear()) {
			if(noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	/*
	 * Precondition: Karel facing west at the end of bottom baseline
	 * Postcondition: Karel draws diagonal line to the top
	 */
	private void drawDiagonalLineToTop() {
		goNextLineToTop();
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	/*
	 * Precondition: Karel facing west at the end of bottom baseline
	 * Postcondition: Karel designed the diagonal line to top facing west
	 */
	private void goNextLineToTop() {
		turnRight();
		if(frontIsClear()) {
			move();
		}
		turnLeft();
		if(frontIsClear()) {
			move();
		}
	}
	/*
	 * Precondition: Karel is facing west at top-left corner
	 * Postcondition: Karel designed the baseline at the top
	 */
	private void drawToDown() {
		drawBaseLine();
		turnAround();
		while(frontIsClear()) {
			drawDiagonalLineToBottom();
		}
	}
	/*
	 * Precondition: Karel facing east at the end of top baseline
	 * Postcondition: Karel draws diagonal line to the bottom
	 */
	private void drawDiagonalLineToBottom() {
		goNextLineToBottom();
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	/*
	 * Precondition: Karel facing west at the end of top baseline
	 * Postcondition: Karel designed the diagonal line to bottom
	 */
	private void goNextLineToBottom() {
		turnLeft();
		if(frontIsClear()) {
			move();
		}
		turnRight();
		if(frontIsClear()) {
			move();
		}
	}
}
