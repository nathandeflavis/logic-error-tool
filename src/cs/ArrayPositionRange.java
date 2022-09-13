package cs;

import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import java.util.ArrayList;
import java.util.List;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;

/**
 * A contiguous range of 1-based positions in an array.
 */
public class ArrayPositionRange {

    private final int start, end;

    /**
     * The sole constructor.
     *
     * @param start the start position in the array
     * @param end the end position in the array
     */
    public ArrayPositionRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * A method to generate loops to traverse the 0-based array index range
     * corresponding to the array position range.
     *
     * @return loops whose control variable assumes values from the index range
     */
    public List<Loop> getTraversingLoops() {
        int a = start - 1, b = end - 1, d;
        List<Loop> loops = new ArrayList<>();
        List<Guard> guards = new ArrayList<>();

        if (a > b) {
            guards.add(new Guard(Relation.GT, b - 1));
            guards.add(new Guard(Relation.GTOET, b));
            d = -1;
        } else {
            guards.add(new Guard(Relation.LT, end));
            guards.add(new Guard(Relation.LTOET, b));
            d = 1;
        }

        guards.stream().forEach((guard) -> {
            loops.add(new ArithmeticLoop(new ArithmeticInfiniteSequence(a, d), guard));
        });

        return loops;
    }
}
