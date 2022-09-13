package cs.loop;

import cs.Guard;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of ArithmeticLoop.
 */
public class ArithmeticLoopTest {

    /**
     * A method test termination analysis of finite loops.
     */
    @Test
    public void testTerminates_finiteLoops() {
        for (Loop loop : new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.LT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.LTOET, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.GT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.GTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.NET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.ET, 1))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops.
     */
    @Test
    public void testTerminates_infiniteLoops() {
        for (Loop loop : new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.LT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GT, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 2), new Guard(Relation.NET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.ET, 1))
        }) {
            assertFalse(loop.terminates());
        }
    }
}
