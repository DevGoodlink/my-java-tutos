package tp3.presentationLayer;

import java.util.*;

import tp3.Etudiant;
import tp3.businessLogicLayer.EtudiantDAO;

public class MainConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EtudiantDAO etudiantDAO = new EtudiantDAO();
//		Etudiant e1=new Etudiant(0,"Smail","Errachidia");
//		etudiantDAO.create(e1);
		
//		Etudiant e2=etudiantDAO.findByNumEtu(30);
//		etudiantDAO.remove(e2);
		
		List<Etudiant> listeEtuAll = etudiantDAO.getAll();
		for(Etudiant e:listeEtuAll)
			System.out.println(e.getNom()+ " "+e.getNum());
//		//Collections.sort(listeEtuAll);
//		System.out.print("id \t\t Nom \t\t Ville\n");
//		for(Etudiant e:listeEtuAll)
//			System.out.println(e.getNum()+" \t\t "+e.getNom()+" \t\t"+e.getVille());
//		System.out.println("-----------Recherche par ville=Errachidia-----------------");
//		List<Etudiant> listeEtuMeknes=etudiantDAO.findByVille("Errachidia");
//		System.out.println("id \t\t Nom \t\t Ville\n");
//		if(!listeEtuMeknes.isEmpty()){
//			for(Etudiant e:listeEtuMeknes)
//				System.out.println(e.getNum()+" \t\t "+e.getNom()+" \t\t"+e.getVille());
//		}else{
//			System.out.println("Aucun enregistrement ne correspond à votre recherche");
//		}
		
	}
}
