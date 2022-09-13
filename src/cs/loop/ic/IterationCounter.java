package cs.loop.ic;

import cs.Guard;
import cs.loop.Loop;
import maths.Relation;

/**
 * A utility to count iterations in a finite loop.
 */
public abstract class IterationCounter {

    private final Loop loop;
    /*store R and b as constants to make iRB function (called in loop) more
    efficient*/
    private final Relation R;
    private final int b;

    IterationCounter(Loop loop) {
        this.loop = loop;
        Guard guard = loop.getGuard();
        R = guard.getR();
        b = guard.getB();
    }

    /**
     * A method to count iterations in a finite loop. Note that this method will
     * actually run the loop, with only the final expression in the loop's body.
     *
     * @return the number of iterations in a finite loop
     */
    public int getCount() {
        int count = 0;
        int i = (loop.getIS()).getA();

        while (iRB(i)) {
            count++;
            i = f(i);
        }

        return count;
    }

    private boolean iRB(int i) {
        switch (R) {
            case LT:
                return i < b;
            case LTOET:
                return i <= b;
            case GT:
                return i > b;
            case GTOET:
                return i >= b;
            case NET:
                return i != b;
            case ET:
                return i == b;
            default:
                throw new NullPointerException("R is null");
        }
    }

    abstract int f(int i);
}
