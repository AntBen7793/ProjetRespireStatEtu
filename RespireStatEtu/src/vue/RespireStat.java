package vue;


import javax.swing.SwingUtilities;

import controleur.ConvertCSV;
public class RespireStat {
	public static void main(String[] args) {		
		//ConvertCSV.chargerEtablissements("ecoles-creches-idf.csv");
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				FenetrePrincipale fenetre = new FenetrePrincipale();
				fenetre.setVisible(true);
			}
		});
	}
}
