package fichiersBinaire;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;

public class EcritureFichierBinaire {

	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		
		String nomFich;
		int n;
		System.out.println("Veuillez entrer le nom du fichier à créer : nom_fichier.extension");
		
		nomFich = sc.next();
		DataOutputStream sortie= new DataOutputStream(new FileOutputStream(nomFich));
		
		do{
			System.out.println("donner un entier : ");
			n=sc.nextInt();
			if(n!=0)
				sortie.writeInt(n);
		}while(n!=0);
		sortie.close();
		System.out.println("****Fin de la création du fichier*****");

	}

}
