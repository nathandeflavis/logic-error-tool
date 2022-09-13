package maths.ae;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of Node.
 */
public class NodeTest {

    /**
     * A method to test generating an arithmetic expression where operations are
     * performed in descending order of precedence.
     */
    @Test
    public void testToString_descendingPrecedenceOps() {
        Node exp = new Node(Operation.EXPONENTIATE, new Node("a"), new Node("b")),
                quot = new Node(Operation.DIVIDE, exp, new Node("c")),
                prod = new Node(Operation.MULTIPLY, quot, new Node("d")),
                sum = new Node(Operation.ADD, prod, new Node("e")),
                diff = new Node(Operation.SUBTRACT, sum, new Node("f"));
        assertEquals("a ^ b / c * d + e - f", diff.toString());
    }

    /**
     * A method to test generating an arithmetic expression where operations are
     * performed in ascending order of precedence.
     */
    @Test
    public void testToString_ascendingPrecedenceOps() {
        Node diff = new Node(Operation.SUBTRACT, new Node("a"), new Node("b")),
                sum = new Node(Operation.ADD, diff, new Node("c")),
                prod = new Node(Operation.MULTIPLY, sum, new Node("d")),
                quot = new Node(Operation.DIVIDE, prod, new Node("e")),
                exp = new Node(Operation.EXPONENTIATE, quot, new Node("f"));
        assertEquals("((((a - b) + c) * d) / e) ^ f", exp.toString());
    }
}
