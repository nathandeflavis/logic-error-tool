package cs.loop.ic;

import cs.loop.ArithmeticLoop;
import maths.is.ArithmeticInfiniteSequence;

/**
 * A utility to count iterations in a finite arithmetic loop.
 */
public class ArithmeticIterationCounter extends IterationCounter {

    //store d as constant to make f function (called in loop) more efficient
    private final int d;

    /**
     * The sole constructor.
     *
     * @param al a finite arithmetic loop
     */
    public ArithmeticIterationCounter(ArithmeticLoop al) {
        super(al);
        d = ((ArithmeticInfiniteSequence) al.getIS()).getD();
    }

    @Override
    int f(int i) {
        return i + d;
    }
}
