package PackConcept;

public class Roman extends Livre {

	//Static Attributes
	public static final int NEANT=0;
	public static final int GONCOURT = 1;
	public static final int MEDICIS = 2;
	public static final int INTERALLITE = 3;
	
	//Attributes
	private int prixLitteraire;
	
	//Constructors
	public Roman() {
		
	}

	public Roman(int NumEnr, String titre, String auteur, int nbPages,int prixLitteraie) {
		super(NumEnr,titre,auteur, nbPages);
		this.prixLitteraire=prixLitteraie;
		
	}

	//Getters
	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	//Setters
	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}
	
	
	//toString Method
	@Override
	public String toString() {
		String chain= super.toString();
		if(this.prixLitteraire==0) chain=chain+ ", Prix Litteraire: NEANT";
		if(this.prixLitteraire==1) chain=chain+ ", Prix Litteraire: GONCOURT";
		if(this.prixLitteraire==2) chain=chain+ ", Prix Litteraire: MEDICIS";
		if(this.prixLitteraire==3) chain=chain+ ", Prix Litteraire: INTERALLITE";
		
		return chain;
	}

}
