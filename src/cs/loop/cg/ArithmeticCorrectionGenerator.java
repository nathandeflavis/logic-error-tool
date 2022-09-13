package cs.loop.cg;

import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import maths.is.ArithmeticInfiniteSequence;
import java.util.List;

/**
 * A utility to generate corrections to an erroneously infinite arithmetic loop.
 */
public class ArithmeticCorrectionGenerator extends CorrectionGenerator {

    /**
     * The sole constructor.
     *
     * @param al an infinite arithmetic loop
     */
    public ArithmeticCorrectionGenerator(ArithmeticLoop al) {
        super(al);
    }

    @Override
    public List<Loop> getCorrections() {
        try {
            List<Loop> corrections = super.getCorrections();
            Loop clone;

            for (int dPrime : getChangesToIntInput(((ArithmeticInfiniteSequence) loop.getIS()).getD())) {
                clone = (Loop) loop.clone();
                ((ArithmeticInfiniteSequence) (clone.getIS())).setD(dPrime);

                if (clone.terminates()) {
                    corrections.add((Loop) clone.clone());
                }
            }

            return corrections;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage()); //shouldn't reach here
        }
    }
}
