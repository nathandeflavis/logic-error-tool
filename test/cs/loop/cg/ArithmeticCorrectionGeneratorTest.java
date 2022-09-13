package cs.loop.cg;

import cs.Guard;
import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of ArithmeticCorrectionGenerator.
 */
public class ArithmeticCorrectionGeneratorTest {

    /**
     * A method to test corrections to infinite loops where R = '{@literal <}'.
     */
    @Test
    public void testGetCorrections_LT() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.LT, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.LT, -1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.GT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 1), new Guard(Relation.LT, 1))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.LT, 1)))).getCorrections());
    }

    /**
     * A method to test corrections to infinite loops where R = '≤'.
     */
    @Test
    public void testGetCorrections_LTOET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(2, 0), new Guard(Relation.LTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LTOET, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LTOET, -1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.LTOET, 1))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LTOET, 1)))).getCorrections());
    }

    /**
     * A method to test corrections to infinite loops where R = '{@literal >}'.
     */
    @Test
    public void testGetCorrections_GT() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.GT, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(-1, 0), new Guard(Relation.GT, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.LT, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, -1), new Guard(Relation.GT, 0))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GT, 0)))).getCorrections());
    }

    /**
     * A method to test corrections to infinite loops where R = '≥'.
     */
    @Test
    public void testGetCorrections_GTOET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.GTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(-1, 0), new Guard(Relation.GTOET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GTOET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GT, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, -1), new Guard(Relation.GTOET, 1))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.GTOET, 1)))).getCorrections());
    }

    /**
     * A method to test corrections to infinite loops where R = '≠'.
     */
    @Test
    public void testGetCorrections_NET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(2, 2), new Guard(Relation.NET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 2), new Guard(Relation.NET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 2), new Guard(Relation.NET, 3)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 2), new Guard(Relation.NET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 2), new Guard(Relation.ET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.NET, 2))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 2), new Guard(Relation.NET, 2)))).getCorrections());
    }

    /**
     * A method to test corrections to infinite loops where R = '='.
     */
    @Test
    public void testGetCorrections_ET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new ArithmeticLoop(new ArithmeticInfiniteSequence(2, 0), new Guard(Relation.ET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(0, 0), new Guard(Relation.ET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(-1, 0), new Guard(Relation.ET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.ET, 2)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.ET, 0)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.ET, -1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.NET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 1), new Guard(Relation.ET, 1)),
            new ArithmeticLoop(new ArithmeticInfiniteSequence(1, -1), new Guard(Relation.ET, 1))
        }));
        assertEquals(corrections, (new ArithmeticCorrectionGenerator(new ArithmeticLoop(new ArithmeticInfiniteSequence(1, 0), new Guard(Relation.ET, 1)))).getCorrections());
    }
}
