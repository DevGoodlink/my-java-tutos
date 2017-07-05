package ComparatorOrdinateur;

import java.util.Comparator;

public class ComparateurRam implements Comparator<Ordinateur> {
	@Override
	public int compare(Ordinateur o1,Ordinateur o2){
		if(o1.getRam()>o2.getRam()) return 1;
		if (o1.getRam()<o2.getRam()) return -1;
		return 0;
	}

}
