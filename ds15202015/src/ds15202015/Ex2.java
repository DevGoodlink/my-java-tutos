package ds15202015;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Entrer un décimal");
		int a = new Scanner(System.in).nextInt();
		System.out.println("La valeur binaire de "+ a +" est : "+ConversionUtil.decimalVersBinaire(a));
		
		
	}

}
