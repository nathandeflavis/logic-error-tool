package cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of Metaobject.
 */
public class MetaobjectTest {

    /**
     * A method to test finding variables of the base object implicitly
     * initialised to null, in the case that there are no variables.
     */
    @Test
    public void testGetUninitialisedVars_noVars() {
        List<String> vars = new ArrayList<>();
        List<Map<String, String>> initialStates = new ArrayList<>();
        initialStates.add(new HashMap<>());
        assertEquals(vars, (new Metaobject(vars, initialStates)).getUninitialisedVars());
    }

    /**
     * A method to test finding variables of the base object implicitly
     * initialised to null, in the case that there is a variable that no
     * constructor initialises.
     */
    @Test
    public void testGetUninitialisedVars_varInitialisedNowhere() {
        List<String> vars = new ArrayList<>();
        vars.add("var");
        List<Map<String, String>> initialStates = new ArrayList<>();
        initialStates.add((new HashMap<>()));
        assertEquals(vars, (new Metaobject(vars, initialStates)).getUninitialisedVars());
    }

    /**
     * A method to test finding variables of the base object implicitly
     * initialised to null, in the case that there is a variable that only 1 of
     * 2 constructors initialises.
     */
    @Test
    public void testGetUninitialisedVars_varInitialisedNotEverywhere() {
        List<String> vars = new ArrayList<>();
        vars.add("var");
        List<Map<String, String>> initialStates = new ArrayList<>();
        initialStates.add(new HashMap<>());
        Map<String, String> config = new HashMap<>();
        config.put("var", "");
        assertEquals(vars, (new Metaobject(vars, initialStates)).getUninitialisedVars());
    }

    /**
     * A method to test finding variables of the base object implicitly
     * initialised to null, in the case that there is a variable that all
     * constructors initialise.
     */
    @Test
    public void testGetVarsNotInitialisedInAllConstructors_varInitialisedEverywhere() {
        List<String> vars = new ArrayList<>();
        vars.add("var");
        List<Map<String, String>> initialStates = new ArrayList<>();
        Map<String, String> config = new HashMap<>();
        config.put("var", "");
        assertEquals(new ArrayList<>(), (new Metaobject(vars, initialStates)).getUninitialisedVars());
    }

    /**
     * A method to test initialising the base object's variables to an empty
     * string wherever they are not initialised in a constructor of the object.
     */
    @Test
    public void testAddMissingInitialisations() {
        List<String> vars = new ArrayList<>();
        vars.add("var1");
        vars.add("var2");
        Map<String, String> initialState1 = new HashMap<>();
        initialState1.put("var1", "");
        List<Map<String, String>> initialStates = new ArrayList<>();
        initialStates.add(initialState1);
        Map<String, String> initialState2 = new HashMap<>();
        initialState2.put("var2", "");
        initialStates.add(initialState2);
        Metaobject metaobj = new Metaobject(vars, initialStates);
        metaobj.addMissingInitialisations();
        assertEquals(new ArrayList<>(), metaobj.getUninitialisedVars());
    }
}
