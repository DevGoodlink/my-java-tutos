package classeFile;

import java.io.File;
import java.util.Scanner;

public class ManipulationFileDirectory {
public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	System.out.println("Entrer le nom du fichier � supprimer ");
	String fileName;
	fileName = sc.next();
	File f= new File(fileName);
	if(f.delete())
		System.out.println("Fichier supprim� avec succ�s");
	else
		System.out.println("suppression �chou�e");
	
	System.out.println("Suppression d'un dossier : \n entrer le nom d'un dossier :");
	fileName=sc.next();
	f=new File(fileName);
	if(f.delete())
		System.out.println("Dossier supprim� avec succ�s ");
	else
	System.out.println("suppression �chou�e");
	
}
}
