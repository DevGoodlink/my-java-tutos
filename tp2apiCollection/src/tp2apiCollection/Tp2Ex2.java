package tp2apiCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Tp2Ex2 {

	public static void main(String[] args) {
		ArrayList<Integer> lisInt=new ArrayList<Integer>();
		lisInt.add(new Integer(2));lisInt.add(new Integer(6));lisInt.add(new Integer(1));lisInt.add(new Integer(3));
		System.out.println(lisInt.toString());
		Collections.sort(lisInt);//tri la liste lisInt
		System.out.println(lisInt.toString());
		Collections.reverse(lisInt);
		System.out.println(lisInt.toString());
		System.out.println(Collections.max(lisInt));
		System.out.println(Collections.min(lisInt));
		
		
		
		

	}

}
