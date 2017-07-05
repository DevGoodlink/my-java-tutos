package tp3.presentationLayer;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModelEtudiant extends AbstractTableModel {

	private String[] ColumnNames = {};
	private Object[][] data = { {} };

	public TableModelEtudiant() {

	}

	public TableModelEtudiant(String[] columnName, Object[][] data) {
		super();
		ColumnNames = columnName;
		this.data = data;
	}

	public int getColumnCount() {

		return ColumnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt(int arg0, int arg1) {
		return this.data[arg0][arg1];
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public void setColumnNames(String[] ColumnNames) {
		this.ColumnNames = ColumnNames;
	}

	public String getColumnName(int col) {
		return ColumnNames[col];// .toString();
	}
}
