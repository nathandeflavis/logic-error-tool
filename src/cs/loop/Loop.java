package cs.loop;

import cs.Guard;
import maths.is.InfiniteSequence;
import java.util.Objects;

/**
 * A loop for which the values the control variable assumes form a sequence.
 */
public abstract class Loop implements Cloneable {

    InfiniteSequence is;
    Guard guard;

    Loop(InfiniteSequence is, Guard guard) {
        this.is = is;
        this.guard = guard;
    }

    /**
     * A getter.
     *
     * @return an infinite sequence that is a superset of the values that the
     * loop's control variable assumes
     */
    public InfiniteSequence getIS() {
        return is;
    }

    /**
     * A getter.
     *
     * @return a guard such that for as long as it evaluates to TRUE, the loop
     * runs
     */
    public Guard getGuard() {
        return guard;
    }

    /**
     * A method to analyse loop termination.
     *
     * @return a truth value for whether the loop terminates
     */
    public boolean terminates() {
        return terminatesImmediately() || terminatesEventually();
    }

    private boolean terminatesImmediately() {
        int a = is.getA(), b = guard.getB();

        switch (guard.getR()) {
            case LT:
                return a >= b;
            case LTOET:
                return a > b;
            case GT:
                return a <= b;
            case GTOET:
                return a < b;
            case NET:
                return is.startsWith(b);
            default: //ET
                return !is.startsWith(b);
        }
    }

    private boolean terminatesEventually() {
        if (is.hasSingleDistinctTerm()) {
            return false;
        } else {
            switch (guard.getR()) {
                case NET:
                    return is.containsNotStartsWith(guard.getB());
                case ET:
                    return true;
                default: //LT, LTOET, GT, GTOET
                    return terminatesEventually_neitherNETnorET();
            }
        }
    }

    //assumptions: IS has multiple distinct terms and R ∉ {'≠', '='}
    boolean terminatesEventually_neitherNETnorET() {
        switch (guard.getR()) {
            case LT:
            case LTOET:
                return terminatesEventually_LTorLTOET();
            default: //GT, GTOET
                return terminatesEventually_GTorGTOET();
        }
    }

    //assumptions: IS has multiple distinct terms and R ∈ {'<', '≤'}
    abstract boolean terminatesEventually_LTorLTOET();

    //assumptions: IS has multiple distinct terms and R ∈ {'>', '≥'}
    abstract boolean terminatesEventually_GTorGTOET();

    @Override
    public boolean equals(Object o) {
        if (o instanceof Loop) {
            Loop loop = (Loop) o;
            return (loop.is).equals(is)
                    && (loop.guard).equals(guard);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.guard);
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Loop loop = (Loop) super.clone();
        loop.is = (InfiniteSequence) is.clone();
        loop.guard = (Guard) guard.clone();
        return loop;
    }
}
