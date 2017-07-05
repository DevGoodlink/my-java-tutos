package tpthread2;

public class Ecrit implements Runnable {
	private String texte;
	private int nb;
	private long attente;

	public Ecrit(String texte, int nb, long attente) {
		this.texte = texte;
		this.nb = nb;
		this.attente = attente;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < nb; i++) {
				System.out.println(texte);
				Thread.sleep(attente);
			}
		} catch (InterruptedException iE) {
			iE.printStackTrace();
		}

	}

}
