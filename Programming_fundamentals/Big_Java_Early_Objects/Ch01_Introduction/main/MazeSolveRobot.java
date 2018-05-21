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
    private Point frontPosition;
    private Point rightPosition;
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
        1. if currentPosition equal exitPosition
            1.1. EXIT
        2. if forward isn't wall
            2.2 Turn right and look if is not wall
            2.3 If is not wall move forward
            2.4 Else turn left and move forward
        3. Turn right and see if is wall
            3.1 If is wall, turn left twice and see if isn't wall
            3.2 If isn't wall, move forward
            3.3 Else turn left and move forward
        4. Go to 1

         */
        moveForward(); //Make the first move to enter the maze
        while(!mRobotPosition.equals(mExitPosition)){
            int forward_id = detectForwardPosition();
            if(forward_id != WALL_ID){
                turnRight(); //Turn right to detect path available.
                int right_id = detectForwardPosition();
                if(right_id == WALL_ID ){
                    turnLeft();
                }
                moveForward();
            }
            else{
                turnRight();
                int right_id = detectForwardPosition();
                if(right_id == WALL_ID ){
                    turnLeft();
                    turnLeft();
                }
                forward_id = detectForwardPosition();
                if (forward_id != WALL_ID){
                    moveForward();
                }
                else {
                    turnLeft();
                    moveForward();
                }

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
        setNewMoveDirection();
    }

    private void turnLeft() {
        direction--;
        if(direction < UP)
            direction = LEFT;
        setNewMoveDirection();
    }

    private void setNewMoveDirection(){
        //Set new dx, dy to the new direction
        switch (direction){
            case UP: dx = 0; dy = -1; break;
            case RIGHT: dx = 1; dy = 0; break;
            case DOWN: dx = 0; dy = 1; break;
            case LEFT: dx = -1; dy = 0; break;
            default: break;
        }
    }

    public List<Point> getRobotPath() {
        return robotPath;
    }
}
