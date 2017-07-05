package fichiersTexte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LectureFichierTexte {

	public static void main(String[] args) throws IOException {
		System.out.println("veuillez entrer le nom du fichier à lire : ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		int n;
		String ligne;
		BufferedReader entree = new BufferedReader(new FileReader(fileName));
		do{
			ligne=entree.readLine();
			System.out.println(ligne);
			if(ligne!=null)
				System.out.println(ligne);
		}while(ligne!=null);
		entree.close();
		sc.close();
		System.out.println("fin du fichier");
		}
}
