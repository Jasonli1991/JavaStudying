package tw.org.iii.myclasses;

import java.sql.DriverManager;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private FoodDB foodDB; 
	private MyModel myModel;
	
	public MyTable() throws Exception {
		//必須要連上，所以沒有例外，把例外責任先往外拋
		foodDB = new FoodDB();
		foodDB.queryData(FoodDB.SQL_QUERY);
		
		myModel = new MyModel();
		setModel(myModel);
		myModel.setColumnIdentifiers(foodDB.getHeader());
	}

	public void delRow() {
		myModel.removeRow(getSelectedRow());
		repaint();
	}
	
	private class MyModel extends DefaultTableModel {

		@Override
		public void removeRow(int row) {
			foodDB.delRow(row + 1);
		}

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column > 0;
		}

		@Override
		public Object getValueAt(int row, int column) {
			//row, col => 0-base
			return foodDB.getData(row + 1, column +1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.updateData(row + 1, column + 1, (String)aValue);
		}
		
	}
}
