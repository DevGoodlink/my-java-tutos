package classeFile;

import java.io.File;
import java.util.Scanner;

public class ManipulationFileDirectory {
public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	System.out.println("Entrer le nom du fichier à supprimer ");
	String fileName;
	fileName = sc.next();
	File f= new File(fileName);
	if(f.delete())
		System.out.println("Fichier supprimé avec succés");
	else
		System.out.println("suppression échouée");
	
	System.out.println("Suppression d'un dossier : \n entrer le nom d'un dossier :");
	fileName=sc.next();
	f=new File(fileName);
	if(f.delete())
		System.out.println("Dossier supprimé avec succés ");
	else
	System.out.println("suppression échouée");
	
}
}
