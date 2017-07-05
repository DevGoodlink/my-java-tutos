package banque;

public class PersonneMorale extends Personne {
	String activite;

	public PersonneMorale(int idBancaire, String nomComplet, String activite) {
		super(idBancaire, nomComplet);
		this.activite = activite;
	}

	@Override
	public String toString() {
		return "PersonneMorale [activite=" + activite + ", idBancaire=" + idBancaire + ", nomComplet=" + nomComplet
				+ "]";
	}
	

}
