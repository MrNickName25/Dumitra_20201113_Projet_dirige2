package users;

import java.sql.Connection;
import connexion.Connecteur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelUser {
	public static ArrayList<User> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static void ajouterUser(User u) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into user (id_u, nom, username, password, role) value(?,?,?,?,?)");
			prst.setLong(1, u.getId_u());
			prst.setString(2, u.getNom());
			prst.setString(3, u.getUsername());
			prst.setString(4, u.getPassword());
			prst.setString(5, u.getRole());
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}

	public static User chercherUser(String username, String password) {
		for (User u : liste) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}
	
	public static User chercherUser(long id_u) {
		for (User u : liste) {
			if (u.getId_u()==id_u)
				return u;
		}
		return null;
	}

	public static void modifierUser(long id_u, User nvu) {
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(
					"update user set nom = ?, username = ?, password=?, role=? where id_u= ?");
			prst.setString(1, nvu.getNom());
			prst.setString(2, nvu.getUsername());
			prst.setString(3, nvu.getPassword());
			prst.setString(4, nvu.getRole());
			
			prst.executeUpdate();
			liste = versCollection();

		} catch (NumberFormatException | SQLException e) {
			e.getStackTrace();
		}
	}

	public static ArrayList<User> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<User> listeusers = new ArrayList<User>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from user");
			if (rs != null) {
				while (rs.next()) {
					User u = new User();
					u.setId_u(rs.getLong("id_u"));
					u.setNom(rs.getString("nom"));
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					u.setRole(rs.getString("role"));
					listeusers.add(u);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeusers;
	}

	public static void supprimerUser (long id_u) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from user where id_u = ?");
			prst.setLong(1, id_u);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
