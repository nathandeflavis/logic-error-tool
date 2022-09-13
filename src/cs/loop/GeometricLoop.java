package cs.loop;

import cs.Guard;
import maths.Relation;
import maths.is.GeometricInfiniteSequence;

/**
 * A loop for which the values the control variable assumes form a geometric
 * sequence.
 */
public class GeometricLoop extends Loop {

    /**
     * The sole constructor.
     *
     * @param gis a geometric infinite sequence that is a superset of the values
     * the loop's control variable assumes
     * @param guard a guard such that for as long as it evaluates to TRUE, the
     * loop runs
     */
    public GeometricLoop(GeometricInfiniteSequence gis, Guard guard) {
        super(gis, guard);
    }

    @Override
    boolean terminatesEventually_neitherNETnorET() {
        return ((GeometricInfiniteSequence) is).getR() < -1 ? is.getA() != 0 : super.terminatesEventually_neitherNETnorET();
    }

    @Override
    boolean terminatesEventually_LTorLTOET() {
        int r = ((GeometricInfiniteSequence) is).getR();
        int a = is.getA();
        int b = guard.getB();
        return r > 1 ? a > 0 : ((guard.getR()).equals(Relation.LT) ? (r == 0 ? b <= 0 : -a >= b) : (r == 0 ? b < 0 : -a > b));
    }

    @Override
    boolean terminatesEventually_GTorGTOET() {
        int r = ((GeometricInfiniteSequence) is).getR();
        int a = is.getA();
        int b = guard.getB();
        return r > 1 ? a < 0 : ((guard.getR()).equals(Relation.GT) ? (r == 0 ? b >= 0 : -a <= b) : (r == 0 ? b > 0 : -a < b));
    }
}
