/*
 * File: ChadKarel.java
 * ====================
 * Karel starts on the left of a ballot and should progress through 
 * each column. If a column contains a beeper in the center row (row 2),  
 * the voter did not intend to vote on that column, and Karel should
 * move to the next column. However, if a column contains no beeper in 
 * the center row, Karel must make sure that there is no hanging chad. 
 * In this case, Karel should check the corners above and below to make sure all  
 * beepers in that column were removed. A corner may contain any 
 * number of beepers. Karel must finish execution facing east 
 * at the rightmost edge of the ballot. For example, if we start out 
 * with the ballot below at left, your program should create the ballot below at right. 
 * Your program should work for a ballot with any number of columns.
 */

import stanford.karel.*;

public class ChadKarel extends SuperKarel {
	public void run() {
		while (frontIsClear()) {
			processRectangle();
			move();
		}
		processRectangle();
	}
	/*
	 * Karels cleans all beepers
	 */
	private void processRectangle() {
		if (noBeepersPresent()) {
			removeAllChad();
		}
	}
	/*
	 * Karel remove all chad
	 */
	private void removeAllChad() {
		turnLeft();
		cleanChad();
		turnAround();
		cleanChad();
		turnLeft();
	}
	/*
	 * Karel clean chad
	 */
	private void cleanChad() {
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
	moveBackward();
	}
	/*
	 * Karel goes back to center
	 */
	private void moveBackward() {
		turnAround();
		move();
		turnAround();
	}
}
