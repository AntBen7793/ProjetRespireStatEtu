package vue;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import controleur.ConvertCSV;

public class TableauStat3 extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private final String[] entetes = { "Departement", "NO2", "PM10", "PM25" };	
	private final HashMap<String, Double> moyenneDepartementsNO2;
	private final HashMap<String, Double> moyenneDepartementsPM10;
	private final HashMap<String, Double> moyenneDepartementsPM25;
	
	public TableauStat3(HashMap<String, Double> moyenneDepartementsNO2, HashMap<String, Double> moyenneDepartementsPM10, HashMap<String, Double> moyenneDepartementsPM25) {
		this.moyenneDepartementsNO2 = moyenneDepartementsNO2;
		this.moyenneDepartementsPM10 = moyenneDepartementsPM10;
		this.moyenneDepartementsPM25 = moyenneDepartementsPM25;
	}
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return ConvertCSV.listeDepartements.size();
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0){
			switch (rowIndex) {
		case 0:
			return ConvertCSV.listeDepartements.get(rowIndex);
		default:
			throw new IllegalArgumentException();
		}
		}else {
			switch (rowIndex) {
		case 0:
			switch(columnIndex-1) {
		case 0:
			return moyenneDepartementsNO2.get(ConvertCSV.listeDepartements.get(rowIndex));

		case 1:
			return moyenneDepartementsPM10.get(ConvertCSV.listeDepartements.get(rowIndex));

		case 2:
			return moyenneDepartementsPM25.get(ConvertCSV.listeDepartements.get(rowIndex));

		}
			default:
				throw new IllegalArgumentException();
	}
}
}
}