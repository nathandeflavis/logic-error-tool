package cs.loop.cg;

import cs.Guard;
import cs.loop.GeometricLoop;
import cs.loop.Loop;
import maths.Relation;
import maths.is.GeometricInfiniteSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of GeometricCorrectionGenerator.
 */
public class GeometricCorrectionGeneratorTest {

    /**
     * A method to test corrections to loops where R = '{@literal <}'.
     */
    @Test
    public void testGetCorrections_LT() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, 1))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, 1)))).getCorrections());
    }

    /**
     * A method to test corrections to loops where R = '≤'.
     */
    @Test
    public void testGetCorrections_LTOET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.LTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LTOET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, 0))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LTOET, 0)))).getCorrections());
    }

    /**
     * A method to test corrections to loops where R = '{@literal >}'.
     */
    @Test
    public void testGetCorrections_GT() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(-1, 2), new Guard(Relation.GT, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, -1))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, -1)))).getCorrections());
    }

    /**
     * A method to test corrections to loops where R = '≥'.
     */
    @Test
    public void testGetCorrections_GTOET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(-1, 2), new Guard(Relation.GTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, 0))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GTOET, 0)))).getCorrections());
    }

    /**
     * A method to test corrections to loops where R = '≠'.
     */
    @Test
    public void testGetCorrections_NET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 4)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 2)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.ET, 3)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 3), new Guard(Relation.NET, 3))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 3)))).getCorrections());
    }

    /**
     * A method to test corrections to loops where R = '='.
     */
    @Test
    public void testGetCorrections_ET() {
        List<Loop> corrections = new ArrayList<>();
        corrections.addAll(Arrays.asList(new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(2, 1), new Guard(Relation.ET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.ET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, 1), new Guard(Relation.ET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.ET, 2)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.ET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.ET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.NET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.ET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 0), new Guard(Relation.ET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -1), new Guard(Relation.ET, 1))
        }));
        assertEquals(corrections, (new GeometricCorrectionGenerator(new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.ET, 1)))).getCorrections());
    }
}
