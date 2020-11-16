package vulnerabilities;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connecteur;
public class ModelSolution {

	public static ArrayList<Solution> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static void ajouterSolution(Solution sol) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into solution (id_s, description_solution, id_index_vulnerabilite, id_index_logiciel) value(?,?,?,?)");
			prst.setLong(1, sol.getId_s());
			prst.setString(2, sol.getDescription_solution());
			prst.setLong(3, sol.getId_index_vulnerabilite());
			prst.setLong(4, sol.getId_index_logiciel());
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}
	}
	
	public static Solution chercherSolution(long id_s) {
		for (Solution sol : liste) {
			if (sol.getId_s()==id_s)
				return sol;
		}
		return null;
	}

	public static void modifierSolution(long id_s, Solution nvs) {
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(
					"update solution set description_solution = ?, id_index_vulnerabilite = ?, id_index_logiciel=? where id_s= ?");
			prst.setString(1, nvs.getDescription_solution());
			prst.setLong(2, nvs.getId_index_vulnerabilite());
			prst.setLong(3, nvs.getId_index_logiciel());
			
			prst.executeUpdate();
			liste = versCollection();

		} catch (NumberFormatException | SQLException e) {
			e.getStackTrace();
		}
	}

	public static ArrayList<Solution> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Solution> listeSolution = new ArrayList<Solution>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from vulnerabilite");
			if (rs != null) {
				while (rs.next()) {
					Solution sol = new Solution();
					sol.setId_s(rs.getLong("id_s"));
					sol.setDescription_solution(rs.getString("description_solution"));
					sol.setId_index_vulnerabilite(rs.getLong("id_index_vulnerabilite"));
					sol.setId_index_logiciel(rs.getLong("id_index_logiciel"));
					listeSolution.add(sol);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeSolution;
	}
	
//	public static ArrayList<Solution> versCollection(long id_l) {
//		
//				Connection conn = Connecteur.getConnection();
//		Statement st;
//		ResultSet rs;
//		ArrayList<Solution> listeSolutions = new ArrayList<Solution>();
//		try {
//			st = conn.createStatement();
//			rs = st.executeQuery("SELECT id_s, description_solution FROM solution, vulnerabilite WHERE id_index_logiciel="+id_l+"AND id_index_vulnerabilite=vulnerabilite.id_v");
//			if (rs != null) {
//				while (rs.next()) {
//					Solution sol = new Solution();
//					sol.setId_s(rs.getLong("id_s"));
//					sol.setDescription_solution(rs.getString("description_solution"));
//					listeSolutions.add(sol);
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return listeSolutions;
//	}
	
	public static ArrayList<Solution> versCollection(long id_l, long id_v) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Solution> listeSolutions = new ArrayList<Solution>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id_s, description_solution FROM solution WHERE id_index_logiciel="+id_l+" AND id_index_vulnerabilite="+id_v);
			if (rs != null) {
				while (rs.next()) {
					Solution sol = new Solution();
					sol.setId_s(rs.getLong("id_s"));
					sol.setDescription_solution(rs.getString("description_solution"));
					listeSolutions.add(sol);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeSolutions;
	}

	public static void supprimerSolution(long id_s) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from solution where id_s = ?");
			prst.setLong(1, id_s);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
}