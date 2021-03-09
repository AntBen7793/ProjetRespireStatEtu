package model;

public class Lieu {
	private String codePostal;
	private String departement;
	private String ville;
	
	public Lieu(String cp, String dep, String vil){
		codePostal = cp;
		departement = dep;
		ville = vil;
	}
	
	public String getCodePostal() {
		return codePostal;
	}

	public String getDepartement() {
		return departement;
	}

	public String getVille() {
		return ville;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lieu other = (Lieu) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

}
