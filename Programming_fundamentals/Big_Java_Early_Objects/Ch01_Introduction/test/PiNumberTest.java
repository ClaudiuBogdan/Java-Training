import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PiNumberTest{
    PiNumber piNumber;

    @org.junit.Before
    public void setUp() {
        piNumber = new PiNumber();
    }

    @org.junit.Test
    public void setPiNumber() {
        int precision = 6; //nr of decimal precision
        piNumber.setPi(precision);
        //System.out.println(Math.abs(Math.PI - piNumber.getPi()));
        assertTrue(Math.abs(Math.PI - piNumber.getPi())< Math.pow(10,1-precision));
    }
}
