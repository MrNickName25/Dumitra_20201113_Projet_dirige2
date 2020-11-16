package vulnerabilities;

import java.io.Serializable;

public class Corespondence implements Serializable {

	public long id_c;
	public long id_index_vulnerabilite;
	public long id_index_logiciel;

	
	public long getId_c() {
		return id_c;
	}

	public void setId_c(long id_c) {
		this.id_c = id_c;
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

	public Corespondence(long id_c, long id_index_vulnerabilite, long id_index_logiciel) {
		this.id_c=id_c;
		this.id_index_vulnerabilite = id_index_vulnerabilite;
		this.id_index_logiciel = id_index_logiciel;
	}

	public Corespondence() {
		
	}	
}