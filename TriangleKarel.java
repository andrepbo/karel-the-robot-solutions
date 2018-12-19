/*
 * File: TriangleKarel.java
 * ------------------------
 * Karel program named TriangleKarel that creates a right-triangle 
 * pattern in Karel's world, with its top-left corner one row down 
 * from the top of the world.
 */

import stanford.karel.*;

public class TriangleKarel extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			startPosition();
		}
	}
	/*
	 * Precondition: Karel starts at top-left corner
	 * Postcondition: Karel standing at the end of the triangle facing south
	 */
	private void startPosition() {
		turnRight();
		if(frontIsClear()) {
			move();
			fillTriangle();
		}
	}
	/*
	 * Precondition: Karel standing at the end of the triangle facing south
	 * Postcondition: Karel fill the line facing south at the last beeper
	 */
	private void fillTriangle() {
		while(frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
		backToStart();
	}
	/*
	 * Precondition: Karel fill the line facing south at the last beeper
	 * Postcondition: Karel on top of line facing north
	 */
	private void backToStart(){
		turnAround();
		while(beepersPresent()) {
			move();
		}
		nextLine();
	}
	/*
	 * Precondition: Karel on top of line facing north
	 * Postcondition: Karel checks if has wall and turnaround or stops
	 */
	private void nextLine() {
		turnAround();
		if(frontIsClear()) {
			move();
		}
		turnLeft();
		if(frontIsClear()) {
			move();
		}
	}
}
