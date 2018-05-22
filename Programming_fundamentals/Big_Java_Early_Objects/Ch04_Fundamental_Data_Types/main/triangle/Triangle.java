package triangle;

import sun.security.provider.certpath.Vertex;

import java.awt.*;

/**
 * A R2 geometric triangle defined by its three vertices.
 */
public class Triangle {
    //Triangle vertices
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    //Triangle length sides
    private double lengthSideA;
    private double lengthSideB;
    private double lengthSideC;
    //Triangle angles in radians;
    private double angleA;
    private double angleB;
    private double angleC;
    //Triangle perimeter
    private double perimeter;
    //Triangle area
    private double area;



    /**
     * Construct and initialize a triangle with input points as vertices.
     * @param pointA First vertex point.
     * @param pointB Second vertex point.
     * @param pointC Third vertex point.
     */
    public Triangle(Point pointA, Point pointB, Point pointC){
        this.vertexA = pointA;
        this.vertexB = pointB;
        this.vertexC = pointC;
        calculateLengthSides();
        calculateAngles();
        calculatePerimeter();
        calculateArea();
    }

    private void calculateLengthSides() {
        lengthSideA = vertexB.distance(vertexC);
        lengthSideB = vertexA.distance(vertexC);
        lengthSideC = vertexA.distance(vertexB);
    }

    private void calculateAngles() {
        /*
        Law of Cosines:
            cos(alpha) = (a^2 + b^2 - c^2)/(2*a*b) --> alpha = acos((a^2 + b^2 - c^2)/(2*a*b))
         */
        angleA = Math.acos((lengthSideB*lengthSideB + lengthSideC*lengthSideC - lengthSideA*lengthSideA)/
                (2 * lengthSideB * lengthSideC ));
        angleB = Math.acos((lengthSideA*lengthSideA + lengthSideC*lengthSideC - lengthSideB*lengthSideB)/
                (2 * lengthSideA * lengthSideC ));
        angleC = Math.acos((lengthSideA*lengthSideA + lengthSideB*lengthSideB - lengthSideC*lengthSideC)/
                (2 * lengthSideA * lengthSideB ));
    }

    private void calculatePerimeter() {
        perimeter = lengthSideA + lengthSideB + lengthSideC;
    }

    private void calculateArea(){
        area = (lengthSideA * lengthSideB * Math.sin(angleC))/2;
    }

    public String toString(){
        return "A = " + vertexA.toString() + "\n" +
                "B = " + vertexB.toString() + "\n" +
                "C = " + vertexC.toString() + "\n" +
                "Angle A = pi * " + angleA/Math.PI + "\n" +
                "Angle B = pi * " + angleB/Math.PI + "\n" +
                "Angle C = pi * " + angleC/Math.PI + "\n" +
                "Length side a= " + lengthSideA + "\n" +
                "Length side b= " + lengthSideB + "\n" +
                "Length side c= " + lengthSideC + "\n" +
                "Perimeter = " + perimeter + "\n" +
                "Area = " + area ;
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public double getLengthSideA() {
        return lengthSideA;
    }

    public double getLengthSideB() {
        return lengthSideB;
    }

    public double getLengthSideC() {
        return lengthSideC;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
