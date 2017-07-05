package PackConcept;

public abstract class Document {

	
	//Attributes
	private int numEnr ;
	private String titre;
	
	//Constructors
	public Document(){
		
	}
	
	public Document(int numEnr, String titre){
		this.numEnr=numEnr;
		this.titre=titre;
	}
	
	//Getters
	public int getNumEnr(){
		
		return this.numEnr;
	}
	
	public String getTitre(){
		
		return this.titre;
	}
	
	//Setters
	public void setNumEnr(int numEnr){
		
		this.numEnr=numEnr;
	}
	
	public void setTitre(String titre){
		
		this.titre=titre;
	}
	
	//toString Method
	@Override
	public String toString(){
		return "[Document: Numero Enregistrement = "+ this.numEnr + " Titre = " + this.titre +"]";
	}
	
	
}

