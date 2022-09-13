package cs.loop.cg;

import cs.loop.Loop;
import maths.Relation;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility to generate corrections to an erroneously infinite loop.
 */
public abstract class CorrectionGenerator {

    Loop loop;

    CorrectionGenerator(Loop loop) {
        this.loop = loop;
    }

    Loop getLoop() {
        return loop;
    }

    /**
     * A method to generate corrections to an erroneously infinite loop by
     * changing 1 input at a time.
     *
     * @return finite loops with similar inputs to an infinite loop
     */
    public List<Loop> getCorrections() {
        try {
            List<Loop> corrections = new ArrayList<>();
            Loop clone;

            for (int aPrime : getChangesToIntInput((loop.getIS()).getA())) {
                clone = (Loop) loop.clone();
                (clone.getIS()).setA(aPrime);

                if (clone.terminates()) {
                    corrections.add((Loop) clone.clone());
                }
            }

            for (int bPrime : getChangesToIntInput((loop.getGuard()).getB())) {
                clone = (Loop) loop.clone();
                (clone.getGuard()).setB(bPrime);

                if (clone.terminates()) {
                    corrections.add((Loop) clone.clone());
                }
            }

            for (Relation RPrime : getChangesToR()) {
                clone = (Loop) loop.clone();
                (clone.getGuard()).setR(RPrime);

                if (clone.terminates()) {
                    corrections.add((Loop) clone.clone());
                }
            }

            return corrections;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); //shouldn't reach here
        }
    }

    static int[] getChangesToIntInput(int input) {
        return new int[]{input + 1, input - 1, -input};
    }

    private Relation[] getChangesToR() {
        Relation R = (loop.getGuard()).getR();

        switch (R) {
            case LT:
                return new Relation[]{Relation.GT, Relation.LTOET};
            case LTOET:
                return new Relation[]{Relation.GTOET, Relation.LT};
            case GT:
                return new Relation[]{Relation.LT, Relation.GTOET};
            case GTOET:
                return new Relation[]{Relation.LTOET, Relation.GT};
            default: //NET or ET
                return new Relation[]{R.getComplement()};
        }
    }
}
