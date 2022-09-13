package ui;

import javax.swing.table.AbstractTableModel;

/**
 * A read-only implementation of AbstractTableModel.
 */
public class AbstractTableModelImpl extends AbstractTableModel {

    private final Object[][] rowData;
    private final Object[] columnData;

    /**
     * The sole constructor.
     *
     * @param rowData the entries to display in the table
     * @param columnData the column headers to display in the table
     */
    public AbstractTableModelImpl(Object[][] rowData, Object[] columnData) {
        super();
        this.rowData = rowData;
        this.columnData = columnData;
    }

    @Override
    public int getColumnCount() {
        return columnData.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnData[columnIndex].toString();
    }

    @Override
    public int getRowCount() {
        return rowData.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
