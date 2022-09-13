package maths.ae;

/**
 * A binary arithmetic operation.
 */
public enum Operation {

    /**
     * An exponentiation.
     */
    EXPONENTIATE,
    /**
     * A division.
     */
    DIVIDE,
    /**
     * A multiplication.
     */
    MULTIPLY,
    /**
     * An addition.
     */
    ADD,
    /**
     * A subtraction.
     */
    SUBTRACT;

    static Operation toOperation(char operator) {
        switch (operator) {
            case '^':
                return EXPONENTIATE;
            case '/':
                return DIVIDE;
            case '*':
                return MULTIPLY;
            case '+':
                return ADD;
            case '-':
                return SUBTRACT;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    //has higher precedence than
    boolean precedes(Operation op) {
        return compareTo(op) < 0;
    }

    @Override
    public String toString() {
        switch (this) {
            case EXPONENTIATE:
                return "^";
            case DIVIDE:
                return "/";
            case MULTIPLY:
                return "*";
            case ADD:
                return "+";
            default: //SUBTRACT
                return "-";
        }
    }
}
