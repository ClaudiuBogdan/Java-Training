package rectangles;

import javax.swing.*;
import java.awt.*;

public class RectangleAnimation {
     JFrame frame;
     DrawPanel drawPanel;
     Rectangle firsRectangle;
     Rectangle secondRectangle;
     Rectangle intersectionRectangle;

     public static void main(String[] args){
         new RectangleAnimation().startAnimation();
     }

    /**
     * Method that configure and display the frame and create the animation.
     */
    private void startAnimation(){
        firsRectangle = new Rectangle();
        firsRectangle.setLocation(10,10);
        firsRectangle.setSize(80,80);

        secondRectangle = new Rectangle();
        secondRectangle.setLocation(100,20);
        secondRectangle.setSize(100, 100);

        frame = new JFrame("Rectangle animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        drawPanel = new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
        updateFrame();
     }

    /**
     * Class that hold the components to be drawn into the frame.
     */
    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g){
            //Recover Graphics2D
            Graphics2D g2 = (Graphics2D) g;

            //Draw first rectangle.
            g2.setColor(Color.RED);
            g2.fillRect((int)firsRectangle.getLocation().getX(), (int)firsRectangle.getLocation().getY(),
                    (int) firsRectangle.getWidth(), (int) firsRectangle.getHeight());

            //Draw second rectangle.
            g2.setColor(Color.BLUE);
            g2.fillRect((int)secondRectangle.getLocation().getX(), (int)secondRectangle.getLocation().getY(),
                    (int) secondRectangle.getWidth(), (int) secondRectangle.getHeight());

            g2.setColor(Color.MAGENTA);
            g2.fillRect((int)intersectionRectangle.getLocation().getX(), (int)intersectionRectangle.getLocation().getY(),
                    (int) intersectionRectangle.getWidth(), (int) intersectionRectangle.getHeight());

        }
    }

    /**
     * Method that call the method to move rectangles and display the changes.
     */
    private void updateFrame() {
        boolean stop = true;
        int difX = 2;
        int difY = 2;
        int[] firstRectangleDiff = new int[]{difX,difY};
        int[] secondRectangleDiff = new int[]{- difX, - difY};

        while (stop){
            firstRectangleDiff = moveRectangle(firsRectangle, firstRectangleDiff);
            secondRectangleDiff = moveRectangle(secondRectangle, secondRectangleDiff);
            intersectionRectangle = firsRectangle.intersection(secondRectangle);
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();

        }
    }

    /**
     * Method that move the rectangle.
     * @param rectangle The rectangle to be moved.
     * @param differential Amount of space to move toward.
     * @return the new amount of space to move toward.     *
     **/
    private int[] moveRectangle(Rectangle rectangle,int[] differential){
        int dx = differential[0];
        int dy = differential[1];

        if((int)rectangle.getLocation().getX() + (int) rectangle.getWidth() + dx >= frame.getWidth()){
            dx = -dx;
        }
        if((int) rectangle.getLocation().getX() + dx <= 0) {
            dx = -dx;
        }
        if((int)rectangle.getLocation().getY() + (int) rectangle.getHeight() + dy >= frame.getHeight()){
            dy = -dy;
        }
        if((int) rectangle.getLocation().getY() + dy <= 0) {
            dy = -dy;
        }
        rectangle.translate(dx,dy);
        return new int[]{dx,dy};
    }

}
