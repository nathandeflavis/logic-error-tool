package maths.ae;

/**
 * A node in an arithmetic expression tree.
 */
public class Node implements Cloneable {

    private String label;
    private Node left, right;

    /**
     * The constructor for a term node.
     *
     * @param term the term with which to label the node
     */
    public Node(String term) {
        label = term;
    }

    /**
     * The constructor for an operation node.
     *
     * @param operation the operation with which to label the node
     * @param operand1 the operand with which to label the left sub-node
     * @param operand2 the operand with which to label the right sub-node
     */
    public Node(Operation operation, Node operand1, Node operand2) {
        this(operation.toString());
        left = operand1;
        right = operand2;
    }

    private boolean isLeaf() {
        return left == null; //full binary tree so if no left subnode, then no right subnode either
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            //term node
            return label;
        } else {
            //operation node
            Node[] subnodes = new Node[]{left, right};
            int numSubnodes = subnodes.length;
            String[] subnodeStrings = new String[numSubnodes];

            for (int i = 0; i < numSubnodes; i++) {
                Node subnode = subnodes[i];
                String subnodeString = subnode.toString();

                if (!subnode.isLeaf() && (Operation.toOperation(label.charAt(0))).precedes(Operation.toOperation((subnode.label).charAt(0)))) {
                    subnodeString = "(" + subnodeString + ")"; //bracket lower-precedence operations
                }

                subnodeStrings[i] = subnodeString;
            }

            return subnodeStrings[0] + " " + label + " " + subnodeStrings[1];
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Node node = (Node) super.clone();
        node.label = "" + label; //make copy of string

        if (!node.isLeaf()) {
            node.left = (Node) left.clone();
            node.right = (Node) right.clone();
        }

        return node;
    }
}
