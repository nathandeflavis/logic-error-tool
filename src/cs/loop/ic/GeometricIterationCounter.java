package cs.loop.ic;

import cs.loop.GeometricLoop;
import maths.is.GeometricInfiniteSequence;

/**
 * A utility to count iterations in a finite geometric loop.
 */
public class GeometricIterationCounter extends IterationCounter {

    //store r as constant to make f function (called in loop) more efficient
    private final int r;

    /**
     * The sole constructor.
     *
     * @param gl a finite geometric loop
     */
    public GeometricIterationCounter(GeometricLoop gl) {
        super(gl);
        r = ((GeometricInfiniteSequence) gl.getIS()).getR();
    }

    @Override
    int f(int i) {
        return i * r;
    }
}
