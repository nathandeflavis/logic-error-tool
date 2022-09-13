package cs;

import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of ArrayPositionRange.
 */
public class ArrayPositionRangeTest {

    /**
     * A method to test generating loops to traverse the 0-based array index
     * range corresponding to the array position range, in the case that the
     * start position precedes the end position.
     */
    @Test
    public void testGetTraversingLoops_startBeforeEnd() {
        List<Loop> loops = new ArrayList<>();
        loops.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.LT, 10)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.LTOET, 9))
        }));
        assertEquals(loops, new ArrayPositionRange(1, 10).getTraversingLoops());
    }

    /**
     * A method to test generating loops to traverse the 0-based array index
     * range corresponding to the array position range, in the case that the
     * start position succeeds the end position.
     */
    @Test
    public void testGetTraversingLoops_startAfterEnd() {
        List<Loop> loops = new ArrayList<>();
        loops.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(9, -1), new Guard(Relation.GT, -1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(9, -1), new Guard(Relation.GTOET, 0))
        }));
        assertEquals(loops, new ArrayPositionRange(10, 1).getTraversingLoops());
    }
}
