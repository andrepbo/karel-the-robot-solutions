/*
 * File: ThreeBeepers.java
 * =======================
 * This program makes Karel Collect all three
 * beepers and place all at (6,2)
 * Author: André Oliveira
 */

import stanford.karel.*;

public class ThreeBeepers extends Karel{
	public void run() {
		turnLeft();
		goToPickTheBeepers();
		for(int i = 0; i < 2; i++) {
			turnRight();
			goToPickTheBeepers();	
		}
		for(int i = 0; i < 3; i++) {
			turnLeft();
			goToPickTheBeepers();	
		}
		turnAround();
		goToPickTheBeepers();
		
		for(int i = 0; i < 3; i++) {
			turnRight();
			goToPickTheBeepers();	
		}
		turnRight();
		goToPutTheBeepers();
	}
	private void goToPickTheBeepers() {
		while(frontIsClear()) {
			move();
			while(beepersPresent()) {
				pickBeeper();
			}
		}
	}
	private void turnRight() {
		for(int i = 0; i < 3; i++) {
			turnLeft();
		}
	}
	private void turnAround() {
		for(int i = 0; i < 2; i++) {
			turnLeft();
		}
	}
	private void goToPutTheBeepers() {
		while(frontIsClear()) {
			move();
			for(int i = 0; i < 2; i++) {
				putBeeper();
			}
		}
	}
}
