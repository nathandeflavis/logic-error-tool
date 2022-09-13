package cs.rmc;

import cs.Guard;
import cs.loop.GeometricLoop;
import cs.loop.Loop;
import maths.is.GeometricInfiniteSequence;

/**
 * A call to a recursive method, for which the values of the actual parameter
 * form a geometric sequence.
 */
public class GeometricRecursiveMethodCall extends RecursiveMethodCall {

    /**
     * The sole constructor.
     *
     * @param gis a geometric infinite sequence that is a superset of the values
     * the recursive method's actual parameter assumes
     * @param baseCase the recursive method's base case
     */
    public GeometricRecursiveMethodCall(GeometricInfiniteSequence gis, Guard baseCase) {
        super(gis, baseCase);
    }

    @Override
    public Loop toLoop() {
        return new GeometricLoop((GeometricInfiniteSequence) is, getLoopGuard());
    }
}
