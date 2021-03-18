package vue;

import javax.swing.table.AbstractTableModel;

import model.Etablissement;

public class TableauStat1 extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private final String[] entetes = { "", "NO2", "PM10", "PM25" };	
	private final Etablissement[] etabs;
	private final int annee;
	public TableauStat1(Etablissement[] contents, int annee) {
		etabs = contents;
		this.annee = annee;
		entetes[0]=String.valueOf(annee);
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
		return 6;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0){
			switch (rowIndex) {

			case 0:
				// Identifiant
				return "Identifiant";

			case 1:
				// Nom
				return "Nom";

			case 2:
				// Ville
				return "Ville";

			case 3:
				// Département
				return "Département";

			case 4:
				// PM25
				return "Taux";

			default:
				throw new IllegalArgumentException();
			}
		}else {
			switch (rowIndex) {

			case 0:
				// Identifiant
				return etabs[columnIndex-1].getIdentifiant();

			case 1:
				// Nom
				return etabs[columnIndex-1].getNomEtablissement();

			case 2:
				// Ville
				return etabs[columnIndex-1].getLieu().getVille();

			case 3:
				// Département
				return etabs[columnIndex-1].getLieu().getDepartement();

			case 4:
				// PM25
				 switch(columnIndex-1) {
	                case 0:
	                    return etabs[columnIndex-1].getPollutionNO2(annee);
	                    
	                case 1:
	                    return etabs[columnIndex-1].getPollutionPM10(annee);
	                    
	                case 2:
	                    return etabs[columnIndex-1].getPollutionPM25(annee);

	                }
			case 5:
                double x=48.853;
                double y=2.35;
                double latitude =etabs[columnIndex-1].getCoordonnees().getLatitude();
                double longitude =etabs[columnIndex-1].getCoordonnees().getLongitude();
                return Math.sqrt((latitude-x)*(latitude-x)+(longitude-y)*(longitude-y));

			default:
				throw new IllegalArgumentException();
			}
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
}
