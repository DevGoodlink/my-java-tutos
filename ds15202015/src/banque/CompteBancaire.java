package banque;

public class CompteBancaire {
	private int numcompte;
	private String addr;
	private Personne p;

	public CompteBancaire(int numcompte, String addr, Personne p) {
		
		this.p = p; //attribution personne
		this.numcompte = numcompte;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "CompteBancaire [numcompte=" + numcompte + ", addr=" + addr + ", personne=" + p + "]";
	}

}
