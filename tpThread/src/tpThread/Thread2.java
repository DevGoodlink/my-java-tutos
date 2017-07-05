package tpThread;

public class Thread2 extends Thread {

	public void run(){
		try{
			for(int i=0;i<10;i++)
				System.out.println("@");
			Thread.sleep(10);
		}catch(InterruptedException iE){
			iE.printStackTrace();
		}
	}

}
