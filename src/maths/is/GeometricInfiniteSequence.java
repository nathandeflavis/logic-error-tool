package maths.is;

/**
 * A geometric infinite sequence of integers.
 */
public class GeometricInfiniteSequence extends InfiniteSequence implements Cloneable {

    private int r;

    /**
     * The sole constructor.
     *
     * @param a the first term in the GIS
     * @param r the ratio between consecutive terms in the GIS
     */
    public GeometricInfiniteSequence(int a, int r) {
        super(a);
        setR(r);
    }

    /**
     * A getter
     *
     * @return the ratio between consecutive terms in the GIS
     */
    public int getR() {
        return r;
    }

    /**
     * A setter.
     *
     * @param r the ratio between consecutive terms in the GIS
     */
    public final void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean hasSingleDistinctTerm() {
        return r == 1;
    }

    @Override
    public boolean containsNotStartsWith(int b) {
        switch (r) {
            case 0:
                return b == 0;
            case -1:
                return a == -b;
            default:
                return a == 0 || b == 0 ? false : (b % a == 0 && b % r == 0 ? r > 1 || (Math.signum(a) == Math.signum(b)) == (Math.log(Math.abs(b / a)) / Math.log(Math.abs(r)) % 2 == 0) : false);
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = super.equals(o);

        if (o instanceof GeometricInfiniteSequence) {
            equals &= (r == ((GeometricInfiniteSequence) o).r);
        }

        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.r;
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GeometricInfiniteSequence gis
                = (GeometricInfiniteSequence) super.clone();
        gis.r = r;
        return gis;
    }
}
