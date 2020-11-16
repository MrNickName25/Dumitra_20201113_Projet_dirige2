package vulnerabilities;

import java.io.Serializable;

public class Logiciel implements Serializable {

	public long id_l;
	public String nom_logiciel, version_logiciel;
	
	public long getId_l() {
		return id_l;
	}

	public void setId_l(long id_l) {
		this.id_l = id_l;
	}

	public String getNom_logiciel() {
		return nom_logiciel;
	}

	public void setNom_logiciel(String nom_logiciel) {
		this.nom_logiciel = nom_logiciel;
	}

	public String getVersion_logiciel() {
		return version_logiciel;
	}

	public void setVersion_logiciel(String version_logiciel) {
		this.version_logiciel = version_logiciel;
	}

	public Logiciel(long id_l, String nom_logiciel, String version_logiciel) {
		this.id_l = id_l;
		this.nom_logiciel = nom_logiciel;
		this.version_logiciel = version_logiciel;
	}

	public Logiciel() {
		
	}	
}