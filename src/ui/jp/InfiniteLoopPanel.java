package ui.jp;

import ui.lec.CorrectionOptionDialog;
import ui.AbstractTableModelImpl;
import cs.Guard;
import cs.loop.ArithmeticLoop;
import cs.loop.GeometricLoop;
import cs.loop.Loop;
import cs.loop.cg.ArithmeticCorrectionGenerator;
import cs.loop.cg.CorrectionGenerator;
import cs.loop.cg.GeometricCorrectionGenerator;
import cs.loop.ic.ArithmeticIterationCounter;
import cs.loop.ic.GeometricIterationCounter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import maths.Relation;
import maths.is.ArithmeticInfiniteSequence;
import maths.is.GeometricInfiniteSequence;
import maths.is.InfiniteSequence;
import java.util.List;
import ui.lec.CorrectionRequestListener;

/**
 * A JPanel where the user can check for infinite loop error.
 */
public class InfiniteLoopPanel extends javax.swing.JPanel implements CorrectionRequestListener {

    private final Map<String, Integer> intInput_namesToVals;

    /**
     * Creates new form InfiniteLoopPanel
     */
    public InfiniteLoopPanel() {
        initComponents();
        intInput_namesToVals = new HashMap<>();

        for (JTextField textField : new JTextField[]{aTextField, bTextField, operandTextField}) {
            intInput_namesToVals.put(textField.getName(), null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        aTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        RComboBox = new javax.swing.JComboBox<>();
        bTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        operatorComboBox = new javax.swing.JComboBox<>();
        operandTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        operandLabel = new javax.swing.JLabel();

        jLabel1.setText("i :=");

        aTextField.setName("a"); // NOI18N

        jLabel2.setText("WHILE i");

        RComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<", "≤", ">", "≥", "≠", "=" }));

        bTextField.setName("b"); // NOI18N

        jLabel3.setText("//do something with i");

        jLabel4.setText("i := i");

        operatorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "*" }));

        operandTextField.setName("operand"); // NOI18N

        jLabel5.setText("END_WHILE");

        checkButton.setText("Check");
        checkButton.setEnabled(false);

        jLabel6.setText("a");

        jLabel7.setText("R");

        jLabel8.setText("b");

        operandLabel.setText("d");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel7)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(operatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(operandLabel)
                            .addComponent(operandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(aTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(operandLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(operatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        (aTextField.getDocument()).addDocumentListener(new DocumentListenerImpl(aTextField));
        (bTextField.getDocument()).addDocumentListener(new DocumentListenerImpl(bTextField));
        operatorComboBox.addActionListener(new ComboBoxActionListenerImpl());
        (operandTextField.getDocument()).addDocumentListener(new DocumentListenerImpl(operandTextField));
        checkButton.addActionListener(new ButtonActionListenerImpl(this));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> RComboBox;
    private javax.swing.JTextField aTextField;
    private javax.swing.JTextField bTextField;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel operandLabel;
    private javax.swing.JTextField operandTextField;
    private javax.swing.JComboBox<String> operatorComboBox;
    // End of variables declaration//GEN-END:variables

    private boolean plusOperatorIsSelected() {
        return (operatorComboBox.getSelectedItem()).equals("+");
    }

    @Override
    public void correctionRequested(Map<String, Object> namesToValues) {
        intInput_namesToVals.put("a", (Integer) namesToValues.get("a"));
        intInput_namesToVals.put("b", (Integer) namesToValues.get("b"));
        String operandName = plusOperatorIsSelected() ? "d" : "r";
        intInput_namesToVals.put((operandName), (Integer) namesToValues.get(operandName));
        aTextField.setText(Integer.toString(intInput_namesToVals.get("a")));
        RComboBox.setSelectedItem(namesToValues.get("R"));
        bTextField.setText(Integer.toString(intInput_namesToVals.get("b")));
        operandTextField.setText(Integer.toString(intInput_namesToVals.get(operandName)));
    }

    private class ButtonActionListenerImpl implements ActionListener {

        InfiniteLoopPanel panel;

        ButtonActionListenerImpl(InfiniteLoopPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Loop loop = getLoop();

            if (loop.terminates()) {
                JOptionPane.showMessageDialog(panel, "Loop is finite (" + getIterationCount(loop) + " iteration(s))");
            } else {
                (new CorrectionOptionDialog("Loop is infinite", new AbstractTableModelImpl(getRowData_correctionTable(loop), getColumnData_correctionTable()), panel)).setVisible(true);
            }
        }

        Loop getLoop() {
            Guard guard = new Guard(Relation.values()[RComboBox.getSelectedIndex()], intInput_namesToVals.get("b"));
            int a = intInput_namesToVals.get("a"), operand = intInput_namesToVals.get("operand");
            return plusOperatorIsSelected() ? new ArithmeticLoop(new ArithmeticInfiniteSequence(a, operand), guard) : new GeometricLoop(new GeometricInfiniteSequence(a, operand), guard);
        }

        int getIterationCount(Loop loop) {
            return (plusOperatorIsSelected() ? new ArithmeticIterationCounter((ArithmeticLoop) loop) : new GeometricIterationCounter((GeometricLoop) loop)).getCount();
        }

        Object[][] getRowData_correctionTable(Loop loop) {
            CorrectionGenerator generator = plusOperatorIsSelected() ? new ArithmeticCorrectionGenerator((ArithmeticLoop) loop) : new GeometricCorrectionGenerator((GeometricLoop) loop);
            List<Loop> corrections = generator.getCorrections();
            int numRows = corrections.size();
            Object[][] rowData = new Object[numRows][getColumnData_correctionTable().length];

            for (int row = 0; row < numRows; row++) {
                Loop correction = corrections.get(row);
                InfiniteSequence is = correction.getIS();
                Guard guard = correction.getGuard();
                //using string version of R fixes issue with R combo box not updating when user chooses to make correction that changes R
                rowData[row] = new Object[]{is.getA(), (guard.getR()).toString(), guard.getB(), plusOperatorIsSelected() ? ((ArithmeticInfiniteSequence) is).getD() : ((GeometricInfiniteSequence) is).getR(), getIterationCount(correction)};
            }

            return rowData;
        }

        Object[] getColumnData_correctionTable() {
            return new Object[]{"a", "R", "b", (plusOperatorIsSelected() ? "d" : "r"), "Iterations"};
        }
    }

    private class ComboBoxActionListenerImpl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            operandLabel.setText(plusOperatorIsSelected() ? "d" : "r");
        }
    }

    private class DocumentListenerImpl implements DocumentListener {

        JTextField textField;

        DocumentListenerImpl(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            handleUpdate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            handleUpdate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            handleUpdate();
        }

        void handleUpdate() {
            Integer val;

            try {
                val = Integer.parseInt(textField.getText());
            } catch (NumberFormatException e) {
                val = null;
            }

            intInput_namesToVals.put(textField.getName(), val);
            checkButton.setEnabled(!intInput_namesToVals.containsValue(null));
        }
    }
}
