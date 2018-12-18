/*
 * File: DoubleBeepers.java
 * ========================
 * Karel double the number of beepers
 */

import stanford.karel.*;

public class DoubleBeepers extends SuperKarel {
	public void run() {
		move();
		doubleBeepers();
		move();
	}
	/*
	 * Karel double the number of beepers
	 */
	private void doubleBeepers() {
		moveToDoubleBeeper();
		move();
		turnAround();
		moveBackBeepers();
		move();
		turnAround();
	}
	/*
	 * Karel move 2 beepers ahead
	 */
	private void moveToDoubleBeeper() {
		while(beepersPresent()) {
			pickBeeper();
			move();
			for(int i = 0; i < 2; i++) {
				putBeeper();
			}
			turnAround();
			move();
			turnAround();
		}
	}
	/*
	 * Karel will put beepers back in double
	 */
	private void moveBackBeepers() {
		while(beepersPresent()) {
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
	}
}
