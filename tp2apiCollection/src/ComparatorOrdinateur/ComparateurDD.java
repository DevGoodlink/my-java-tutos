package ComparatorOrdinateur;

import java.util.Comparator;

public class ComparateurDD implements Comparator<Ordinateur>{
	@Override
	public int compare(Ordinateur o1,Ordinateur o2){
		if(o1.getDd()>o2.getDd()) return 1;
		if (o1.getDd()<o2.getDd()) return -1;
		return 0;
	}
}