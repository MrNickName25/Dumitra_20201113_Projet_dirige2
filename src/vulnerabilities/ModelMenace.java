package vulnerabilities;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connecteur;
public class ModelMenace {

	public static ArrayList<Menace> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();

	public static void ajouterMenace(Menace men) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into vulnerabilite (id_v, synthese_vulnerabilite, description_vulnerabilite, niv_gravite, url_source, date_creation) value(?,?,?,?,?,?)");
			prst.setLong(1, men.getId_v());
			prst.setString(2, men.getSynthese_vulnerabilite());
			prst.setString(3, men.getDescription_vulnerabilite());
			prst.setInt(4, men.getNiv_gravite());
			prst.setString(5, men.getUrl_source());
			prst.setString(6, men.getDate_creation());
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}
	
	public static Menace chercherMenace(long id_v) {
		for (Menace men : liste) {
			if (men.getId_v()==id_v)
				return men;
		}
		return null;
	}

	public static void modifierMenace(long id_v, Menace nvm) {
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(
					"update vulnerabilite set synthese_vulnerabilite = ?, description_vulnerabilite = ?,niv_gravite =?, url_source=?, date_creation=? where id_v= ?");
			prst.setString(1, nvm.getSynthese_vulnerabilite());
			prst.setString(2, nvm.getDescription_vulnerabilite());
			prst.setInt(3, nvm.getNiv_gravite());
			prst.setString(4, nvm.getUrl_source());
			prst.setString(5, nvm.getDate_creation());
			
			prst.executeUpdate();
			liste = versCollection();

		} catch (NumberFormatException | SQLException e) {
			e.getStackTrace();
		}
	}

	public static ArrayList<Menace> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Menace> listeMenace = new ArrayList<Menace>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from vulnerabilite");
			if (rs != null) {
				while (rs.next()) {
					Menace men = new Menace();
					men.setId_v(rs.getLong("id_v"));
					men.setSynthese_vulnerabilite(rs.getString("synthese_vulnerabilite"));
					men.setDescription_vulnerabilite(rs.getString("description_vulnerabilite"));
					men.setNiv_gravite(rs.getInt("niv_gravite"));
					men.setUrl_source(rs.getString("url_source"));
					men.setDate_creation(rs.getString("date_creation"));
					listeMenace.add(men);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMenace;
	}
	
	public static ArrayList<Menace> versCollection(long id_v) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Menace> listeMenace = new ArrayList<Menace>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from vulnerabilite WHERE id_v="+id_v);
			if (rs != null) {
				while (rs.next()) {
					Menace men = new Menace();
					men.setId_v(rs.getLong("id_v"));
					men.setSynthese_vulnerabilite(rs.getString("synthese_vulnerabilite"));
					men.setDescription_vulnerabilite(rs.getString("description_vulnerabilite"));
					men.setNiv_gravite(rs.getInt("niv_gravite"));
					men.setUrl_source(rs.getString("url_source"));
					men.setDate_creation(rs.getString("date_creation"));
					listeMenace.add(men);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMenace;
	}
	
	public static ArrayList<Menace> afficherCollection(long id_u) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Menace> listeMenace = new ArrayList<Menace>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM vulnerabilite WHERE vulnerabilite.id_v IN ( SELECT correspondece.id_index_vulnerabilite FROM correspondece WHERE  correspondece.id_index_logiciel IN ( SELECT id_index_logiciel FROM perimetre WHERE id_index_user="+id_u+"))");
			if (rs != null) {
				while (rs.next()) {
					Menace men = new Menace();
					men.setId_v(rs.getLong("id_v"));
					men.setSynthese_vulnerabilite(rs.getString("synthese_vulnerabilite"));
					men.setDescription_vulnerabilite(rs.getString("description_vulnerabilite"));
					men.setNiv_gravite(rs.getInt("niv_gravite"));
					men.setUrl_source(rs.getString("url_source"));
					men.setDate_creation(rs.getString("date_creation"));
					listeMenace.add(men);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMenace;
	}

	public static void supprimerMenace(long id_v) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from vulnerabilite where id_v = ?");
			prst.setLong(1, id_v);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
}