package serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClassTest {

	public static void main(String[] args) {
		Employee e = new Employee("Hassane",3522.90,2016,05,1);
		Manager boss = new Manager("Ali",1000.6, 2013, 3, 1);
		boss.setSecretary(e);
		Employee [] staff = new Employee[3];
		staff[0]=e;
		staff[1]=boss;
		staff[2]=new Employee("Rachid",4000.8,2016,05,01);
		try{
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("Employee.dat"));
			out.writeObject(staff);
			out.close();
			ObjectInputStream in= new ObjectInputStream(new FileInputStream("Employee.dat"));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();
			
			for(int i=0;i<newStaff.length;i++)
				System.out.println(newStaff[i]);
			
		}catch(Exception ex){
			ex.getStackTrace();
		}
	}

}
