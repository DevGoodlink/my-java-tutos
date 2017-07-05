package PackConcept;

public class Livre extends Document {

	//Attributes
	private String auteur;
	private int nbPages;
	
	//Constructors
	public Livre(){	
		
	}
	
	public Livre(int numEnr, String titre, String auteur, int nbPages){
		super(numEnr,titre);
		this.auteur=auteur;
		this.nbPages=nbPages;
		
	}
	
	//Getters
	public String getAuteur() {
		return auteur;
	}

	public int getNbPages() {
		return nbPages;
	}

	//Setters
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	

	//toString Method
	@Override
	public String toString() {
		return "Livre [ getNumEnr()=" + getNumEnr() + ", getTitre()=" + getTitre() +",auteur=" + auteur + ", nbPages=" + nbPages + "]";
	}

	
}
