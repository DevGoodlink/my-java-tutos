package ComparatorOrdinateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainComparatorOrdinateur {

	public static void main(String [] args){
		ArrayList<Ordinateur> aL = new ArrayList<Ordinateur>();
		
		aL.add(new Ordinateur(1, 500,1024));
		aL.add(new Ordinateur(2,1000,8000));
		aL.add(new Ordinateur(3,750,1024));
		
		ComparateurRam cRAM = new ComparateurRam();
		Collections.sort(aL,cRAM);//Collections.reverse pour inverser la liste et shuffle pour mélanger aléatoirement la liste
		System.out.println("  " + aL.toString());
		
		
		ComparateurDD cDd = new ComparateurDD();
		Collections.sort(aL,cDd);
		System.out.println("  " + aL.toString());
		
		Collections.shuffle(aL);
		System.out.println(aL.toString());
		
		Collections.sort(aL, new Comparator<Ordinateur>(){
			@Override
			public int compare(Ordinateur o1,Ordinateur o2){
				if (o1.getDd()>o2.getDd()) return 1;
				if (o1.getDd()<o2.getDd()) return -1;
				return 0;
			}
		});
		System.out.println(" "+aL.toString());
		
		
	}
}
