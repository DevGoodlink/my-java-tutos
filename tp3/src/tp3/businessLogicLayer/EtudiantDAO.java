package tp3.businessLogicLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tp3.persistenceLayer.ConnectionMySQL;
import tp3.Etudiant;
import tp3.Filiere;

public class EtudiantDAO extends DAO<Etudiant> {
	private Connection con;
	private PreparedStatement ps;
	private static String findByVille = "SELECT * FROM `etudiantupf` inner join filiereupf on etudiantupf.idfiliere=filiereupf.idfiliere where ville=?";
	private static String findByFiliere = "SELECT * FROM `etudiantupf` inner join filiereupf on etudiantupf.idfiliere=filiereupf.idfiliere where idfiliere=?";
	private static String findByNumEtu = "SELECT * FROM `etudiantupf` inner join filiereupf on etudiantupf.idfiliere=filiereupf.idfiliere where numero=?";
	private static String findAll = "select * from etudiantupf,filiereupf where etudiantupf.idfiliere=filiereupf.idFiliere";
	private static String create = "INSERT INTO etudiantupf(numero,nom,prenom,adresse,tel,organisation,ville,idfiliere) values(?,?,?,?,?,?,?,?)";
	private static String remove = "DELETE FROM etudiantupf where numero=?";
	private static String update = "UPDATE etudiantupf set nom=?, prenom=? ,adresse=?,tel=?,organisation=?,ville=?,idfiliere=? where numero=?";

	public EtudiantDAO() {
		con = ConnectionMySQL.getConnection();
	}

	public EtudiantDAO(Connection con) {// délégation de la création de la
										// connexion au client
		this.con = con;
	}

	public boolean create(Etudiant e) {
		try {
			ps = con.prepareStatement(EtudiantDAO.create);
			ps.setInt(1, e.getNum());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getPrenomEtu());
			ps.setString(4, e.getAdresse());
			ps.setString(5, e.getTel());
			ps.setString(6, e.getOrganisation());
			ps.setString(7, e.getVille());
			ps.setInt(8, e.getFiliere().getIdFil());
			int rowCount = ps.executeUpdate();
			if (rowCount > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean delete(Etudiant e) {
		try {
			ps = con.prepareStatement(EtudiantDAO.remove);
			ps.setInt(1, e.getNum());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean update(Etudiant e) {
		try {
			//e = getById(e1.getNum());
			ps = con.prepareStatement(EtudiantDAO.update);
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenomEtu());
			ps.setString(3, e.getAdresse());
			ps.setString(4, e.getTel());
			ps.setString(5, e.getOrganisation());
			ps.setString(6, e.getVille());
			ps.setInt(7, e.getFiliere().getIdFil());
			ps.setInt(8, e.getNum());
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public Etudiant getById(int id) {
		try {
			ps = con.prepareStatement(EtudiantDAO.findByNumEtu);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Etudiant e = null;
			Filiere fil = null;//new Filiere(rs.getInt("idfiliere"),rs.getString("intitule"));
			if (rs.next()) {
				fil = new Filiere(rs.getInt("idfiliere"), rs.getString("intitule"));
				e = new Etudiant(rs.getInt("numero"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("adresse"), rs.getString("tel"), rs.getString("organisation"),
						rs.getString("ville"), fil);
			}
			return e;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public List<Etudiant> getAll() {
		try {
			ps = con.prepareStatement(EtudiantDAO.findAll);
			ResultSet rs = ps.executeQuery();
			List<Etudiant> listeEtu = new ArrayList<Etudiant>();
			Etudiant e = null;
			while (rs.next()) {
				e = new Etudiant();
				e.setNum(rs.getInt("numero"));
				e.setNom(rs.getString("nom").trim());
				e.setPrenomEtu(rs.getString("prenom").trim());
				e.setAdresse(rs.getString("adresse").trim());
				e.setTel(rs.getString("tel").trim());
				e.setOrganisation(rs.getString("organisation").trim());
				e.setVille(rs.getString("ville").trim());
				e.setFiliere(new Filiere(rs.getInt("idfiliere"), rs.getString("intitule")));
				listeEtu.add(e);
			}
			return listeEtu;
		} catch (SQLException ex) {
			System.out.println("Erreur " + ex.getMessage());
			return null;
		}
	}

	public List<Etudiant> findByFiliere(int idFiliere) {
		try {
			ps = con.prepareStatement(EtudiantDAO.findByFiliere);
			ps.setInt(1, idFiliere);
			ResultSet rs = ps.executeQuery();
			List<Etudiant> listeEtu = new ArrayList<Etudiant>();
			Etudiant e = null;
			while (rs.next()) {
				e = new Etudiant();
				e.setNum(rs.getInt("numero"));
				e.setNom(rs.getString("nom").trim());
				e.setPrenomEtu(rs.getString("prenom").trim());
				e.setAdresse(rs.getString("adresse").trim());
				e.setTel(rs.getString("tel").trim());
				e.setOrganisation(rs.getString("organisation").trim());
				e.setVille(rs.getString("ville").trim());
				e.setFiliere(new Filiere(rs.getInt("idfiliere"), rs.getString("intitule")));
				listeEtu.add(e);
			}
			return listeEtu;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public List<Etudiant> findByVille(String ville) {
		try {
			ps = con.prepareStatement(EtudiantDAO.findByVille);
			ps.setString(1, ville);
			ResultSet rs = ps.executeQuery();
			List<Etudiant> listeEtu = new ArrayList<Etudiant>();
			Etudiant e = null;
			while (rs.next()) {
				e=new Etudiant();
				e.setNum(rs.getInt("numero"));
				e.setNom(rs.getString("nom").trim());
				e.setPrenomEtu(rs.getString("prenom").trim());
				e.setAdresse(rs.getString("adresse").trim());
				e.setTel(rs.getString("tel").trim());
				e.setOrganisation(rs.getString("organisation").trim());
				e.setVille(rs.getString("ville").trim());
				e.setFiliere(new Filiere(rs.getInt("idfiliere"), rs.getString("intitule")));
				listeEtu.add(e);
			}
			return listeEtu;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
