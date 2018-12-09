/*
 * File: SpiralKarel.java
 * ======================
 * Karel starts at (3, 2) on a corner containing 8 beepers. 
 * Karel should pick up all of these beepers and then
 * walk out of the spiral until reaching its end at (1, 1). 
 * Every time Karel reaches a corner, he should place a 
 * single beeper there.
 */

import stanford.karel.*;

public class SpiralKarel extends SuperKarel{
	public void run() {
		pickAllBeepers();
		putBeeperInCorners();
		putBeeper();
	}
	/*
	 * Karel picks all beepers
	 */
	private void pickAllBeepers() {
		while(beepersPresent()) {
			pickBeeper();
		}
	}
	/*
	 * Karel puts beepers in all corners
	 */
	private void putBeeperInCorners() {
		while(frontIsClear()) {
			move();
			if(leftIsClear()) {
				putBeeper();
				turnLeft();
			}
		}
	}
}
