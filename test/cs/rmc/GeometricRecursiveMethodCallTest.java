package cs.rmc;

import cs.Guard;
import cs.loop.GeometricLoop;
import maths.Relation;
import maths.is.GeometricInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of GeometricRecursiveMethodCall.
 */
public class GeometricRecursiveMethodCallTest {

    /**
     * A method to test converting a geometric recursive method call into a
     * loop.
     */
    @Test
    public void testToLoop() {
        GeometricInfiniteSequence gis = new GeometricInfiniteSequence(1, 2);
        int b = 4;
        assertEquals(new GeometricLoop(gis, new Guard(Relation.NET, b)), (new GeometricRecursiveMethodCall(gis, new Guard(Relation.ET, b))).toLoop());
    }
}
