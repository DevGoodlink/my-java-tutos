package tp3.businessLogicLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tp3.persistenceLayer.ConnectionMySQL;
import tp3.Filiere;

public class FiliereDAO extends DAO<Filiere> {
	private Connection con;
	private PreparedStatement ps;
	private static String findAll = "SELECT * FROM `filiereupf`";
	private static String findById = "SELECT * FROM `filiereupf` where idfiliere=?";
	//private static String findByIntitule = "SELECT * FROM `filiere` where intitule=?";
	private static String create = "INSERT INTO filiereupf(idfiliere,intitule) values(?,?)";
	private static String delete = "DELETE FROM filiereupf WHERE idfiliere=?";
	private static String update = "UPDATE filiereupf SET intitule=? where idfiliere=?";

	public FiliereDAO() {
		con = ConnectionMySQL.getConnection();
	}

	public FiliereDAO(Connection con) {
		this.con = con;
	}

	
	public boolean create(Filiere f) {
		try {
			ps = con.prepareStatement(FiliereDAO.create);
			ps.setInt(1, f.getIdFil());
			ps.setString(2, f.getIntitule());
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.getStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Filiere t) {
		try {
			ps = con.prepareStatement(FiliereDAO.delete);
			ps.setInt(1, t.getIdFil());
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Filiere t) {
		try {
			ps = con.prepareStatement(FiliereDAO.update);
			ps.setInt(2, t.getIdFil());
			ps.setString(1, t.getIntitule());
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.getStackTrace();
			return false;
		}

	}


	public Filiere getById(int id) {
		try {
			ps = con.prepareStatement(FiliereDAO.findById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Filiere filiere = null;
			if (rs.next()) {
				filiere = new Filiere(rs.getInt(0), rs.getString(1));
			}
			return filiere;
		} catch (Exception ex) {
			ex.getStackTrace();
			return null;
		}
	}

	public List<Filiere> getAll() {
		try{
			ps=con.prepareStatement(FiliereDAO.findAll);
			ResultSet rs=ps.executeQuery();
			List<Filiere> lF=new ArrayList<Filiere>();
			while (rs.next()) {
				Filiere f=new Filiere(rs.getInt("idfiliere"),rs.getString("intitule"));
				lF.add(f);
			}
			return lF;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

}
