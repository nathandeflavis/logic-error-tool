package cs.loop.cg;

import cs.loop.GeometricLoop;
import cs.loop.Loop;
import maths.is.GeometricInfiniteSequence;
import java.util.List;

/**
 * A utility to generate corrections to an erroneously infinite geometric loop.
 */
public class GeometricCorrectionGenerator extends CorrectionGenerator {

    /**
     * The sole constructor.
     *
     * @param gl an infinite geometric loop
     */
    public GeometricCorrectionGenerator(GeometricLoop gl) {
        super(gl);
    }

    @Override
    public List<Loop> getCorrections() {
        try {
            List<Loop> corrections = super.getCorrections();
            Loop clone;

            for (int rPrime : getChangesToIntInput(((GeometricInfiniteSequence) loop.getIS()).getR())) {
                clone = (Loop) loop.clone();
                ((GeometricInfiniteSequence) (clone.getIS())).setR(rPrime);

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
