/*
 * File: HurdleJumper.java
 * -----------------------
 * Karel program named HurdleJumper that can move Karel up 
 * and over 8 "hurdles" made of walls of arbitrary height. 
 */

import stanford.karel.*;

public class HurdleJumper extends SuperKarel {
	public void run() {
		for(int i = 0; i < 8; i++) {
			jumpHurdle();
		}
	}
	/*
	 * Karel jumps any hurdle
	 */
	private void jumpHurdle() {
		turnLeft();
		while(rightIsBlocked()) {
			move();
		}
		turnRight();
		move();
		turnRight();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
}
