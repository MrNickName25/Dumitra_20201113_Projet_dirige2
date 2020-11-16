package vulnerabilities;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connecteur;
import users.User;
public class ModelLogiciel {

	public static ArrayList<Logiciel> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	

	public static void ajouterLogiciel(Logiciel log) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into logiciel (id_l, nom_logiciel, version_logiciel) value(?,?,?)");
			prst.setLong(1, log.getId_l());
			prst.setString(2, log.getNom_logiciel());
			prst.setString(3, log.getVersion_logiciel());
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}
	
	public static Logiciel chercherLogiciel(long id_l) {
		for (Logiciel log : liste) {
			if (log.getId_l()==id_l)
				return log;
		}
		return null;
	}

	public static void modifierLogiciel(long id_l, Logiciel nvl) {
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(
					"update logiciel set nom_logiciel = ?, version_logiciel = ? where id_l= ?");
			prst.setString(1, nvl.getNom_logiciel());
			prst.setString(2, nvl.getVersion_logiciel());
			
			prst.executeUpdate();
			liste = versCollection();

		} catch (NumberFormatException | SQLException e) {
			e.getStackTrace();
		}
	}

	public static ArrayList<Logiciel> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Logiciel> listeLogiciel = new ArrayList<Logiciel>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from logiciel");
			if (rs != null) {
				while (rs.next()) {
					Logiciel log = new Logiciel();
					log.setId_l(rs.getLong("id_l"));
					log.setNom_logiciel(rs.getString("nom_logiciel"));
					log.setVersion_logiciel(rs.getString("version_logiciel"));					
					listeLogiciel.add(log);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeLogiciel;
	}
	
	public static ArrayList<Logiciel> versCollection(long id_v) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Logiciel> listeLogiciel = new ArrayList<Logiciel>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM logiciel INNER JOIN correspondece ON logiciel.id_l=correspondece.id_index_logiciel WHERE correspondece.id_index_vulnerabilite="+id_v);
			if (rs != null) {
				while (rs.next()) {
					Logiciel log = new Logiciel();
					log.setId_l(rs.getLong("id_l"));
					log.setNom_logiciel(rs.getString("nom_logiciel"));
					log.setVersion_logiciel(rs.getString("version_logiciel"));
					listeLogiciel.add(log);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeLogiciel;
	}

	public static ArrayList<Logiciel> afficherCollection(long id_u) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Logiciel> listeLogiciel = new ArrayList<Logiciel>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM logiciel WHERE logiciel.id_l IN (SELECT correspondece.id_index_logiciel FROM correspondece WHERE correspondece.id_index_logiciel IN ( SELECT id_index_logiciel FROM perimetre WHERE id_index_user="+id_u+"))");
			if (rs != null) {
				while (rs.next()) {
					Logiciel log = new Logiciel();
					log.setId_l(rs.getLong("id_l"));
					log.setNom_logiciel(rs.getString("nom_logiciel"));
					log.setVersion_logiciel(rs.getString("version_logiciel"));
					listeLogiciel.add(log);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeLogiciel;
	}

	public static ArrayList<Logiciel> afficherCollection(long id_u, long id_v) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Logiciel> listeLogiciel = new ArrayList<Logiciel>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM logiciel INNER JOIN correspondece ON logiciel.id_l=correspondece.id_index_logiciel WHERE correspondece.id_index_vulnerabilite="+id_v+" AND (logiciel.id_l IN (SELECT correspondece.id_index_logiciel FROM correspondece WHERE correspondece.id_index_logiciel IN ( SELECT id_index_logiciel FROM perimetre WHERE id_index_user="+id_u+")))");
			if (rs != null) {
				while (rs.next()) {
					Logiciel log = new Logiciel();
					log.setId_l(rs.getLong("id_l"));
					log.setNom_logiciel(rs.getString("nom_logiciel"));
					log.setVersion_logiciel(rs.getString("version_logiciel"));
					listeLogiciel.add(log);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeLogiciel;
	}
	
	
	public static void supprimerLogiciel(long id_l) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from logiciel where id_l = ?");
			prst.setLong(1, id_l);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
}