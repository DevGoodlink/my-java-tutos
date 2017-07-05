package tp4.BusinessLogicLayer;

public class Etudiant {
private int idEtu;
private String nom,ville;
private Filiere filiere;



public Etudiant(int idEtu, String nom, String ville, Filiere filiere) {
	this.idEtu = idEtu;
	this.nom = nom;
	this.ville = ville;
	this.filiere = filiere;
}
public Etudiant(){
	
}
public int getIdEtu() {
	return idEtu;
}
public void setIdEtu(int idEtu) {
	this.idEtu = idEtu;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
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
}
