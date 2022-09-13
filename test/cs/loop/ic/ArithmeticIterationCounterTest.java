package cs.loop.ic;

import cs.Guard;
import cs.loop.ArithmeticLoop;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of ArithmeticIterationCounter.
 */
public class ArithmeticIterationCounterTest {

    /**
     * A method to test counting iterations in finite arithmetic loops.
     */
    @Test
    public void testGetCount() {
        for (ArithmeticLoop al : new ArithmeticLoop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.LT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.LTOET, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.GT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.GTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.ET, 1))
        }) {
            assertEquals(0, (new ArithmeticIterationCounter(al)).getCount());
        }

        assertEquals(1, (new ArithmeticIterationCounter(new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.NET, 1)))).getCount());
    }
}
