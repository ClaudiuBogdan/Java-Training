/*
Consider a robot that has been placed in a maze. The right-hand rule tells you how
        to escape from a maze: Always have the right hand next to a wall, and eventually you
        will find an exit. The robot can:
        • Move forward by one unit.
        • Turn left or right.
        • Sense what is in front of it: a wall, an exit, or neither.
        Write an algorithm that lets the robot escape the maze. You may assume that there is
        an exit that is reachable by the right-hand rule. Your challenge is to deal with situations in which the path turns.
         The robot can’t see turns. It can only see what is directly in front of it.
*/

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that solve a maze by right-hand algorithm.
 */
public class MazeSolveRobot {
    private int[][] maze;
    private Point mRobotPosition;
    private final int WALL_ID;
    private Point mExitPosition;
    private List<Point> robotPath = new ArrayList<Point>();
    //Directions ID
    private int direction;
    private final int UP = 1;
    private final int RIGHT = 2;
    private final int DOWN = 3;
    private final int LEFT = 4;
    //Next move
    private int dx = 1;
    private int dy = 0;

    public MazeSolveRobot(int[][] aMaze, int aWALL_ID, Point aEntryPosition, Point aExitPosition){
        this.maze = aMaze;
        this.WALL_ID = aWALL_ID;
        this.mRobotPosition = aEntryPosition;
        this.mExitPosition = aExitPosition;
        this.direction = RIGHT;
    }

    /**
     * Method that solve the maze.
     */
    public void solveMaze(){
        /*
        1. if forward isNotWall
            1.1 Move forward
            1.2 if position is exit
                    STOP
                else GoTo 1
        2. else turn right
                GoTo 1
         */
        while(!mRobotPosition.equals(mExitPosition)){
            int forward_ID = detectForwardPosition();
            if(forward_ID != WALL_ID){
                moveForward();
            }
            else{
                turnRight();
            }
        }

    }

    /**
     * Method that change the current position toward the current direction.
     */
    private void moveForward() {
        mRobotPosition.translate(dx,dy);
        //Add position to the path history.
        robotPath.add((Point) mRobotPosition.clone());
    }

    /**
     * Method that detect the forward position block id.
     * @return id of the forward block
     */
    private int detectForwardPosition() {
        //System.out.println("Current position: " + mRobotPosition.toString() + " Direction: " + direction);
        return maze[(int) mRobotPosition.getX() + dx][(int) mRobotPosition.getY() + dy];
    }

    /**
     * Method that set the new direction to right of the current direction.
     */
    private void turnRight() {
        direction++;
        if(direction > LEFT)
            direction = UP;

        //Set new dx, dy to the new direction
        switch (direction){
            case UP: dx = 0; dy = -1; break;
            case RIGHT: dx = 1; dy = 0; break;
            case DOWN: dx = 0; dy = 1; break;
            case LEFT: dx = -1; dy = 0; break;
            default: break;
        }
    }

}
