package fichiersTexte;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.bind.helpers.PrintConversionEventImpl;

public class EcritureFichierTexte {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le nom du fichier à créer");
		String fileName = sc.next();
		int n;
		PrintWriter sortie = new PrintWriter(new FileWriter(fileName));
		do{
			System.out.println("Entrer un entier : ");
			n=sc.nextInt();
			if(n!=0)
				sortie.println(n + " a pour carré "+ n*n);
		}while(n!=0);
		sortie.close();
		System.out.println("** fin d'écriture **");

	}

}
