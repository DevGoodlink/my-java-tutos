package url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class testUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer un url : ");
		try{
			URL url1=new URL(sc.next());
			url1.openStream();
		}catch(Exception e){
			
			System.out.println(e.getClass());
		}	
	}
}
