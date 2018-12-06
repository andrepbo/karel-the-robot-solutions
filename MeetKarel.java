/*
 * File: MeetKarel.java
 * ====================
 * Karel will put the beeper where it should be
 * Author: André Oliveira
 */

import stanford.karel.*;

public class MeetKarel extends Karel {
	public void run(){
        goPickTheBeeper();
        climbWall();
        move();
        putBeeper();
        for(int i = 0; i < 2; i++){
            move();
        }
    }
    /*
     * Karel will collect the beeper.
     */
    private void goPickTheBeeper(){
        while(frontIsClear()){
            move();
        }
        pickBeeper();
    }
    /*
     * Karel climbs the wall.
     */
    private void climbWall(){
        turnLeft();
        move();
        for(int i = 0; i < 3; i++) {
        	turnLeft();
        }
    }
}
