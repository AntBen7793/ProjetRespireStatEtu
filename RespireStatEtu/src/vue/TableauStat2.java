package vue;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import controleur.ConvertCSV;

public class TableauStat2 extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private final String[] entetes = { "Villes", "NO2", "PM10", "PM25" };	
	private final HashMap<String, Double> moyenneVillesNO2;
	private final HashMap<String, Double> moyenneVillesPM10;
	private final HashMap<String, Double> moyenneVillesPM25;
	
	public TableauStat2(HashMap<String, Double> moyenneVillesNO2, HashMap<String, Double> moyenneVillesPM10, HashMap<String, Double> moyenneVillesPM25) {
		this.moyenneVillesNO2 = moyenneVillesNO2;
		this.moyenneVillesPM10 = moyenneVillesPM10;
		this.moyenneVillesPM25 = moyenneVillesPM25;
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
		return ConvertCSV.listeVilles.size();
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

			switch (columnIndex) {
			case 0:
				return ConvertCSV.listeVilles.get(rowIndex);
			case 1:
				return moyenneVillesNO2.get(ConvertCSV.listeVilles.get(rowIndex));

			case 2:
				return moyenneVillesPM10.get(ConvertCSV.listeVilles.get(rowIndex));

			case 3:
				return moyenneVillesPM25.get(ConvertCSV.listeVilles.get(rowIndex));

			default:
				throw new IllegalArgumentException();
			}
					
		

	}
	
}
