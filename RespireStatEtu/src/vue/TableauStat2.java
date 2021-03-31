package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		
		//NO2
		ArrayList<String> moyvilNO2=new ArrayList<String>();
		for(Map.Entry<String, Double> map:moyenneVillesNO2.entrySet())
		{
			moyvilNO2.add(map.getKey());
		}
		for(int i=0;i<moyvilNO2.size()-1;i++)
		{
			for(int j=0;j<moyvilNO2.size()-1-i;j++)
			{
				//if(moyvilNO2.get(j)>moyvilNO2.get(j+1))
				if(moyenneVillesNO2.get(moyvilNO2.get(j))<moyenneVillesNO2.get(moyvilNO2.get(j+1)))
				{
					String temp=moyvilNO2.get(j);
					moyvilNO2.set(j,moyvilNO2.get(j+1));
					moyvilNO2.set(j+1,temp);
				}
			}
		}
		ConvertCSV.listeVillesNO2=moyvilNO2;
		
		//PM10
		ArrayList<String> moyvilPM10=new ArrayList<String>();
		for(Map.Entry<String, Double> map:moyenneVillesPM10.entrySet())
		{
			moyvilPM10.add(map.getKey());
		}
		for(int i=0;i<moyvilPM10.size()-1;i++)
		{
			for(int j=0;j<moyvilPM10.size()-1-i;j++)
			{
				if(moyenneVillesPM10.get(moyvilPM10.get(j))<moyenneVillesPM10.get(moyvilPM10.get(j+1)))
				{
					String temp=moyvilPM10.get(j);
					moyvilPM10.set(j,moyvilPM10.get(j+1));
					moyvilPM10.set(j+1,temp);
				}
			}
		}
		ConvertCSV.listeVillesPM10=moyvilPM10;
		
		//PM10
		ArrayList<String> moyvilPM25=new ArrayList<String>();
		for(Map.Entry<String, Double> map:moyenneVillesPM25.entrySet())
		{
			moyvilPM25.add(map.getKey());
		}
		for(int i=0;i<moyvilPM25.size()-1;i++)
		{
			for(int j=0;j<moyvilPM25.size()-1-i;j++)
			{
				if(moyenneVillesPM25.get(moyvilPM25.get(j))<moyenneVillesPM25.get(moyvilPM25.get(j+1)))
				{
					String temp=moyvilPM25.get(j);
					moyvilPM25.set(j,moyvilPM25.get(j+1));
					moyvilPM25.set(j+1,temp);
				}
			}
		}
		ConvertCSV.listeVillesPM25=moyvilPM25;
		
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
				
				return ConvertCSV.listeVillesNO2.get(rowIndex);
			case 1:
				return moyenneVillesNO2.get(ConvertCSV.listeVillesNO2.get(rowIndex));

			case 2:
				return moyenneVillesPM10.get(ConvertCSV.listeVillesNO2.get(rowIndex));

			case 3:
				return moyenneVillesPM25.get(ConvertCSV.listeVillesNO2.get(rowIndex));

			default:
				throw new IllegalArgumentException();
			}
					
		

	}
	
}
