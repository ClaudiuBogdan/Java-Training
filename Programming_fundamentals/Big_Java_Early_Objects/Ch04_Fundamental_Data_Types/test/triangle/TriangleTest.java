package triangle;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TriangleTest {
    private Triangle triangle;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    @Before
    public void prepareClass(){
        pointA = new Point(0,0);
        pointB = new Point(0,1);
        pointC = new Point(1,0);
        triangle = new Triangle(pointA, pointB, pointC);
    }

    @Test
    public void toStringTriangle() {
        System.out.println(triangle.toString());
        assertEquals(pointA, triangle.getVertexA());
        assertEquals(pointB, triangle.getVertexB());
        assertEquals(pointC, triangle.getVertexC());
        assertEquals(1.0, triangle.getLengthSideB(), 0.001);
        assertEquals((float) Math.PI/2, (float) triangle.getAngleA(), 0.001);
    }
}