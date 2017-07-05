package CompareToPoint;

import java.util.Collections;
import java.util.LinkedList;

public class PointMainProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p=new Point(1,2);
		Point p1=new Point(2,5);
		Point p2=new Point(1,4);
		System.out.println("Le point p : "+p);
		System.out.println("Le point p1 : "+p1);
		System.out.println("Le point p2 : "+p2);
		System.out.println("Comparaison p à p1 =>  "+p.compareTo(p1));
		
		LinkedList<Point> l= new LinkedList<Point>();
		l.add(p1);l.add(p);l.add(p2);
		
		Collections.sort(l);
		System.out.println(l.toString());
		
		Point pMax1=Collections.max(l);
		System.out.println("Max suivant compareTo : ");
		System.out.println(pMax1.toString());
		
		
		

	}

}
