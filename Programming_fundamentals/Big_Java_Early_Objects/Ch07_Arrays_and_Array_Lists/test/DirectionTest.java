import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void testNorthDirection(){
        Direction direction_North = Direction.DIRECTION_NORTH;
        int diff_X_expected = 0;
        int diff_Y_expected = -1;
        assertEquals(diff_X_expected, direction_North.getDiff_X());
        assertEquals(diff_Y_expected, direction_North.getDiff_Y());
    }

    @Test
    public void testAllDirections(){
        for (Direction direction: Direction.values()){
            System.out.println(direction.toString());
        }
    }
}