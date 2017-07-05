package tpThread;

public class Thread3 extends Thread {

	public void run(){
		try{
			for(int i=0;i<15;i++)
				System.out.println("*");
			Thread.sleep(5);
		}catch(InterruptedException iE){
			iE.printStackTrace();
		}
		
	}

}
