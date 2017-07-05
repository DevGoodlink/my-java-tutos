
public class Tableaux {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t=new int[3];
		t[0]=1;
		t[1]=3;
		t[2]=4;
		lectTableau(t);
		affichTableau(1,5,7);
		System.out.println();
		System.out.println(cherchValeur(5,t));
		System.out.println(ajoutVal(2, 1, t));
		
	}
	public static void lectTableau(int[] args){
		System.out.println("vous avez entrer "+args.length+" Valeurs");
	}
	public static void affichTableau(int...a){
		
		for(int i=0;i<a.length;i++)
			System.out.print("["+a[i]+"]");
	}
	public static float MoyTableau(int...a){
		float moyenne=0;
		int somme=0;
		for(int i=0;i<a.length;i++)
			somme+=a[i];
		moyenne=somme/(a.length-1);
		return moyenne;
	}
	public static boolean cherchValeur(int a,int[] t){
		for(int e:t)
			if(e==a)return true;
		return false;
	}
	public static boolean ajoutVal(int a,int pos,int[] t){
		if (pos<t.length) {
			t[pos]=a;
			return true;
		}
		return false;
	}
}

