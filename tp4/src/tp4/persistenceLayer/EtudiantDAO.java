package tp4.persistenceLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp4.BusinessLogicLayer.Etudiant;
import tp4.BusinessLogicLayer.Filiere;

public class EtudiantDAO extends DAO<Etudiant> {
	private Connection con;
	private PreparedStatement ps;
	private static String findByVille = "SELECT * FROM `etudiant` inner join filiere on etudiant.idfiliere=filiere.idfiliere where ville=?";
	private static String findByFiliere = "SELECT * FROM `etudiant` inner join filiere on etudiant.idfiliere=filiere.idfiliere where idfiliere=?";
	private static String findByNumEtu = "SELECT * FROM `etudiant` inner join filiere on etudiant.idfiliere=filiere.idfiliere where numEtu=?";
	private static String findAll = "SELECT * FROM `etudiant` inner join filiere on etudiant.idfiliere=filiere.idfiliere";
	private static String create = "INSERT INTO etudiant(numEtu,nom,ville,idFiliere) values(?,?,?,?)";
	private static String remove = "DELETE FROM etudiantupf where numero=?";

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
			ps.setInt(1, e.getIdEtu());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getVille());
			ps.setInt(4, e.getFiliere().getIdFil());
			int rowCount = ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean delete(Etudiant e) {
		try {
			ps = con.prepareStatement(EtudiantDAO.remove);
			ps.setInt(1, e.getIdEtu());
			int row = ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean update(Etudiant e, Etudiant e1) {

		return false;
	}

	public Etudiant getById(int id) {
		try {
			ps = con.prepareStatement(EtudiantDAO.findByNumEtu);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Etudiant e = null;
			if (rs.next())
				e = new Etudiant(rs.getInt("numEtu"), rs.getString("nom"), rs.getString("ville"),
						new Filiere(rs.getInt("idfiliere"), rs.getString("intitule")));
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
			// FiliereDAO filiere=null; nécessite plus de temps à cause de
			// l'exécution d'une requête à chaque création d'étudiant
			while (rs.next()) {
				e = new Etudiant();
				e.setIdEtu(rs.getInt("numEtu"));
				e.setNom(rs.getString("nom").trim());
				e.setVille(rs.getString("ville").trim());
				e.setFiliere(new Filiere(rs.getInt("idfiliere"), rs.getString("intitule")));
				listeEtu.add(e);
				// System.out.println(e+" Ajouté");
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
				e.setIdEtu(rs.getInt("numEtu"));
				e.setNom(rs.getString("nom").trim());
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
				e = new Etudiant();
				e.setIdEtu(rs.getInt("numEtu"));
				e.setNom(rs.getString("nom").trim());
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
