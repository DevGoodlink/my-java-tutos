package ThreadSynchronised;

public class Compte {
	private int solde = 0;
	
	public Compte(){
		
	}

	public synchronized void ajouter(int somme) {
		solde += somme;
		System.out.println(" ajoute " + somme);
	}

	public synchronized void retirer(int somme) {
		solde -= somme;
		System.out.println(" retire " + somme);
	}

//	public void operationNulle(int somme) {
//		solde += somme;
//		System.out.println(" ajoute " + somme);
//		solde -= somme;
//		System.out.println(" retire " + somme);
//	}
	public synchronized void operationNulle(int somme) {
		solde += somme;
		System.out.println(" ajoute " + somme);
		solde -= somme;
		System.out.println(" retire " + somme);
	}
	public synchronized int getSolde() {
		return solde;
	}
	//
	// public void setSolde(int solde) {
	// this.solde = solde;
	// }
}
