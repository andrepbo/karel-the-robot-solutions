/*
 * File: BeeperCollector.java
 * ================================
 * Karel’s job is to collect all the beepers in each of these towers, 
 * put them back down on the easternmost corner of 1st Street, 
 * and then return to its starting position. Thus, when Karel 
 * finishes its work in the example above, all 21 beepers currently 
 * in the towers should be stacked on the corner of 9th Avenue and 1st Street
 */

import stanford.karel.*;

public class BeeperCollector extends SuperKarel {
	public void run() {
		collectAllBeepers();
		dropAllBeepers();
		returnHome();
	}
	/*
	 * This method makes Karel collect all beepers
	 */
	private void collectAllBeepers() {
		while(frontIsClear()) {
			collectOneTower();
			move();
		}
		collectOneTower();
	}
	/*
	 * This method makes Karel pick all beepers from a tower
	 */
	private void collectOneTower() {
		if(beepersPresent()) {
			collectActualTower();
		}
	}
	/*
	 * This method makes Karel collect one tower
	 */
	private void collectActualTower() {
		turnLeft();
		collectLineOfBeepers();
		turnAround();
		moveToWall();
		turnLeft();
	}
	/*
	 * This method makes Karel collect the line of beepers
	 */
	private void collectLineOfBeepers() {
		while(beepersPresent()) {
			pickBeeper();
			if(frontIsClear()) {
				move();
			}
		}
	}
	/*
	 * Moves Karel forward until it is blocked by a wall.
	 */
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	/*
	 * Drops all the beepers on the current corner.
	 */
	private void dropAllBeepers() {
		while(beepersInBag()) {
			putBeeper();
		}
	} 
	/*
	 * Return Karel to inittiated position
	 */
	private void returnHome() {
		turnAround();
		moveToWall();
		turnAround();
	}
}
