package PackConcept;

public class Dictionnaire extends Document {

	//Static Attributes
	public static final int ARABE=1;
	public static final int FRANCAIS=2;
	public static final int ANGLAIS=3;
	
	//Attribute
	private int langue;
	
	//Constructors
	public Dictionnaire() {
		// TODO Auto-generated constructor stub
	}

	public Dictionnaire(int numEnr, String titre, int langue) {
		
		super(numEnr, titre);
		this.langue=langue;
	}

	//Getters
	public int getLangue() {
		return langue;
	}

	//Setters
	public void setLangue(int langue) {
		this.langue = langue;
	}

	//toString Method
	@Override
	public String toString() {
		
		String chain= super.toString();
		if(this.langue==1) chain= chain+", Langue: ARABE";
		if(this.langue==2) chain= chain+", Langue: FRANCAIS";
		if(this.langue==3) chain= chain+", Langue: ANGLAIS";		
		
		return chain;
	}
	
}
