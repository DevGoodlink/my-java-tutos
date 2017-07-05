package PackExec;

import PackConcept.*;

public class Main {

	public static void main(String[] args) {
		
		
		Document document1=new Roman(10031,". Robinson Crusoe","Daniel Defoe",1750,Roman.GONCOURT);
		Document document2=new Roman(100041, "Fun makers", "auteur2",805, Roman.INTERALLITE);
		Document document3=new Livre(14020, "Livre1", "Auteur1", 450);
		Document document4=new Revue(5402, "Revue1", 5, 1970);
		Document document5=new Dictionnaire(502, "Dictionnaire 1", Dictionnaire.ARABE);
		Document document6=new Manuel(5002, "Manuel 1",10);
		
		
		System.out.println(document1.toString());
		System.out.println(document2.toString());
		System.out.println(document3.toString());
		System.out.println(document4.toString());
		System.out.println(document5.toString());
		System.out.println(document6.toString());
		
		
		
		
		
	}

}
