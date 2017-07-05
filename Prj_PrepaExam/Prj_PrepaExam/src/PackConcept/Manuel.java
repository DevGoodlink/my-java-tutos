package PackConcept;

public class Manuel extends Document {

	//Attribute
	private int niveauScolaire;
	
	//Constructors
	public Manuel() {
	
	}

	public Manuel(int numEnr, String titre, int niveauScolaire) {
		
		super(numEnr, titre);
		this.niveauScolaire=niveauScolaire;
	
	}

	//Getters
	public int getNiveauScolaire() {
		return niveauScolaire;
	}

	//Setters
	public void setNiveauScolaire(int niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

	//toString Method
	@Override
	public String toString() {
			return super.toString()+ ",, [Manuel: Niveau Scolaire =" + this.niveauScolaire + "]";
	}
}
