import java.awt.*;
/*
@author Claudiu Constantin Bogdan <bogdan.claudiu93@gmail.com>
 */

/**Enum that holds the possible states of a cell.
 */
enum LiveState{ALIVE(1), DEAD(0);
    private int state_id;
    LiveState(int state_id){
        this.state_id = state_id;
    }
    public int getState_id(){
        return state_id;
    }
}

/**
 * Class that model a cell in the game of life.
 */
public class Cell extends Point {
    private int neighbourCells;
    private final int numberOfNeighbourToBorn = 3;
    private int[][] matrixOfCells; //reference to the matrix that contains all the cells.
    private LiveState cell_state;

    /**
     * Constructor that create and initialize a cell to a specified position.
     * @param posX Coordinate of the cell in X axis.
     * @param posY Coordinate of the cell in Y axis.
     * @param matrix Reference to the matrix that contains all the cells.
     */
    public Cell(int posX, int posY, int[][] matrix, LiveState state){
        super(posX,posY);
        this.matrixOfCells = matrix;
        this.cell_state = state;
        matrix[posY][posX] = cell_state.getState_id();
    }

    /**
     * Method that compute the state of the cell for the next generation.
     */
    public void calculateConditionForNextGeneration(){
        this.countNeighbourCells();
        checkNewCellState();
    }


    /**
     * Method that count the number of neighbour of the cell.
     */
    private void countNeighbourCells(){
        int countCells = 0;
        for(Direction directionToCheck : Direction.values()){
            countCells += matrixOfCells[(int) this.getY() + directionToCheck.getDiff_Y()]
                    [(int) this.getX() + directionToCheck.getDiff_X()] == LiveState.ALIVE.getState_id() ? 1 : 0;
        }
        neighbourCells = countCells;
    }

    /**
     * Method that check if the cell should die, born or maintain the state.
     * Method that decides if it must kill the cell if there are too much or too few neighbour cells.
     * @return True if there are too much or too few cells around.
     */
    private void checkNewCellState(){
        if(neighbourCells <= 1 || neighbourCells >= 4){
            cell_state = LiveState.DEAD;
        }
        if(neighbourCells == numberOfNeighbourToBorn){
            cell_state = LiveState.ALIVE;
        }
    }

    /**
     * Method that changes the state of a cell manually.
     * @param state State of the cell to be introduced.
     */
    public void changeStateTo(LiveState state){
        cell_state = state;
        updateCellStateIntoMatrix();
    }

    /**
     * Method that register the state of the cell into the colony matrix.
     */
    public void updateCellStateIntoMatrix(){
        matrixOfCells[(int)getY()][(int)getX()] = cell_state.getState_id();
    }

    public int getNeighbourCells() {
        return neighbourCells;

    }
}
