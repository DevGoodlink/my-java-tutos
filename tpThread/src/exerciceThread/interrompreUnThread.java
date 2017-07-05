package exerciceThread;

import java.util.Scanner;

public class interrompreUnThread {

	public static void main(String[] args){
		Thread t1=new Ecrit("Thread 1",  5);
		Thread t2 = new Ecrit("Thread 2",  15);
		Thread t3 = new Ecrit("Thread 3", 10);
		
		t1.start();
		t2.start();
		t3.start();
		
		Scanner sc = new Scanner(System.in);
		sc.next();
		t1.interrupt();
		System.out.println("\n*** Demande d'interruption du premier thread");
		
		sc.next();
		t2.interrupt();
		System.out.println("\n*** Demande d'interruption du deuxième thread");
		
		t3.interrupt();
		System.out.println("\n*** Demande d'interruption du troisième thread");
		
	}
}
