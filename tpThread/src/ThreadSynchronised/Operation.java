package ThreadSynchronised;

public class Operation extends Thread {
	private Compte compte;
	
	public Operation(String nom,Compte c){
		super(nom);
		this.compte=c;
	}
	public void run(){
		while(true){
			int i=(int)(Math.random()*10000);
			String nom = getName();
			System.out.println(nom);
			compte.operationNulle(i);
			int solde=compte.getSolde();
			System.out.println(nom);
			if(solde!=0){
				System.out.println(nom + " : *** solde "+ solde);
				System.exit(1);
			}
		}
	}

}
