package controleur;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.*;

import model.Etablissement;


public class ConvertCSV {
	public static ArrayList<Etablissement> listeEtab = new ArrayList<Etablissement>();
	public static ArrayList<String> listeVilles = new ArrayList<String>();
	public static ArrayList<String> listeDepartements = new ArrayList<String>();

	public static void lire(String fileName) {
	     try {
			CSVReader reader = new CSVReader(new FileReader(fileName));
			
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				// nextLine[] is an array of values from the line
				for(int i=0; i<nextLine.length;i++)
					System.out.print(nextLine[i]+ " ");
				System.out.println();
			}
			reader.close();
	     } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void chargerEtablissements(String fileName) {
		Etablissement et;
	     try {
			CSVReader reader = new CSVReader(new FileReader(fileName));
			String[] nextLine;
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
				// nextLine[] is an array of values from the line
				et = new Etablissement(nextLine);
				
				if(!listeVilles.contains(et.getLieu().getVille())) {
					listeVilles.add(et.getLieu().getVille());
				}
				if(!listeDepartements.contains(et.getLieu().getDepartement())) {
					listeDepartements.add(et.getLieu().getDepartement());
				}

				listeEtab.add(et);
			}
			
			reader.close();
	     } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
