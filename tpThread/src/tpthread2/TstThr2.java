package tpthread2;

public class TstThr2 {
public static void main(String[]args){
	Runnable e1=new Ecrit("Bonjour", 10, 5);
	Runnable e2=new Ecrit("Comment", 15, 10);
	Runnable e3=new Ecrit("ça va?", 10, 5);
	Thread t1 = new Thread(e1);
	Thread t2 = new Thread(e2);
	Thread t3 = new Thread(e3);
	
	t1.start();
	t2.start();
	t3.start();
}
}
