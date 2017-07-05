package exerciceThread;

public class Ecrit extends Thread{
	private String texte;
	private long attente;

	public Ecrit(String texte, long attente) {
		this.texte = texte;
		this.attente = attente;
	}

	@Override
	public void run() {
		try {
			while(true) {
				if(Thread.interrupted())
					return;
				System.out.println(texte);
				Thread.sleep(attente);
				/*
				 * sleep déclenche une exception lorsqu'il s'applique sur un thread dont le drapeau d'interruption est déja positionné à true
				 * donc ce n'est pas la peine d'ajoute le test if (thread.interrupted())
				 * */
			}
		} catch (InterruptedException iE) {
			System.out.println(iE.getMessage());
		}

	}

}
