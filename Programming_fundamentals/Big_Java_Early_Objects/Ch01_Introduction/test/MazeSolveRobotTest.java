
import com.mazze.rubicon.maze.GenerateMaze;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

public class MazeSolveRobotTest {

    @Test
    public void solveMaze() {
        Point firstPoint = new Point(1,2);
        Point secondPoint = new Point(1,2);
        Point thirdPoint = new Point(1,1);
        Point fourthPoint = (Point) firstPoint.clone();
        assertTrue(firstPoint.equals(secondPoint));
        assertFalse(firstPoint.equals(thirdPoint));
        thirdPoint.translate(0,1);
        assertTrue(firstPoint.equals(thirdPoint));
        assertTrue(fourthPoint.equals(firstPoint));
        fourthPoint.translate(0,-1);
        assertFalse(fourthPoint.equals(firstPoint));
        thirdPoint.translate(0,-1);
        assertTrue(fourthPoint.equals(thirdPoint));

        GenerateMaze generateMaze = new GenerateMaze(5,3,2,2);
        Point entryPosition = new Point(generateMaze.getENTRY_POSITION().getHorizontalPosition(),
                                generateMaze.getENTRY_POSITION().getVerticalPosition());
        Point exitPosition = new Point(generateMaze.getEXIT_POSITION().getHorizontalPosition(),
                generateMaze.getEXIT_POSITION().getVerticalPosition());
        System.out.println("Entry position: " + entryPosition.toString());
        System.out.println("Exit position: " + exitPosition.toString());
        int wall_id = 1;
        int[][] maze = generateMaze.getGenericMaze();
        for(int i = 0; i<maze[0].length; i++){
            for(int j=0; j<maze.length; j++){
                System.out.print(maze[j][i]);
            }
            System.out.println();
        }
        MazeSolveRobot robot = new MazeSolveRobot(maze,wall_id,entryPosition,exitPosition);
        robot.solveMaze();

        List<Point> path = robot.getRobotPath();
        System.out.println();
        for(Point point:path){
            maze[(int) point.getX()][(int) point.getY()] = maze[(int) point.getX()][(int) point.getY()] + 3;
        }
        for(int i = 0; i<maze[0].length; i++){
            for(int j=0; j<maze.length; j++){
                System.out.print(maze[j][i]);
            }
            System.out.println();
        }

    }
}