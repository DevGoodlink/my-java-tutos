package tpThread;

public class Thread1 extends Thread {
public void run(){
	try{
		for(int i=0;i<15;i++)
			System.out.println("$");
		Thread.sleep(15);
	}catch(InterruptedException iE){
		iE.printStackTrace();
	}
}
}
