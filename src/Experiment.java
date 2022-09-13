
import cs.Guard;
import cs.loop.ArithmeticLoop;
import cs.loop.Loop;
import cs.loop.cg.ArithmeticCorrectionGenerator;
import cs.loop.ic.ArithmeticIterationCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;

/**
 * The experiment, as part of the experimental research method used.
 */
class Experiment {

    /**
     * A main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        List<Loop> infiniteLoops = new ArrayList<>();
        int numInfiniteLoopSpawns = 100;

        while (infiniteLoops.size() < numInfiniteLoopSpawns) {
            Relation[] relations = Relation.values();
            Loop loop = new ArithmeticLoop(new ArithmeticInfiniteSequence(random.nextInt(), random.nextInt()), new Guard(relations[random.nextInt(relations.length)], random.nextInt()));

            if (!loop.terminates()) {
                infiniteLoops.add(loop);
            }
        }

        int numOccurrencesOfA = 0;

        for (Loop infiniteLoop : infiniteLoops) {
            List<Loop> corrections = new ArithmeticCorrectionGenerator((ArithmeticLoop) infiniteLoop).getCorrections();
            for (Loop correction : corrections) {
                if ((new ArithmeticIterationCounter((ArithmeticLoop) correction)).getCount() > 1) {
                    numOccurrencesOfA++;
                    break;
                }
            }
        }

        System.out.println(numOccurrencesOfA + " occurrences of A, out of " + numInfiniteLoopSpawns + " infinite loop spawns");
    }
}
