package face;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

/**
 * Class that shows an animated face ;)
 */
public class AnimatedFace {

    JFrame frame;
    DrawPanel drawPanel;

    public static void main(String[] args){
        new AnimatedFace().startAnimation();
    }

    /**
     * Method that configure and display the frame and create the animation.
     */
    private void startAnimation(){
        frame = new JFrame("Rectangle animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        drawPanel = new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
        //updateFrame();
    }

    /**
     * Class that hold the components to be drawn into the frame.
     */
    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            //Recover Graphics2D
            Graphics2D g2 = (Graphics2D) g;
            int x = 0;
            int y = 0;
            int rectwidth = 300;
            int rectheight = rectwidth/2;
            g2.setColor(Color.ORANGE);
            Face face = new Face(300);
            Ellipse2D faceBorder = face.getFaceBorder();
            g2.fill(faceBorder);
            g2.setColor(Color.WHITE);
            Arc2D arc2D = face.getMouthBorder();
            g2.fill(arc2D);

            g2.setColor(Color.BLUE);
            g2.fill(face.getRightEyeBorder());
            g2.fill(face.getLeftEyeBorder());
        }
    }

    /**
     * Class with the emoji geometric components.
     */
    private class Face{

        private Point faceCenter;
        private int dimension;
        private Ellipse2D faceBorder;
        private Arc2D mouthBorder;
        private Ellipse2D rightEyeBorder;
        private Ellipse2D leftEyeBorder;

        /**
         * Constructor that generate a face with the specified dimension and position 0,0.
         * @param dimension
         */
        public Face(int dimension){
            this(new Point(0,0), dimension);
        }

        /**
         * Constructor that generate a face with specified position and dimension.
         * X position must be grater than half dimension and Y position must be grater than aprox 10:16 half dimension.
         * @param upperRightCorner
         * @param dimension
         */
        public Face(Point upperRightCorner, int dimension){
            double goldRelation = 1.2;
            this.dimension = dimension;
            this.faceCenter = new Point((int)(dimension/2.0 + upperRightCorner.getX()),
                    (int)(goldRelation * dimension/2.0 + upperRightCorner.getY()));
            this.faceBorder = new Ellipse2D.Double(upperRightCorner.getX(), upperRightCorner.getY(), dimension, dimension * goldRelation);
            setMouth();
            setRightEyeBorderEye();
            setLeftEyeBorder();
        }

        private void setMouth(){
            Point centerMouth = new Point((int) faceCenter.getX(), (int)(faceCenter.getY() + dimension / 2.0));
            mouthBorder= new Arc2D.Double(centerMouth.getX() - dimension/3, centerMouth.getY()-dimension/2,
                    dimension/1.5,
                    dimension/2,
                    0, -180,
                    Arc2D.CHORD);

        }

        private void setRightEyeBorderEye(){
            double eyeSeparation = dimension/4.5;
            double eyeElevation = dimension / 4;
            Point eyeCenter = new Point((int)( faceCenter.getX() - eyeSeparation), (int)(faceCenter.getY() -eyeElevation));
            double eyeHigh = dimension/4.0;
            double eyeWidth = dimension/4.0;
            rightEyeBorder = new Ellipse2D.Double(eyeCenter.getX() - eyeWidth/2, eyeCenter.getY(), eyeWidth, eyeHigh);
        }

        private void setLeftEyeBorder(){
            double eyeSeparation = dimension/4.5;
            double eyeElevation = dimension / 4;
            Point eyeCenter = new Point((int)( faceCenter.getX() + eyeSeparation), (int)(faceCenter.getY() -eyeElevation));
            double eyeHigh = dimension/4.0;
            double eyeWidth = dimension/4.0;
            leftEyeBorder = new Ellipse2D.Double(eyeCenter.getX() - eyeWidth/2, eyeCenter.getY(), eyeWidth, eyeHigh);
        }

        public Ellipse2D getFaceBorder(){
            return faceBorder;
        }

        public Arc2D getMouthBorder(){
            return mouthBorder;
        }

        public Ellipse2D getRightEyeBorder() {
            return rightEyeBorder;
        }

        public Ellipse2D getLeftEyeBorder() {
            return leftEyeBorder;
        }
    }
}
