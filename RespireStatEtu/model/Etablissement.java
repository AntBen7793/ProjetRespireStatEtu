package model;

import java.util.HashMap;
import java.util.Map;

public class Etablissement {
	private String identifiant;
	private Lieu lieu;
	private Type type;
	private CoordGPS coordonnees;
	private String nomEtablissement;
	private Map<Integer, Double> polluStatNO2;
	private Map<Integer, Double> polluStatPM10;
	private Map<Integer, Double> polluStatPM25;
	
	public Etablissement(String id, Lieu l, Type t, String nom, String geometry) {
		identifiant = id;
		lieu = l;
		type = t;
		nomEtablissement = nom;
		coordonnees = new CoordGPS(geometry);
		polluStatNO2 = new HashMap<Integer, Double>();
		polluStatPM10 = new HashMap<Integer, Double>();
		polluStatPM25 = new HashMap<Integer, Double>();
	}
	
	
	//0 : ID
	//1 : nom
	//2 : departement
	//3 : ville
	//4 : CP
	//5 : type
	//6 : NO2_2012 à 11 : NO2_2017
	//12 : PM10_2012 à 17 : PM10_2017
	//18 : PM25_2012 à 23 : PM25_2017
	//24 : geometry
	public Etablissement(String[] line) {
		this(line[0], new Lieu(line[4],line[2],line[3]), null, line[1], line[24]);

		if(line[5].equals("secondaire")) {
			type = Type.SECONDAIRE;
		}else {
			type = Type.PRIMAIRE;
		}
		
		for(int i = 0; i<=5; i++) {
			polluStatNO2.put(2012+i, Double.parseDouble(line[6+i]));
			polluStatPM10.put(2012+i, Double.parseDouble(line[12+i]));
			polluStatPM25.put(2012+i, Double.parseDouble(line[18+i]));
		}
		
	}

	
	public double getPollutionNO2(int annee) {
		return polluStatNO2.get(annee);
	}
	
	public double getPollutionPM10(int annee) {
		return polluStatPM10.get(annee);
	}

	
	public double getPollutionPM25(int annee) {
		return polluStatPM25.get(annee);
	}


	public String getIdentifiant() {
		return identifiant;
	}


	public Lieu getLieu() {
		return lieu;
	}


	public Type getType() {
		return type;
	}


	public CoordGPS getCoordonnees() {
		return coordonnees;
	}


	public String getNomEtablissement() {
		return nomEtablissement;
	}


	public Map<Integer, Double> getPolluStatNO2() {
		return polluStatNO2;
	}


	public Map<Integer, Double> getPolluStatPM10() {
		return polluStatPM10;
	}


	public Map<Integer, Double> getPolluStatPM25() {
		return polluStatPM25;
	}


	@Override
	public String toString() {
		return "Etablissement [identifiant=" + identifiant + ", lieu=" + lieu + ", type=" + type + ", coordonnees="
				+ coordonnees + ", nomEtablissement=" + nomEtablissement + "]\n";
	}
	
	
	
}
