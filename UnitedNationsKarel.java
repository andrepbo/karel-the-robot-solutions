/*
 * File: UnitedNationsKarel.java
 * =============================
 * Write a Karel program named UnitedNationsKarel with the following behavior.
 * Suppose the United Nations is using Karel to help repair a flood-damaged area. 
 * Each robot begins at the west end of a street, and along the street are beepers. 
 * Each beeper represents a pile of debris. You should pick up the debris and build 
 * a house, centered where the debris was. The houses should look like the figure 
 * below to the right. Karel must end up facing east at the southeast corner of the world. 
 * Karel should not run into a wall if it builds a house that extends into that final corner. 
 * Your solution should work for a world of any size.
 */

import stanford.karel.*;

public class UnitedNationsKarel extends SuperKarel{
	public void run() {
		while(frontIsClear()) {
			findDebris();
		}
	}
	/*
	 * Karel finds the debris
	 */
	private void findDebris() {
		while(frontIsClear()) {
			move();
			if(beepersPresent()) {
				pickBeeper();
				buildHouse();
			}
		}
	}
	/*
	 * Karel builds the house
	 */
	private void buildHouse() {
		turnAround();
		move();
		turnRight();
		constructPile();
		for(int i = 0; i < 2; i++) {
			turnLeft();
			move();
		}
		constructPile();
		turnLeft();
		if(frontIsClear()) {
			move();
			turnLeft();
			constructPile();
		}
		turnLeft();
	}
	/*
	 * Karel construct piles for the house
	 */
	private void constructPile() {
		putBeeper();
		for(int i = 0; i < 2; i++) {
			move();
			putBeeper();
		}
		turnAround();
		while(frontIsClear()) {
			move();
		}
	}
}
