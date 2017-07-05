package Compte;

public class mainClas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte c = new Compte();
		for(int i= 0; i<20;i++){
			Operation o=new Operation("Thread "+i, c);
			o.start();
		}
	}

}
