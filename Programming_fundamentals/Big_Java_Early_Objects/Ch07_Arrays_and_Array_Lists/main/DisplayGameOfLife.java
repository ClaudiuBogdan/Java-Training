import javax.swing.*;
import java.awt.*;

public class DisplayGameOfLife {
    private JFrame frame;
    private CellsColony cellColony;
    private int cellDimension;

    public static void main(String[] args){
        new DisplayGameOfLife().startSimulation();
    }

    private void startSimulation(){
        frame = new JFrame("GameOfLife");
        cellDimension = 5;
        int dimensionOfMatrix = 164;
        cellColony = new CellsColony(dimensionOfMatrix);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawComponent drawComponent = new DrawComponent();
        frame.getContentPane().add(drawComponent);
        frame.setSize(cellDimension*dimensionOfMatrix - cellDimension, cellDimension*dimensionOfMatrix);
        frame.setVisible(true);
        while (true){
            cellColony.nextGenerationOfColony();
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex){}
            frame.repaint();
        }

    }

    private class DrawComponent extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int separationBetweenCells = 1;
            Graphics2D g2 = (Graphics2D) g;
            for (Cell cell : cellColony.getCellsColony()){
                if(cell.getCell_state() == LiveState.ALIVE){
                    g2.setColor(Color.BLUE);
                    g2.fillRect((cell.x - 1)* cellDimension,(cell.y - 1) * cellDimension,
                            cellDimension - separationBetweenCells, cellDimension - separationBetweenCells);
                }
                else {
                    g2.setColor(Color.LIGHT_GRAY);
                    g2.fillRect((cell.x - 1)* cellDimension,(cell.y - 1)  * cellDimension,
                            cellDimension - separationBetweenCells, cellDimension - separationBetweenCells);
                }
            }

        }
    }
}
