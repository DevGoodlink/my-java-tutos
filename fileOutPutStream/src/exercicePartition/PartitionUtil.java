package exercicePartition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PartitionUtil {
	
public static int getNombreFichiers(String partition){
	File f=new File(partition);
	File[] tabF = f.listFiles();
	int nbD=0;
	if(f.exists()){
		System.out.println("Existe");
		if(f.isFile())
			System.out.println("1");
			for(File fs : tabF){
					nbD+=1;
				}
					return nbD;
	}
	return 0;

}
public static int getNombreDossiers(String partition){
	File f=new File(partition);
	File[] tabF = f.listFiles();
	int nbD=0;
	if(f.exists()){
		System.out.println("Existe");
		if(f.isDirectory())
			System.out.println("1");
			for(File fs : tabF){
				if(fs.isDirectory())
					nbD+=1;
				}
					return nbD;
	}
	return 0;
}
public static int getNombreFichiers(String path, final String extension){
	
	int compteur = 0;
	File file =new File(path);
	File[] tab=file.listFiles();
	for(File element : tab){
		if(element.isFile()){
			String fileName = element.getName();
			String ext = fileName.substring(fileName.lastIndexOf(".")+1);
			if(ext.matches(extension))
				compteur+=1;
		
		
		}
		
	}
	return compteur;
}
public static int getNombreOccurences(String fileName, String word) throws IOException{
//	File file=new File(fileName);
//	BufferedReader br = new BufferedReader(new FileReader(fileName));
//	
//	StringTokenizer stoken = new StringTokenizer(br.readLine(), " ");
//	
	int nbreOccu = 0;
	String motMaj = word.toUpperCase();
	BufferedReader entree;
	try{
		entree = new BufferedReader(new FileReader(fileName));
		while(true){
			String ligneLue = entree.readLine();
			//System.out.println(ligneLue);
			if(ligneLue==null) break;
			StringTokenizer tok = new StringTokenizer(ligneLue, " ");
			while (tok.hasMoreTokens()){
				String token = tok.nextToken().toUpperCase();
				if(token.matches(motMaj)) nbreOccu++;
			}
		}
			
			
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return nbreOccu;
}
}
