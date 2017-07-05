package projetCanonPokemon;

public class ThreadTableau extends Thread {
	//public static double[] tab = new double[3];
	public static boolean interuption = false;

	public void run() {
		while (interuption == false) {
			for(int j=0;j<=2;j++){
				int i=(int)(Math.random()*100);
				MainTest.tab[j] = (i>0)?i:-i;
				
			}
			System.out.println(MainTest.tab[0]+" - "+MainTest.tab[1]+" - "+MainTest.tab[2]);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
