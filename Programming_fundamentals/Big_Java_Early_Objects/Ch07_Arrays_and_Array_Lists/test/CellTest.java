import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CellTest {
    private Cell cell;
    private int[][] matrixOfCells;
    @Before
    public void setUp() throws Exception {
        matrixOfCells = new int[8][8];
        cell = new Cell(3,3, matrixOfCells, LiveState.ALIVE);
    }

    @Test
    public void getNeighbourCells() {
        //add one cell upward.
        Cell neighbourCell = new Cell((int)cell.getX(), (int)cell.getY() + 1,matrixOfCells,LiveState.ALIVE);
        //Check if the cell detects its neighbour cell
        int numberOfNeighbourExpected = 1;
        cell.calculateConditionForNextGeneration();
        cell.getNeighbourCells();
        Assert.assertEquals(numberOfNeighbourExpected, cell.getNeighbourCells());
    }

    @Test
    public void testCellColony(){
        List<Cell> cellsColony = new ArrayList<>();
        matrixOfCells = new int[8][8];
        for(int i = 1; i<matrixOfCells.length - 1; i++){
            for(int j = 1; j<matrixOfCells[0].length - 1; j++){
                cellsColony.add(new Cell(j,i,matrixOfCells, LiveState.DEAD));
            }
        }
        int numOfAliveCells = 6;
        for(int i = 0; i<numOfAliveCells; i++){
            cellsColony.get(i).changeStateTo(LiveState.ALIVE);
        }
        displayMatrix();
        nextGenerationOfColony(cellsColony);
        displayMatrix();
        nextGenerationOfColony(cellsColony);
        displayMatrix();
        nextGenerationOfColony(cellsColony);
        displayMatrix();
        nextGenerationOfColony(cellsColony);
        displayMatrix();
    }

    private void nextGenerationOfColony(List<Cell> cellsColony){
        for(Cell cell:cellsColony){
            cell.calculateConditionForNextGeneration();
        }
        for(Cell cell:cellsColony){
            cell.updateCellStateIntoMatrix();
        }
    }

    private void displayMatrix(){
        for(int i = 0; i<matrixOfCells.length; i++){
            for(int j = 0; j<matrixOfCells[0].length; j++){
                System.out.printf("%2d",matrixOfCells[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}