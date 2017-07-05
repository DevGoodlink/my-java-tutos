package ds15202015;

public class ConversionUtil {
	public static String decimalVersBinaire(int chiffreDecimal) {
		
		int quotient = chiffreDecimal;
		String valBinaire = "";

		while (quotient != 0) {
			valBinaire = valBinaire + (quotient % 2);
			quotient = quotient / 2;
		}
		
		int j=valBinaire.length();
		String valBinaireInverse="";
		
		while (j!=0){
			valBinaireInverse = valBinaireInverse+valBinaire.charAt(j-1);
			j--;
		}
		return valBinaireInverse;
	}
	public static int BinaireVersdecimal(Boolean[] chiffreBinaire){
		
		return 0;
	}
	
	
}
