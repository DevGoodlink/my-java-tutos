package fichiersBinaire;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class lectureFichierBinaire {

	public static void main(String[] args)throws IOException {
		Scanner sc = new  Scanner(System.in);
		String nomfich;
		int n=0;
		System.out.println("Donner le nom du fichier à lister : ");
		nomfich=sc.next();
		DataInputStream entree= new DataInputStream(new FileInputStream(nomfich));
		System.out.print("Les valeurs nues dans le fichier " + nomfich + " -> ");
		boolean eof = false;
		while(!eof){
			try{
				n=entree.readInt();
			}catch(EOFException e)
			{
				eof=true;
			}
			if(!eof)
				System.out.print(n);
			}
		entree.close();
		System.out.println();
		System.out.println("fin de lecture du fichier "+ nomfich);
	}
}


