package cs.rmc;

import cs.Guard;
import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import maths.is.ArithmeticInfiniteSequence;

/**
 * A call to a recursive method, for which the values of the actual parameter
 * form an arithmetic sequence.
 */
public class ArithmeticRecursiveMethodCall extends RecursiveMethodCall {

    /**
     * The sole constructor.
     *
     * @param ais an arithmetic infinite sequence that is a superset of the
     * values the recursive method's actual parameter assumes
     * @param baseCase the recursive method's base case
     */
    public ArithmeticRecursiveMethodCall(ArithmeticInfiniteSequence ais, Guard baseCase) {
        super(ais, baseCase);
    }

    @Override
    public Loop toLoop() {
        return new ArithmeticLoop((ArithmeticInfiniteSequence) is, getLoopGuard());
    }
}
