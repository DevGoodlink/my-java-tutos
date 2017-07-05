package banque;

public class PersonnePhysique extends Personne{
	String cni;

	public PersonnePhysique(int idBancaire, String nomComplet, String cni) {
		super(idBancaire, nomComplet);
		this.cni = cni;
	}
	
	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String toString() {
		return super.toString()+ "cni=" + cni + "]";
	}

	

}
