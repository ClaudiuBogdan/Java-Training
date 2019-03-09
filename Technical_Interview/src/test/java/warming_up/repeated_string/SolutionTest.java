package warming_up.repeated_string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testBeginingString() {
        Solution tester = new Solution();
        assertEquals(3, Solution.calculateCharOccurence('a', "aaabb"));
        
    }

    @Test
    public void testEndString() {
        Solution tester = new Solution();
        assertEquals(3, Solution.calculateCharOccurence('a', "bbaaa"));
        
    }

    @Test
    public void testMiddleString() {
        Solution tester = new Solution();
        assertEquals(3, Solution.calculateCharOccurence('a', "baaab"));
        
    }

    @Test
    public void testContHello() {
        Solution tester = new Solution();
        assertEquals(3, Solution.calculateCharOccurence('l', "Hellow World"));
    }
}