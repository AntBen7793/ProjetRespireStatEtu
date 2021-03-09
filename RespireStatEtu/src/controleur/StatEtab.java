package controleur;

import java.util.ArrayList;

import model.Etablissement;

/**
 * Calculs statistiques sur les données de pollution des 
 * polluants N02, PM10 et PM25
 * @author Flavie Tonon
 *
 */
public class StatEtab {

	/**
	 * Calcule la moyenne du polluant N02 pour un département donné
	 * @param l La liste des établissements
	 * @param dpt Le nom du département
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantNO2Dpt(ArrayList<Etablissement> l, String dpt, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getDepartement().equals(dpt)) {
				moy+=e.getPollutionNO2(annee);
			}
		}
		return moy/l.size();
	}

	/**
	 * Calcule la moyenne du polluant PM10 pour un département donné
	 * @param l La liste des établissements
	 * @param dpt Le nom du département
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantPM10Dpt(ArrayList<Etablissement> l, String dpt, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getDepartement().equals(dpt)) {
				moy+=e.getPollutionPM10(annee);
			}
		}
		return moy/l.size();
	}

	/**
	 * Calcule la moyenne du polluant PM25 pour un département donné
	 * @param l La liste des établissements
	 * @param dpt Le nom du département
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantPM25Dpt(ArrayList<Etablissement> l, String dpt, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getDepartement().equals(dpt)) {
				moy+=e.getPollutionPM25(annee);
			}
		}
		return moy/l.size();
	}
	

	/**
	 * Calcule la moyenne du polluant N02 pour une ville donnée
	 * @param l La liste des établissements
	 * @param ville Le nom de la ville
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantNO2Ville(ArrayList<Etablissement> l, String ville, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getVille().equals(ville)) {
				moy+=e.getPollutionNO2(annee);
			}
		}
		return moy/l.size();
	}

	/**
	 * Calcule la moyenne du polluant PM10 pour une ville donnée
	 * @param l La liste des établissements
	 * @param ville Le nom de la ville
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantPM10Ville(ArrayList<Etablissement> l, String ville, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getVille().equals(ville)) {
				moy+=e.getPollutionPM10(annee);
			}
		}
		return moy/l.size();
	}
	
	/**
	 * Calcule la moyenne du polluant PM25 pour une ville donnée
	 * @param l La liste des établissements
	 * @param ville Le nom de la ville
	 * @param annee L'année de récolte des données demandée
	 * @return la moyenne de pollution
	 * Flavie Tonon
	 */
	public static double getMoyennePolluantPM25Ville(ArrayList<Etablissement> l, String ville, int annee) {
		double moy = 0;
		for(Etablissement e : l) {
			if(e.getLieu().getVille().equals(ville)) {
				moy+=e.getPollutionPM25(annee);
			}
		}
		return moy/l.size();
	}
	
	/**
	 * Trouve l'établissement le plus polluant au NO2 sur une année
	 * @param l La liste des établissements
	 * @param annee L'année de récolte des données demandée
	 * @return L'établissement le plus polluant au N02
	 * Flavie Tonon
	 */
	public static Etablissement getPlusPolluantNO2(ArrayList<Etablissement> l, int annee) {
		Etablissement plus = null;
		double pollution=0;
		for(Etablissement e : l) {
			if(pollution<e.getPollutionNO2(annee)) {
				plus = e;
			}
		}
		return plus;
	}
	/**
	 * Trouve l'établissement le plus polluant au PM10 sur une année
	 * @param l La liste des établissements
	 * @param annee L'année de récolte des données demandée
	 * @return L'établissement le plus polluant au PM10
	 * Flavie Tonon
	 */
	public static Etablissement getPlusPolluantPM10(ArrayList<Etablissement> l, int annee) {
		Etablissement plus = null;
		double pollution=0;
		for(Etablissement e : l) {
			if(pollution<e.getPollutionPM10(annee)) {
				plus = e;
			}
		}
		return plus;
	}
	/**
	 * Trouve l'établissement le plus polluant au PM25 sur une année
	 * @param l La liste des établissements
	 * @param annee L'année de récolte des données demandée
	 * @return L'établissement le plus polluant au PM25
	 * Flavie Tonon
	 */
	public static Etablissement getPlusPolluantPM25(ArrayList<Etablissement> l, int annee) {
		Etablissement plus = null;
		double pollution=0;
		for(Etablissement e : l) {
			if(pollution<e.getPollutionPM25(annee)) {
				plus = e;
			}
		}
		return plus;
	}
}
