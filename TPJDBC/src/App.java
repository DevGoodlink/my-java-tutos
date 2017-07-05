import java.sql.*;

public class App {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ecole","root","root");
			
			PreparedStatement ps=conn.prepareStatement
					("select * from etudiant where id=?");
			
			
			ps.setInt(1, 3);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++)
					System.out.print(rsmd.getColumnName(i)+"\t");
			
				
			
			
			
			System.out.println();
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
