package TDS;

import java.util.ArrayList;
import java.util.Scanner;

public class DECIMAL_BINARY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int quotient, decimalNbr;
		int i=0;
		
		System.out.println("Entrer un entier");
		Scanner sc = new Scanner(System.in);
		decimalNbr = sc.nextInt();
		
		quotient=decimalNbr;
		
		ArrayList valBinaire = new ArrayList();
		
		while (quotient!=0)
		{
			valBinaire.add(i++,quotient % 2);
			quotient=quotient/2;
		}
		System.out.println("valeur de " + decimalNbr + " est égale à :");
		int j=valBinaire.size();
		//System.out.println(valBinaire);		
		while (j!=0){
			System.out.print(valBinaire.get(j-1));
			j--;
		}
			sc.close();
		
	}

}
