
import cs.loop.ArithmeticLoopTest;
import cs.loop.GeometricLoopTest;
import cs.loop.cg.ArithmeticCorrectionGeneratorTest;
import cs.loop.cg.GeometricCorrectionGeneratorTest;
import cs.loop.ic.ArithmeticIterationCounterTest;
import cs.loop.ic.GeometricIterationCounterTest;
import cs.MetaobjectTest;
import cs.rmc.ArithmeticRecursiveMethodCallTest;
import cs.rmc.GeometricRecursiveMethodCallTest;
import maths.ae.NodeTest;
import maths.is.ArithmeticInfiniteSequenceTest;
import maths.is.GeometricInfiniteSequenceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A class to group all tests together.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    ArithmeticLoopTest.class,
    GeometricLoopTest.class,
    ArithmeticCorrectionGeneratorTest.class,
    GeometricCorrectionGeneratorTest.class,
    ArithmeticIterationCounterTest.class,
    GeometricIterationCounterTest.class,
    MetaobjectTest.class,
    ArithmeticRecursiveMethodCallTest.class,
    GeometricRecursiveMethodCallTest.class,
    NodeTest.class,
    ArithmeticInfiniteSequenceTest.class,
    GeometricInfiniteSequenceTest.class
})
public class TestSuite {
}
