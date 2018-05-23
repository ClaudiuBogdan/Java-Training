import org.junit.Test;

import java.awt.*;

public class UlamSpiralTest {
    @Test
    public void testUlamSpiralOneTurn(){
        int numerbOfTurns = 1;
        UlamSpiral ulamSpiral = new UlamSpiral(numerbOfTurns);
        int[][] matrixPoints = ulamSpiral.insertPointsIntoMatrix(ulamSpiral.getSpiralPointsList());
        int[][] matrixCorners = ulamSpiral.insertPointsIntoMatrix(ulamSpiral.getSpiralCornersList());
        //displaySpiralIntoMatrix(matrixCorners);
        //displaySpiralIntoMatrix(matrixPoints);
    }

    @Test
    public void testUlamSpiralThreeTurns(){
        int numerbOfTurns = 3;
        UlamSpiral ulamSpiral = new UlamSpiral(numerbOfTurns);
        int[][] matrix = ulamSpiral.insertPointsIntoMatrix(ulamSpiral.getSpiralCornersList());
        //displaySpiralIntoMatrix(matrix);
    }

    @Test
    public void testUlamSpiralFourTurns(){
        int numerbOfTurns = 4;
        UlamSpiral ulamSpiral = new UlamSpiral(numerbOfTurns);
        int[][] matrix = ulamSpiral.insertPointsIntoMatrix(ulamSpiral.getSpiralCornersList());
        //displaySpiralIntoMatrix(matrix);
    }

    @Test
    public void testUlamSpiralXTurns(){
        int numerbOfTurns = 12;
        UlamSpiral ulamSpiral = new UlamSpiral(numerbOfTurns);
        int[][] matrix = ulamSpiral.insertPointsIntoMatrix(ulamSpiral.getSpiralPointsList());
        displaySpiralIntoMatrix(matrix);
    }

    private void displaySpiralIntoMatrix(int[][] matrixContainer){
        for(int i=0; i<matrixContainer.length; i++){
            for (int j=0; j <matrixContainer[0].length; j++){
                System.out.printf("%4d",matrixContainer[i][j]);
            }
            System.out.println();
        }
        System.out.println("End.");
    }
}