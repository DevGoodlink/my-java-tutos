package tp3;

public class Etudiant {
	private int num;
	private String nom;
	private String prenomEtu;
	private String adresse;
	private String tel;
	private String organisation;
	private String ville;
	private Filiere filiere;

	public Etudiant(int num, String nom, String prenomEtu, String adresse, String tel, String organisation,
			String ville, Filiere f) {
		this.num = num;
		this.nom = nom;
		this.prenomEtu = prenomEtu;
		this.adresse = adresse;
		this.tel = tel;
		this.organisation = organisation;
		this.ville = ville;
		this.filiere = f;
	}

	public Etudiant() {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenomEtu() {
		return prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
	public String toString(){
		return this.num+" "+this.nom+" "+this.prenomEtu;
	}
}
