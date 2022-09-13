package maths;

/**
 * A comparison-based relation between numbers.
 */
public enum Relation {

    /**
     * A less-than relation.
     */
    LT,
    /**
     * A less-than-or-equal-to relation.
     */
    LTOET,
    /**
     * A greater-than relation.
     */
    GT,
    /**
     * A greater-than-or-equal-to relation.
     */
    GTOET,
    /**
     * A not-equal-to relation.
     */
    NET,
    /**
     * An equal-to relation.
     */
    ET;

    /**
     * A method to compute the complement of this relation.
     *
     * @return a relation S for this relation R such that for all numbers x and
     * y, if x S y then ¬(x R y)
     */
    public Relation getComplement() {
        switch (this) {
            case LT:
                return GTOET;
            case LTOET:
                return GT;
            case GT:
                return LTOET;
            case GTOET:
                return LT;
            case NET:
                return ET;
            default: //ET
                return NET;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case LT:
                return "<";
            case LTOET:
                return "≤";
            case GT:
                return ">";
            case GTOET:
                return "≥";
            case NET:
                return "≠";
            default: //ET
                return "=";
        }
    }
}
