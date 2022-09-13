package cs.loop;

import cs.Guard;
import maths.Relation;
import maths.is.GeometricInfiniteSequence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of GeometricLoop.
 */
public class GeometricLoopTest {

    /**
     * A method to test termination analysis of finite loops where R =
     * '{@literal <}'.
     */
    @Test
    public void testTerminates_finiteLoops_LT() {
        for (Loop loop : new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.LT, 2)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, 0), new Guard(Relation.LT, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -2), new Guard(Relation.LT, 2))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of finite loops where R = '≤'.
     */
    @Test
    public void testTerminates_finiteLoops_LTOET() {
        for (Loop loop : new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.LTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.LTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, 0), new Guard(Relation.LTOET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.LTOET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -2), new Guard(Relation.LTOET, 1))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of finite loops where R =
     * '{@literal >}'.
     */
    @Test
    public void testTerminates_finiteLoops_GT() {
        for (Loop loop : new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.GT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, 2), new Guard(Relation.GT, -2)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 0), new Guard(Relation.GT, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -1), new Guard(Relation.GT, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -2), new Guard(Relation.GT, 0))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of finite loops where R = '≥'.
     */
    @Test
    public void testTerminates_finiteLoops_GTOET() {
        for (Loop loop : new Loop[]{
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, 2), new Guard(Relation.GTOET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 0), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -1), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, -2), new Guard(Relation.GTOET, 1))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of finite loops where R ∈ {'≠',
     * '='}
     */
    @Test
    public void testTerminates_finiteLoops_NETorET() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 2)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.ET, 1))
        }) {
            assertTrue(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops where R =
     * '{@literal <}'.
     */
    @Test
    public void testTerminates_infiniteLoops_LT() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 1), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 0), new Guard(Relation.LT, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.LT, 2)),
            new GeometricLoop(new GeometricInfiniteSequence(0, -2), new Guard(Relation.LT, 1))
        }) {
            assertFalse(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops where R = '≤'.
     */
    @Test
    public void testTerminates_infiniteLoops_LTOET() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.LTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.LTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 0), new Guard(Relation.LTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.LTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, -2), new Guard(Relation.LTOET, 0))
        }) {
            assertFalse(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops where R =
     * '{@literal >}'.
     */
    @Test
    public void testTerminates_infiniteLoops_GT() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GT, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.GT, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 0), new Guard(Relation.GT, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.GT, -2)),
            new GeometricLoop(new GeometricInfiniteSequence(0, -2), new Guard(Relation.GT, -1))
        }) {
            assertFalse(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops where R = '≥'.
     */
    @Test
    public void testTerminates_infiniteLoops_GTOET() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(0, 2), new Guard(Relation.GTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.GTOET, 1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, 0), new Guard(Relation.GTOET, 0)),
            new GeometricLoop(new GeometricInfiniteSequence(-1, -1), new Guard(Relation.GTOET, -1)),
            new GeometricLoop(new GeometricInfiniteSequence(0, -2), new Guard(Relation.GTOET, 0))
        }) {
            assertFalse(loop.terminates());
        }
    }

    /**
     * A method to test termination analysis of infinite loops where R ∈ {'≠',
     * '='}.
     */
    @Test
    public void testTerminates_infiniteLoops_NETorET() {
        for (GeometricLoop loop : new GeometricLoop[]{
            new GeometricLoop(new GeometricInfiniteSequence(1, 2), new Guard(Relation.NET, 3)),
            new GeometricLoop(new GeometricInfiniteSequence(1, 1), new Guard(Relation.ET, 1))
        }) {
            assertFalse(loop.terminates());
        }
    }
}
