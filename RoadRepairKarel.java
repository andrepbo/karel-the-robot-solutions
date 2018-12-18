/*
 * File: RoadRepairKarel.java
 * --------------------------
 * Karel program named RoadRepairKarel that looks for "potholes" 
 * in the road ahead of him and fills in each with a single beeper.
 */

import stanford.karel.*;

public class RoadRepairKarel extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			checkForPothole();
			move();
		}
		checkForPothole();
	}
	/*
	 * Karel fill pothole if empty
	 */
	private void checkForPothole() {
		if(rightIsClear()) {
			turnRight();
			move();
			if(noBeepersPresent()) {
				putBeeper();
			}
			turnAround();
			move();
			turnRight();
		}
	}
}
