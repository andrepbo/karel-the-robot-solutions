/*
 * File: PotholeFillingKarel.java
 * ==============================
 * Karel will fill all the pot holes.
 * Author: André Oliveira
 */

import stanford.karel.*;

public class PotholeFillingKarel2 extends Karel{
	public void run() {
		while(frontIsClear()) {
			move();
			turnAroundCorner();
			putBeeper();
			turnAround();
			move();
			turnAroundCorner();
		}
	}
	/*
	 * Karel turn right
	 */
	private void turnRight() {
		for(int i = 0; i < 3; i++) {
			turnLeft();
		}
	}
	/*
	 * Karel turn around
	 */
	private void turnAround() {
		for(int i = 0; i < 2; i++) {
			turnLeft();
		}
	}
	/*
	 * Karel turn around the corner
	 */
	private void turnAroundCorner() {
		turnRight();
		move();
	}

}
