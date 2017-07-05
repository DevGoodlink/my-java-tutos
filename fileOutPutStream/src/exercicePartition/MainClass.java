package exercicePartition;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		//System.out.println("le nombre "+PartitionUtil.getNombreDossiers("test"));
		 
		try {
			System.out.println("Nombre de mot allah dans le fichier Bakkara est "+ PartitionUtil.getNombreOccurences("test/AL BAKARA.txt", "ALLAH"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
