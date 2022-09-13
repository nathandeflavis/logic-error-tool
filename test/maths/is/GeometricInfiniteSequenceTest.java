package maths.is;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of GeometricInfiniteSequence.
 */
public class GeometricInfiniteSequenceTest {

    /**
     * A method to test checking whether a geometric infinite sequence contains
     * a term, with cases that do.
     */
    @Test
    public void testContains_AISsWithTerm() {
        for (InfiniteSequence is : new InfiniteSequence[]{
            new GeometricInfiniteSequence(1, 1),
            new GeometricInfiniteSequence(-1, -1)
        }) {
            assertTrue(is.contains(1));
        }

        assertTrue(new GeometricInfiniteSequence(1, 0).contains(0));
        assertTrue(new GeometricInfiniteSequence(1, -2).contains(-2));
    }

    /**
     * A method to test checking whether a geometric infinite sequence contains
     * a term, with cases that do not.
     */
    @Test
    public void testContains_AISsWithoutTerm() {
        for (InfiniteSequence is : new InfiniteSequence[]{
            new GeometricInfiniteSequence(-1, 1),
            new GeometricInfiniteSequence(0, 1),
            new GeometricInfiniteSequence(0, 0)
        }) {
            assertFalse(is.contains(1));
        }

        assertFalse(new GeometricInfiniteSequence(1, -2).contains(2));
        assertFalse(new GeometricInfiniteSequence(2, 2).contains(3));
    }
}
