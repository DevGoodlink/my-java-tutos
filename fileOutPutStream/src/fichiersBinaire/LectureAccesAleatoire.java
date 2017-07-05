package fichiersBinaire;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class LectureAccesAleatoire {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String nomfich;
		int n,pos;
		RandomAccessFile entree;
		System.out.println("donnez le nom physique du fichier à consulter");
		nomfich = sc.next();
		entree= new RandomAccessFile(nomfich,"r");
		do{
			System.out.println("position de l'entier recherché : ");
			pos = sc.nextInt();
			if(pos==0)
				break;
			try{
			entree.seek(4*(pos-1));
				
			}catch(EOFException eofExc){
				System.out.println("aucun élément à la position "+pos);
				entree.seek(4);
			}
			
			n=entree.readInt();
			System.out.println("valeur = "+n);
		}while(pos!=0);
		entree.close();
		System.out.println("*** Fin consultation fichier ***");
	}

}
