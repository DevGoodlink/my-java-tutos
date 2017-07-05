package tp3.persistenceLayer;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionMySQL {
	private static Connection con=null;
	// déconseillé
//	 private static String driver="com.mysql.jdbc.Driver";
//	 private static String url="jdbc:mysql://localhost:3306/ecole";
//	 private static String user="root";
//	 private static String passwd="root";

	public static Connection getConnection() {
		// if(con==null){
		// try{
		// Class.forName(driver);
		// con=DriverManager.getConnection(url,user,passwd);
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		// }
		// return con;
		if (con != null)
			con=null;
			try {
				Properties props = new Properties();
				FileInputStream in = new FileInputStream("res/databaseInfo.properties");
				props.load(in);
				in.close();
				String driver = props.getProperty("jdbc.driver");
				String url = props.getProperty("jdbc.url");
				String user = props.getProperty("jdbc.user");
				String passwd = props.getProperty("jdbc.passwd");
				System.setProperty("jdbc.driver", driver);
				con = DriverManager.getConnection(url, user, passwd);
				//DriverManager.
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return con;
	}
}
