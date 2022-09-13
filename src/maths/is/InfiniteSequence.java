package maths.is;

/**
 * An infinite sequence of integers.
 */
public abstract class InfiniteSequence implements Cloneable {

    int a;

    InfiniteSequence(int a) {
        setA(a);
    }

    /**
     * A getter.
     *
     * @return the first term in the IS
     */
    public int getA() {
        return a;
    }

    /**
     * A setter.
     *
     * @param a the first term in the IS
     */
    public final void setA(int a) {
        this.a = a;
    }

    /**
     * A method to determine whether the IS starts with some integer.
     *
     * @param b the integer
     * @return a truth value for whether b is the first term of the IS
     */
    public boolean startsWith(int b) {
        return a == b;
    }

    boolean contains(int b) {
        return startsWith(b) ? true : (hasSingleDistinctTerm() ? false : containsNotStartsWith(b));
    }

    /**
     * A method to determine whether the IS has exactly 1 distinct term.
     *
     * @return a truth value for whether the IS is equivalent to a
     * singleton
     */
    public abstract boolean hasSingleDistinctTerm();

    /**
     * A method to determine whether the IS contains but does not start
     * with some integer.
     *
     * @param b the integer
     * @return a truth value for whether b is a term of the IS and not the
     * first
     */
    public abstract boolean containsNotStartsWith(int b);

    @Override
    public boolean equals(Object o) {
        return o instanceof InfiniteSequence ? (a == ((InfiniteSequence) o).a) : false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.a;
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        InfiniteSequence is = (InfiniteSequence) super.clone();
        is.a = a;
        return is;
    }
}
