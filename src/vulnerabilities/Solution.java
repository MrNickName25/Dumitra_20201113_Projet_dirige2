package vulnerabilities;

import java.io.Serializable;

public class Solution implements Serializable {

	public long id_s;
	public String description_solution;
	public long id_index_vulnerabilite, id_index_logiciel;
	
	public long getId_s() {
		return id_s;
	}

	public void setId_s(long id_s) {
		this.id_s = id_s;
	}

	public String getDescription_solution() {
		return description_solution;
	}

	public void setDescription_solution(String description_solution) {
		this.description_solution = description_solution;
	}

	public long getId_index_vulnerabilite() {
		return id_index_vulnerabilite;
	}

	public void setId_index_vulnerabilite(long id_index_vulnerabilite) {
		this.id_index_vulnerabilite = id_index_vulnerabilite;
	}

	public long getId_index_logiciel() {
		return id_index_logiciel;
	}

	public void setId_index_logiciel(long id_index_logiciel) {
		this.id_index_logiciel = id_index_logiciel;
	}

	public Solution(long id_s, String description_solution, long id_index_vulnerabilite, long id_index_logiciel) {
		this.id_s = id_s;
		this.description_solution = description_solution;
		this.id_index_vulnerabilite = id_index_vulnerabilite;
		this.id_index_logiciel = id_index_logiciel;
	}

	public Solution() {
		
	}	
}
