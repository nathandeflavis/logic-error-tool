package maths.is;

/**
 * An arithmetic infinite sequence of integers.
 */
public class ArithmeticInfiniteSequence extends InfiniteSequence implements Cloneable {

    private int d;

    /**
     * The sole constructor.
     *
     * @param a the first term in the AIS
     * @param d the difference between consecutive terms in the AIS
     */
    public ArithmeticInfiniteSequence(int a, int d) {
        super(a);
        setD(d);
    }

    /**
     * A getter.
     *
     * @return the difference between consecutive terms in the AIS
     */
    public int getD() {
        return d;
    }

    /**
     * A setter.
     *
     * @param d the difference between consecutive terms in the AIS
     */
    public final void setD(int d) {
        this.d = d;
    }

    @Override
    public boolean hasSingleDistinctTerm() {
        return d == 0;
    }

    @Override
    public boolean containsNotStartsWith(int b) {
        int delta = b - a;
        return delta % d == 0 && Math.signum(delta) == Math.signum(d);
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = super.equals(o);

        if (o instanceof ArithmeticInfiniteSequence) {
            equals &= (d == ((ArithmeticInfiniteSequence) o).d);
        }

        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.d;
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ArithmeticInfiniteSequence ais = (ArithmeticInfiniteSequence) super.clone();
        ais.d = d;
        return ais;
    }
}
