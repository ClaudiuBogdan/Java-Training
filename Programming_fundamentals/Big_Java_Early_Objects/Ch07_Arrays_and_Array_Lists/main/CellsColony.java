import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that simulates a colony of cells inside a bounded matrix.
 */
public class CellsColony {
    private int[][] matrixOfCells; //Matrix that will contain all the cells(Dead and alive).
    private List<Cell> cellsColony;

    /**
     * Constructor that create and initialize a CellColony object with a specified matrix dimension.
     * @param dimensionOfMatrix The dimension of the matrix that will contains all the cells.
     */
    public CellsColony(int dimensionOfMatrix){
        this.matrixOfCells = new int[dimensionOfMatrix][dimensionOfMatrix];
        this.cellsColony = new ArrayList<>();
        insertRandomCellsIntoMatrix();
    }

    /**
     * Method that insert cells randomly into the matrix.
     */
    private void insertRandomCellsIntoMatrix(){
        Random random = new Random();
        for(int i = 1; i<matrixOfCells.length - 1; i++){
            for(int j = 1; j<matrixOfCells[0].length - 1; j++){
                LiveState[] states = {LiveState.ALIVE, LiveState.DEAD};
                int randomIndexState = random.nextInt(2);
                cellsColony.add(new Cell(j,i,matrixOfCells, states[randomIndexState]));
            }
        }
    }

    /**
     * Method that simulate the next generation or evolution of the colony.
     */
    public void nextGenerationOfColony(){
        for(Cell cell:cellsColony){
            cell.calculateConditionForNextGeneration();
        }
        for(Cell cell:cellsColony){
            cell.updateCellStateIntoMatrix();
        }
    }

    private void nextGenerationOfColony(List<Cell> cellsColony){
        for(Cell cell:cellsColony){
            cell.calculateConditionForNextGeneration();
        }
        for(Cell cell:cellsColony){
            cell.updateCellStateIntoMatrix();
        }
    }

    public List<Cell> getCellsColony() {
        return cellsColony;
    }
}
