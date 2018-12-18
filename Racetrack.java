/*
 * File: Racetrack.java
 * --------------------
 * Karel program named Racetrack that walks around the world's 
 * perimeter one time to completion.
 */

import stanford.karel.*;

public class Racetrack extends Karel {
	public void run() {
		for(int i = 0; i < 4; i++) {
			while(frontIsClear()) {
				move();
			}
			turnLeft();
		}
	}
}
