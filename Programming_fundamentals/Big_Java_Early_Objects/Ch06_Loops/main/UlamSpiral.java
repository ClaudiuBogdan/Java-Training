import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represent Ulam spiral with a specific dimension.
 */
public class UlamSpiral {
    private Point centerOfSpiral;
    private Point headOfSpiral;
    private int turnsOfSpiral;
    private int separationBetweenSpiralArm;
    private int numberOfCorners;
    private List<Point> spiralCornersList;
    private List<Point> spiralPointsList;
    private final int DIRECTION_RIGHT = 1;
    private final int DIRECTION_UP = 2;
    private final int DIRECTION_LEFT = 3;
    private final int DIRECTION_DOWN = 4;
    private int direction; //Direction toward the head will translate

    /**
     * Constructor that create and instantiate a Ulam spiral with specified number of rotation.
     * @turnsOfSpiral The number of turns the spiral will have. Must be grater that 1.
     */
    public UlamSpiral(int turnsOfSpiral){
        this.turnsOfSpiral = turnsOfSpiral;
        this.numberOfCorners = 0;
        this.separationBetweenSpiralArm = 2;
        this.direction = DIRECTION_RIGHT;
        spiralCornersList = new ArrayList<>();
        spiralPointsList = new ArrayList<>();
        calculatePositionCenter();
        calculateSpiralCorners();
        calculateSpiralPoints();
    }

    /**
     * Method that calculate all the points of the spiral.
     */
    private void calculateSpiralPoints(){
        headOfSpiral.setLocation(centerOfSpiral);
        int diffX = 0; //Normalized distance on x axis between head and next corner.
        int diffY = 0; //Normalized distance on y axis between head and next corner.
        for(int indexOfCorner = 0; indexOfCorner < spiralCornersList.size(); indexOfCorner++){
            Point cornerOfSpiral = spiralCornersList.get(indexOfCorner);
            diffX = cornerOfSpiral.getX() > headOfSpiral.getX() ? 1 : -1;
            diffX = (int) cornerOfSpiral.getX() == (int) headOfSpiral.getX() ? 0 : diffX;
            diffY = cornerOfSpiral.getY() > headOfSpiral.getY() ? 1 : -1;
            diffY = (int) cornerOfSpiral.getY() == (int) headOfSpiral.getY() ? 0 : diffY;
            //System.out.printf("Diff (%d, %d) \n",diffX,diffY );
            do{
                headOfSpiral.translate(diffX,diffY);
                spiralPointsList.add((Point) headOfSpiral.clone());
                diffX = cornerOfSpiral.getX() > headOfSpiral.getX() ? 1 : -1;
                diffX = (int) cornerOfSpiral.getX() == (int) headOfSpiral.getX() ? 0 : diffX;
                diffY = cornerOfSpiral.getY() > headOfSpiral.getY() ? 1 : -1;
                diffY = (int) cornerOfSpiral.getY() == (int) headOfSpiral.getY() ? 0 : diffY;
                //System.out.printf("Diff (%d, %d) \n",diffX,diffY );
            }
            while (diffX != 0 || diffY !=0);
        }
    }

    /**
     * Method that calculate the points of the spiral.
     * This method calculate the corners of the spiral starting from the center and store the points into list.
     */
    private void calculateSpiralCorners(){
        int counterOfTurns = 0;
        int counterOfCorners;
        int numberOfCornersPerTurn = 4;
        //Make the first move out of the loop
        translateToNextPosition();
        //Remain into the spiral while the spiral has less turn that required
        while (counterOfTurns < turnsOfSpiral){
            //Create a turn
            counterOfCorners = 0;
            while (counterOfCorners < numberOfCornersPerTurn){
                translateToNextPosition();
                counterOfCorners++;
            }
            counterOfTurns++;
        }
    }

    /**
     * Method that calculate the center of the spiral.
     * This method translate the left corner of the spiral to 0,0 so the spiral can be drawn into a windows.
     */
    private void calculatePositionCenter(){
        int positionX = separationBetweenSpiralArm * turnsOfSpiral ;
        int positionY = positionX;
        centerOfSpiral = new Point(positionX, positionY);
        //Add the first position to the spiralPointsList
        spiralCornersList.add((Point) centerOfSpiral.clone());
        //Set head to the centerOfSpiral
        headOfSpiral = (Point) centerOfSpiral.clone();
    }

    /**
     * Method that translate the head of the spiral toward the specified direction.
     */
    private void translateToNextPosition(){
        //The distance between consecutive corners increase one unit after two corner
        numberOfCorners++;
        int distanceToTranslate = numberOfCorners;
        switch (direction){
            case DIRECTION_RIGHT:
                headOfSpiral.translate(distanceToTranslate, 0);
                direction =  DIRECTION_UP;
                break;
            case DIRECTION_UP:
                headOfSpiral.translate(0, -distanceToTranslate);
                direction = DIRECTION_LEFT;
                break;
            case DIRECTION_LEFT:
                headOfSpiral.translate(-distanceToTranslate,0);
                direction = DIRECTION_DOWN;
                break;
            case DIRECTION_DOWN:
                headOfSpiral.translate(0, distanceToTranslate);
                direction = DIRECTION_RIGHT;
                break;
            default: break;
        }
        //Store the new position into the spiralList
        spiralCornersList.add((Point) headOfSpiral.clone());
    }

    /**
     * Method that insert the points of the spiral into a matrix.
     * @param spiralPoints List of points from which to insert.
     * @return Matrix with the points of spiral represented by order into list.
     */
    public int[][] insertPointsIntoMatrix(List<Point> spiralPoints){
        int simmetryProportion = 2;
        int lastArmExcedent = separationBetweenSpiralArm;
        int mazeDimension = turnsOfSpiral * simmetryProportion * separationBetweenSpiralArm + lastArmExcedent;
        //System.out.println("Maze dimension: " + mazeDimension);
        int counterPoints = 0;
        int[][] matrixContainer = new int[mazeDimension][mazeDimension];
        for(Point cornerOfSpiral : spiralPoints){
            counterPoints++;
            matrixContainer[(int) cornerOfSpiral.getY()][(int) cornerOfSpiral.getX() ] = counterPoints;
            //System.out.println(cornerOfSpiral.toString());
        }
        return matrixContainer;
    }

    public int getTurnsOfSpiral() {
        return turnsOfSpiral;
    }

    public List<Point> getSpiralCornersList() {
        return spiralCornersList;
    }

    public List<Point> getSpiralPointsList() {
        return spiralPointsList;
    }

    public int getSeparationBetweenSpiralArm() {
        return separationBetweenSpiralArm;
    }
}
