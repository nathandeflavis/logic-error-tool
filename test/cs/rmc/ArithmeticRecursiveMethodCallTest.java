package cs.rmc;

import cs.Guard;
import maths.Relation;
import static org.junit.Assert.*;
import org.junit.Test;
import maths.is.ArithmeticInfiniteSequence;
import cs.loop.ArithmeticLoop;

/**
 * A class to test methods of ArithmeticRecursiveMethodCall.
 */
public class ArithmeticRecursiveMethodCallTest {

    /**
     * A method to test converting an arithmetic recursive method call into a
     * loop.
     */
    @Test
    public void testToLoop() {
        ArithmeticInfiniteSequence ais = new ArithmeticInfiniteSequence(3, -1);
        int b = 0;
        assertEquals(new ArithmeticLoop(ais, new Guard(Relation.NET, b)), (new ArithmeticRecursiveMethodCall(ais, new Guard(Relation.ET, b))).toLoop());
    }
}
