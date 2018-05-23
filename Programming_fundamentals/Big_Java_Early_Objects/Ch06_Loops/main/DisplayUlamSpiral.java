import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class will display Ulam spiral in an artistic way.
 */

public class DisplayUlamSpiral {
    private UlamSpiral spiral;
    private JFrame frame;
    private int pointDimension;
    private int turnsOfSpiral;

    public static void main(String[] args){
        new DisplayUlamSpiral().displayIntoWindows();
    }

    private void displayIntoWindows() {
         turnsOfSpiral = 60;
        pointDimension = 4; //Dimension in pixels.
        spiral = new UlamSpiral(turnsOfSpiral);
        frame = new JFrame("Ulam spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int sizeOfOneSpiral = 4;
        int windowsDimensionX = (turnsOfSpiral + 1) * sizeOfOneSpiral * pointDimension;
        int windowsDimensionY = (int)((turnsOfSpiral + 1.5) * sizeOfOneSpiral * pointDimension);
        frame.setSize(windowsDimensionX,windowsDimensionY);
        //DrawPanel drawPanel = new DrawPanel();
        //DrawPanelPrimes drawPanel = new DrawPanelPrimes();
        DrawPanelPrimesAndComposite drawPanel = new DrawPanelPrimesAndComposite();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
    }

    /**
     * Draw all the points of the spiral
     */
    private class DrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            int initialPoint = 1;
            for(Point pointOfSpiral : spiral.getSpiralPointsList()){
                g2.setColor(Color.BLUE);
                g2.fillRect((int) pointOfSpiral.getX()*pointDimension, (int) pointOfSpiral.getY()*pointDimension,pointDimension,pointDimension );

            }
        }
    }

    private class DrawPanelPrimes extends JPanel{
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            int pointNumber = 1;
            g2.setColor(Color.BLUE);
            for(Point pointOfSpiral : spiral.getSpiralPointsList()){
                if(isPrime(pointNumber)){
                    g2.fillRect((int) pointOfSpiral.getX()*pointDimension, (int) pointOfSpiral.getY()*pointDimension,
                            pointDimension,pointDimension );
                }
                pointNumber++;
            }
        }
    }

    private class DrawPanelPrimesAndComposite extends JPanel{
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            int pointNumber = 1;
            int countTurns = 0;
            int countPointsOfArm = 0;
            int pointsOfPreviousArm = 0;
            int countArms = 0;
            int armsPerTurn = 4;
            final double MAX_CIRCLE_RADIUS = pointDimension * 64 * 2 ;
            Ellipse2D geometricPoint = new Ellipse2D.Double();
            for(Point pointOfSpiral : spiral.getSpiralPointsList()){
                //Count the current turn into the spiral.
                if(countArms == armsPerTurn){
                    countTurns++;
                    countArms = 0;
                }
                if(countPointsOfArm == pointsOfPreviousArm + 1){
                    pointsOfPreviousArm++;
                    countArms++;
                    countPointsOfArm = 0;
                }
                pointNumber++;
                countPointsOfArm++;

                //Display the points proportional to the spiral current turn
                int proportionalDimension = (int) Math.round(Math.log(Math.E + MAX_CIRCLE_RADIUS/2 * (1.0 - ((turnsOfSpiral - countTurns)/(double)turnsOfSpiral))));
                //System.out.println("Proportional dimension. " + proportionalDimension);
                if(!isPrime(pointNumber)){
                    g2.setColor(Color.RED);
                    geometricPoint.setFrame((int) pointOfSpiral.getX()*pointDimension, (int) pointOfSpiral.getY()*pointDimension,
                            proportionalDimension/2, proportionalDimension/2 );
                }
                g2.fill(geometricPoint);

            }
            pointNumber = 1;
            countTurns = 0;
            countPointsOfArm = 0;
            pointsOfPreviousArm = 0;
            countArms = 0;
            armsPerTurn = 4;
            for(Point pointOfSpiral : spiral.getSpiralPointsList()){
                //Count the current turn into the spiral.
                if(countArms == armsPerTurn){
                    countTurns++;
                    countArms = 0;
                }
                if(countPointsOfArm == pointsOfPreviousArm + 1){
                    pointsOfPreviousArm++;
                    countArms++;
                    countPointsOfArm = 0;
                }
                pointNumber++;
                countPointsOfArm++;

                //Display the points proportional to the spiral current turn
                int proportionalDimension = (int) Math.round(0.4 * pointDimension *Math.log(Math.E + MAX_CIRCLE_RADIUS * (1.0 - ((turnsOfSpiral - countTurns)/(double)turnsOfSpiral))));
                if(isPrime(pointNumber)){
                    g2.setColor(Color.BLUE);
                    geometricPoint.setFrame((int) pointOfSpiral.getX()*pointDimension, (int) pointOfSpiral.getY()*pointDimension,
                            proportionalDimension,proportionalDimension );
                }
                g2.fill(geometricPoint);

            }
        }
    }

    /**
     * Method that determines if a number is prime.
     * Source: https://codereview.stackexchange.com/questions/24704/efficiently-determining-if-a-number-is-prime
     * @param num Number to determine if is prime.
     * @return True if the number is prime.
     */
    private boolean isPrime(int num){
        if ( num > 2 && num%2 == 0 ) {
            return false;
        }
        int top = (int)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
