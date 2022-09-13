package cs.loop.ic;

import cs.Guard;
import cs.loop.GeometricLoop;
import maths.Relation;
import maths.is.GeometricInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of GeometricIterationCounter.
 */
public class GeometricIterationCounterTest {

    /**
     * A method to test counting iterations in finite geometric loops.
     */
    @Test
    public void testGetCount() {
        for (GeometricLoop gl : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.LTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.GT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.ET, 1))
        }) {
            assertEquals(0, (new GeometricIterationCounter(gl)).getCount());
        }

        assertEquals(1, new GeometricIterationCounter(new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 2))).getCount());
    }
}
