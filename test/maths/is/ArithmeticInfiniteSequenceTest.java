package maths.is;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of ArithmeticInfiniteSequence.
 */
public class ArithmeticInfiniteSequenceTest {

    /**
     * A method to test checking whether an arithmetic infinite sequence
     * contains a term, with cases that do.
     */
    @Test
    public void testContains_AISsWithTerm() {
        assertFalse(new ArithmeticInfiniteSequence(0, 0).contains(1));
        assertFalse(new ArithmeticInfiniteSequence(1, 1).contains(0));
    }

    /**
     * A method to test checking whether an arithmetic infinite sequence
     * contains a term, with cases that do not.
     */
    @Test
    public void testContains_AISsWithoutTerm() {
        for (InfiniteSequence is : new InfiniteSequence[]{
            new ArithmeticInfiniteSequence(1, 1),
            new ArithmeticInfiniteSequence(0, 1)
        }) {
            assertTrue(is.contains(1));
        }
    }
}
