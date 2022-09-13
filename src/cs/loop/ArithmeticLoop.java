package cs.loop;

import cs.Guard;
import maths.is.ArithmeticInfiniteSequence;

/**
 * A loop for which the values the control variable assumes form an arithmetic
 * sequence.
 */
public class ArithmeticLoop extends Loop {

    /**
     * The sole constructor.
     *
     * @param ais: an arithmetic infinite sequence that is a superset of the
     * values the loop's control variable assumes
     * @param guard: a guard such that for as long as it evaluates to TRUE, the
     * loop runs
     */
    public ArithmeticLoop(ArithmeticInfiniteSequence ais, Guard guard) {
        super(ais, guard);
    }

    @Override
    boolean terminatesEventually_LTorLTOET() {
        return ((ArithmeticInfiniteSequence) is).getD() > 0;
    }

    @Override
    boolean terminatesEventually_GTorGTOET() {
        return ((ArithmeticInfiniteSequence) is).getD() < 0;
    }
}
