package vulnerabilities;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connecteur;
public class ModelCorespondence {

	public static ArrayList<Corespondence> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	

	public static void ajouterCorespondence(long index_v, long index_l) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into correspondece (id_index_vulnerabilite, id_index_logiciel) value(?,?)");
			prst.setLong(1, index_v);
			prst.setLong(2, index_l);
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}

	public static ArrayList<Corespondence> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Corespondence> listeCorespondence = new ArrayList<Corespondence>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from correspondence");
			if (rs != null) {
				while (rs.next()) {
					Corespondence cor = new Corespondence();
					cor.setId_index_vulnerabilite(rs.getLong("id_index_vulnerabilite"));
					cor.setId_index_logiciel(rs.getLong("id_index_logiciel"));
					listeCorespondence.add(cor);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeCorespondence;
	}
}

	