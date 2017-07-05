package tp3;

public class Filiere {
private int idFil;
private String intitule;

public Filiere(int idFil, String intitule) {
	this.idFil = idFil;
	this.intitule = intitule;
}
public Filiere() {

}
public int getIdFil() {
	return idFil;
}
public void setIdFil(int idFil) {
	this.idFil = idFil;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public String toString(){
	return this.idFil+" "+this.intitule;
}
}
