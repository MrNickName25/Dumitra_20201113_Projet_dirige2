package perimetre;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connecteur;
public class ModelPerimetre {

	public static ArrayList<Perimetre> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();

	public static ArrayList<Perimetre> versCollection(long id_u) {
		Connection conn = Connecteur.getConnection();
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Perimetre> listePerimetre = new ArrayList<Perimetre>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from perimetre where id_index_user="+id_u);
			if (rs != null) {
				while (rs.next()) {
					Perimetre per = new Perimetre();
					per.setId_index_user(rs.getLong("id_index_user"));
					per.setId_index_logiciel(rs.getLong("id_index_logiciel"));
					listePerimetre.add(per);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return listePerimetre;
	}
	
	public static void ajouterPerimetre(long index_u, long index_l) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into perimetre (id_index_user, id_index_logiciel) value(?,?)");
			prst.setLong(1, index_u);
			prst.setLong(2, index_l);
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}

	public static ArrayList<Perimetre> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Perimetre> listePerimetre = new ArrayList<Perimetre>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from perimetre");
			if (rs != null) {
				while (rs.next()) {
					Perimetre per = new Perimetre();
					per.setId_index_user(rs.getLong("id_index_user"));
					per.setId_index_logiciel(rs.getLong("id_index_logiciel"));
					listePerimetre.add(per);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listePerimetre;
	}
}

	