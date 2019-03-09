package warming_up.repeated_string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testBeginingString() {
        assertEquals(3, Solution.calculateCharOccurence('a', "aaabb"));
        
    }

    @Test
    public void testEndString() {
        assertEquals(3, Solution.calculateCharOccurence('a', "bbaaa"));
        
    }

    @Test
    public void testMiddleString() {
        assertEquals(3, Solution.calculateCharOccurence('a', "baaab"));
        
    }

    @Test
    public void testContHello() {
        assertEquals(3, Solution.calculateCharOccurence('l', "Hellow World"));
    }

    @Test
    public void testOnlySubstring() {
        assertEquals(1, Solution.calculateTotalOccurrence("abc", 3));
    }

    @Test
    public void testOnlySubstringOneLetter() {
        assertEquals(1, Solution.calculateTotalOccurrence("a", 1));
    }

    @Test
    public void testSubstringRepitedEntirely() {
        assertEquals(2, Solution.calculateTotalOccurrence("abc", 6));
    }

    @Test
    public void testSubstringRepitedEntirelyTwoOcc() {
        assertEquals(4, Solution.calculateTotalOccurrence("aba", 6));
    }

    @Test
    public void testSubstringRepitedEntirelyOneChar() {
        assertEquals(2, Solution.calculateTotalOccurrence("a", 2));
    }

    @Test
    public void testSubstringRepitedNotEntirely() {
        assertEquals(2, Solution.calculateTotalOccurrence("abc", 5));
    }

    @Test
    public void testSubstringRepitedNotEntirelyTwoLetter() {
        assertEquals(3, Solution.calculateTotalOccurrence("aba", 5));
    }
}