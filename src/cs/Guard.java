package cs;

import maths.Relation;
import java.util.Objects;

/**
 * A guard that compares a control variable's value with some other value.
 */
public class Guard implements Cloneable {

    private Relation R;
    private int b;

    /**
     * The sole constructor.
     *
     * @param R a relation defined on a control variable i and b such that i R b
     * @param b a value with which the value of i is compared
     */
    public Guard(Relation R, int b) {
        setR(R);
        setB(b);
    }

    /**
     * A getter.
     *
     * @return a relation defined on a control variable i and b such that i R b
     */
    public Relation getR() {
        return R;
    }

    /**
     * A setter.
     *
     * @param R a relation defined on a control variable i and b such that i R b
     */
    public final void setR(Relation R) {
        this.R = R;
    }

    /**
     * A getter.
     *
     * @return a value with which a control variable's value is compared
     */
    public int getB() {
        return b;
    }

    /**
     * A setter.
     *
     * @param b a value with which a control variable's value is compared
     */
    public final void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Guard) {
            Guard guard = (Guard) o;
            return (guard.R).equals(R) && guard.b == b;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.R);
        hash = 59 * hash + Objects.hashCode(this.b);
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Guard guard = (Guard) super.clone();
        guard.R = R;
        guard.b = b;
        return guard;
    }
}
