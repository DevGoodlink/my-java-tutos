package PackConcept;

import java.util.Arrays;

public class Bibiliotheque {
	
	//Attributes
	private String adresse;
	private int nbrSalles;
	private int nbrDocs;
	private Document[] docs;
	
	//Constructors
	public Bibiliotheque(){
		
		
	}
	
	public Bibiliotheque(int capacite, int nbrSalles, String adresse){
		this.docs= new Document[capacite];
		this.nbrSalles=nbrSalles;
		this.adresse=adresse;
		this.nbrDocs=0;
		
	}

	//Setters
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setNbrSalles(int nbrSalles) {
		this.nbrSalles = nbrSalles;
	}

	public void setNbrDocs(int nbrDocs) {
		this.nbrDocs = nbrDocs;
	}

	public void setDocs(Document[] docs) {
		this.docs = docs;
	}

	//Getters
	public String getAdresse() {
		return adresse;
	}

	public int getNbrSalles() {
		return nbrSalles;
	}

	public int getNbrDocs() {
		return nbrDocs;
	}

	public Document[] getDocs() {
		return docs;
	}
	
	//toString Method
	@Override
	public String toString() {
		String chain="";
		//For Method
		chain="[Bibilotheque : Adresse : "+this.adresse + ", Nombre Salles : " + this.nbrSalles ;
		for(Document doc : docs)
		{
			chain=chain+doc.toString();
		}
		
		chain = chain + "]";
		//Arrays Method
		// chain="[Bibilotheque : Adresse : "+this.adresse + ", Nombre Salles : " + this.nbrSalles +"Documents :" + Arrays.toString(docs) +"]" ;
		
		return chain;
	}
	
	//getAteurs Method
	public String getAuteurs(){
		
		String chain="";
		for(int i=0;i<=nbrDocs;i++)
		{
			if(docs[i] instanceof Livre)
			{
				Livre liv =(Livre)docs[i];
				chain=chain+liv.getAuteur() +" </> ";
			}
			
		}		
		
		return chain;
	}
	
	//Add Method
	public boolean Ajouter(Document doc){
		if(this.nbrDocs<docs.length){
			this.docs[nbrDocs++]=doc;
			return true;
		}
		else 
			return false;
		
	}

	//getDocument Method
	public Document getDocument(int i){
		if((i>=0)&& (i<docs.length))
			return docs[i];
		else
		return null;
	}
	
	//Delete Method
	public boolean supprimer(int pos){
		if((pos>=0) && (pos<docs.length)){
			docs[pos]=null;
			return true;
		}
		else
			return false;
	}
}
