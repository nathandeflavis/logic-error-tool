package ui.lec;

import java.util.Map;

/**
 * An interface to be implemented by classes that generate a correction option
 * dialog.
 */
public interface CorrectionRequestListener {

    /**
     * A callback mechanism. When the user clicks 'Change' in a correction
     * option dialog, it calls this method with the selected correction.
     *
     * @param namesToValues a mapping from names to correct values for inputs to
     * the correction request listener
     */
    void correctionRequested(Map<String, Object> namesToValues);
}
