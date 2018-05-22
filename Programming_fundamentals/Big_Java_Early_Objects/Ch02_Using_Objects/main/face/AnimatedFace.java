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
    private Face face;

    public static void main(String[] args){
        new AnimatedFace().startAnimation();
    }

    /**
     * Constructor that initialize face with default face size.
     */
    public AnimatedFace(){
        face = new Face(300);
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
        drawFrame();
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

            //Draw face skin
            Ellipse2D faceBorder = face.getFaceBorder();
            g2.fill(faceBorder);

            //Draw mouth and tongue.
            g2.setColor(Color.WHITE);
            Arc2D arc2D = face.getMouthBorder();
            g2.fill(arc2D);
            g2.setColor(Color.RED);
            g2.fill(face.getTongueBorer());

            //Draw eyes border end iris.
            g2.setColor(Color.WHITE);
            g2.fill(face.getRightEyeBorder());
            g2.fill(face.getLeftEyeBorder());
            g2.setColor(Color.BLUE);
            g2.fill(face.getLeftEyeIris());
            g2.fill(face.getRightEyeIris());

        }
    }

    /**
     * Method that change the geometry and update the frame.
     */
    private void drawFrame(){
        boolean closingEye = true;
        while (true){
            if (closingEye){
                closingEye = face.closeEye(face.getRightEyeBorder());
                face.closeEye(face.getRightEyeIris());
                if(!closingEye){
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException ex){

                    }
                }
            }
            else{
                closingEye = !face.openEye(face.getRightEyeBorder());
                face.openEye(face.getRightEyeIris());
                if(closingEye){
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException ex){

                    }
                }
            }
            updateFrame();

        }
    }

    private void updateFrame(){
        frame.repaint();
        try {
            Thread.sleep(3);
        }
        catch (InterruptedException ex){

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
        private Arc2D tongueBorer;
        private Ellipse2D rightEyeBorder;
        private Ellipse2D leftEyeBorder;
        private Ellipse2D rightEyeIris;
        private Ellipse2D leftEyeIris;
        private double eyeHigh;
        private double eyeWidth;
        double eyeSeparation;
        double eyeElevation;

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
            this.eyeHigh = dimension/5.0;
            this.eyeWidth = dimension/3.5;
            this.eyeElevation = dimension/6.0;
            this.eyeSeparation = dimension/5.0;
            this.faceCenter = new Point((int)(dimension/2.0 + upperRightCorner.getX()),
                    (int)(goldRelation * dimension/2.0 + upperRightCorner.getY()));
            this.faceBorder = new Ellipse2D.Double(upperRightCorner.getX(), upperRightCorner.getY(), dimension, dimension * goldRelation);
            setMouth();
            setRightEyeBorderEye();
            setLeftEyeBorder();
        }

        /**
         * Method that instantiate the mouth and tongue.
         */
        private void setMouth(){
            Point centerMouth = new Point((int) faceCenter.getX(), (int)(faceCenter.getY() + dimension / 2.0));
            mouthBorder= new Arc2D.Double(centerMouth.getX() - dimension/3, centerMouth.getY()-dimension/2,
                    dimension/1.5,
                    dimension/2,
                    0, -180,
                    Arc2D.CHORD);
            int scaleFactor = 4;
            tongueBorer = new Arc2D.Double(centerMouth.getX() - dimension/scaleFactor, mouthBorder.getY() - dimension/4,
                    2*dimension/(scaleFactor),
                    dimension,
                    0, -180,
                    Arc2D.CHORD);
        }

        /**
         * Method that instantiate the rigt eye border and iris.
         */
        private void setRightEyeBorderEye(){
            Point eyeCenter = new Point((int)( faceCenter.getX() - eyeSeparation), (int)(faceCenter.getY() -eyeElevation));
            rightEyeBorder = new Ellipse2D.Double(eyeCenter.getX() - eyeWidth/2, eyeCenter.getY(), eyeWidth, eyeHigh);
            rightEyeIris = new Ellipse2D.Double(eyeCenter.getX() - eyeHigh/2.0,eyeCenter.getY(),eyeHigh,eyeHigh);
        }

        private void setLeftEyeBorder(){
            Point eyeCenter = new Point((int)( faceCenter.getX() + eyeSeparation), (int)(faceCenter.getY() -eyeElevation));
            leftEyeBorder = new Ellipse2D.Double(eyeCenter.getX() - eyeWidth/2, eyeCenter.getY(), eyeWidth, eyeHigh);
            leftEyeIris = new Ellipse2D.Double(eyeCenter.getX() - eyeHigh/2.0,eyeCenter.getY(),eyeHigh,eyeHigh);
        }

        /**
         * Method that close the eye by stretching the high.
         * @param eye The eye that will be closed.
         * @return True if the eye is closing. False if the eye is closed.
         */
        public boolean closeEye(Ellipse2D eye){
            if(eye.getHeight()>2){
                double decreasedHigh = eye.getHeight();
                decreasedHigh--;
                eye.setFrame(eye.getX(),eye.getY() + 0.5 ,eye.getWidth(),decreasedHigh);
                return true;
            }
            return false;
        }

        /**
         * Method that open the eye by expanding the high.
         * @param eye The eye that will be open.
         * @return True if the eye is opening. False if the eye is opend.
         */
        public boolean openEye(Ellipse2D eye){
            if(eye.getHeight()<eyeHigh){
                double increasedHigh = eye.getHeight();
                increasedHigh++;
                eye.setFrame(eye.getX(),eye.getY() - 0.5,eye.getWidth(),increasedHigh);
                return true;
            }
            return false;
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

        public Ellipse2D getRightEyeIris() {
            return rightEyeIris;
        }

        public Ellipse2D getLeftEyeIris() {
            return leftEyeIris;
        }

        public Arc2D getTongueBorer() {
            return tongueBorer;
        }
    }
}
