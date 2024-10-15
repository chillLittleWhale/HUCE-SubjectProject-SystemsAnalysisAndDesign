
package model;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel  extends DefaultTableModel  {
    private boolean[][] editable_cells; // 2d array to represent rows and columns

    public MyDefaultTableModel() { 
        super();
    }


    public void setCellEditable(int row, int col, boolean value) {
        this.editable_cells[row][col] = value; // set cell true/false
        this.fireTableCellUpdated(row, col);
    }
}
