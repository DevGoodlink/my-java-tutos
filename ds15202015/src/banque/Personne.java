package banque;

public class Personne {
	int idBancaire;
	String nomComplet;

	public Personne(int idBancaire, String nomComplet) {
		this.idBancaire = idBancaire;
		this.nomComplet = nomComplet;
	}

	
	public String toString() {
		return "Personne [idBancaire = " + idBancaire + ", NomComplet = " + nomComplet + "]";
	}

}
