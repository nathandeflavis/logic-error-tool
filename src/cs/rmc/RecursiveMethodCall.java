package cs.rmc;

import cs.Guard;
import cs.loop.Loop;
import maths.is.InfiniteSequence;

/**
 * A call to a recursive method, for which the values of the actual parameter
 * form a sequence.
 */
public abstract class RecursiveMethodCall {

    InfiniteSequence is;
    private final Guard baseCase;

    RecursiveMethodCall(InfiniteSequence is, Guard baseCase) {
        this.is = is;
        this.baseCase = baseCase;
    }

    /**
     * A method to generate an iterative version of the recursive method call.
     *
     * @return a loop equivalent to the recursive method call
     */
    public abstract Loop toLoop();

    Guard getLoopGuard() {
        return new Guard((baseCase.getR()).getComplement(), baseCase.getB());
    }
}
