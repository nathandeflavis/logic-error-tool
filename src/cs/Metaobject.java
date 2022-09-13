package cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A model of a base object that declares at least 1 string instance variable
 * and can be in 1 of multiple initial states. Each initial state describes a
 * set of initialisations performed by a base object constructor.
 */
public class Metaobject {

    private final List<String> vars;
    private List<Map<String, String>> initialStates;

    /**
     * The sole metaobject constructor.
     *
     * @param vars the base object's variables
     * @param initialStates mappings from names to values for the variables
     */
    public Metaobject(List<String> vars, List<Map<String, String>> initialStates) {
        this.vars = vars;
        this.initialStates = initialStates;
    }

    /**
     * A getter.
     *
     * @return mappings from names to values for the base object's variables
     */
    public List<Map<String, String>> getInitialStates() {
        return initialStates;
    }

    /**
     * A method to find variables of the base object implicitly initialised to
     * null.
     *
     * @return variables of the base object that are not initialised in all of
     * the object's constructors
     */
    public List<String> getUninitialisedVars() {
        List<String> uninitialisedVars = new ArrayList<>();

        for (String var : vars) {
            for (Map<String, String> initialState : initialStates) {
                if (!initialState.containsKey(var)) {
                    uninitialisedVars.add(var);
                    break;
                }
            }
        }

        return uninitialisedVars;
    }

    /**
     * A method to initialise the base object's variables to an empty string
     * wherever they are not initialised in a constructor of the object.
     */
    public void addMissingInitialisations() {
        getUninitialisedVars().stream().forEach((uninitialisedVar) -> {
            initialStates.stream().filter((initialState) -> (!initialState.containsKey(uninitialisedVar))).forEach((initialState) -> {
                initialState.put(uninitialisedVar, "\"\"");
            });
        });

        List<Map<String, String>> distinctInitialStates = new ArrayList<>();

        //remove duplicate constructors
        initialStates.stream().filter((initialState) -> (!distinctInitialStates.contains(initialState))).forEach((initialState) -> {
            distinctInitialStates.add(initialState);
        });

        initialStates = distinctInitialStates;
    }
}
