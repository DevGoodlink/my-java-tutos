package PackConcept;

public class Revue extends Document {

	//Attributes
	private int mois;
	private int annee;
	
	//Constructors
	public Revue(){
		
	}
	
	public Revue(int numEnr, String titre, int mois , int annee){
		
		super(numEnr, titre);
		this.mois=mois;
		this.annee=annee;
		
	}

	//Getters
	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	//Setters
	public void setMois(int mois) {
		this.mois = mois;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	//toString Method
	@Override
	public String toString() {
		return  super.toString() + "Revue [mois=" + mois + ", annee=" + annee + "]";
	}
	
	
}
