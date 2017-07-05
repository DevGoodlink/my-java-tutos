package serialisation;

public class Manager extends Employee {

	private Employee secretary;

	public Manager(String name, Double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		this.secretary = null;
	}

public void setSecretary(Employee s){
	secretary = s;
}
public String toString(){
	return super.toString() + " [ secretary = "+secretary+" ]";
}
}
