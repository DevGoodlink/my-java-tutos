package banque;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteBancaire[] tabcomptes=new CompteBancaire[5];
		PersonnePhysique pp1=new PersonnePhysique( 1, "Alaoui Mohamed", "C939706");
		PersonnePhysique pp2=new PersonnePhysique( 1, "Hassani Hicham", "C939706");
		PersonneMorale pm1 = new PersonneMorale(1, "UPF ", "Université");
		CompteBancaire cb1=new CompteBancaire(1, "Oued Fes", pp1);
		tabcomptes[0]=cb1;
		System.out.println(pp1.toString());
		System.out.println(pp2.toString());
		System.out.println(tabcomptes[0].toString());
		
	}

}
