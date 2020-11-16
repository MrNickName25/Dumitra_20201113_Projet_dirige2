package vulnerabilities;

import java.io.Serializable;

public class Menace implements Serializable {

	public long id_v;
	public String synthese_vulnerabilite, description_vulnerabilite;
	public int niv_gravite;
	public String url_source, date_creation;

	public long getId_v() {
		return id_v;
	}
	public void setId_v(long id_v) {
		this.id_v = id_v;
	}
	public String getSynthese_vulnerabilite() {
		return synthese_vulnerabilite;
	}
	public void setSynthese_vulnerabilite(String synthese_vulnerabilite) {
		this.synthese_vulnerabilite = synthese_vulnerabilite;
	}
	public String getDescription_vulnerabilite() {
		return description_vulnerabilite;
	}
	public void setDescription_vulnerabilite(String description_vulnerabilite) {
		this.description_vulnerabilite = description_vulnerabilite;
	}
	public int getNiv_gravite() {
		return niv_gravite;
	}
	public void setNiv_gravite(int niv_gravite) {
		this.niv_gravite = niv_gravite;
	}
	public String getUrl_source() {
		return url_source;
	}
	public void setUrl_source(String url_source) {
		this.url_source = url_source;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	public Menace(long id_v, String synthese_vulnerabilite, String description_vulnerabilite, int niv_gravite,
			String url_source, String date_creation) {
		this.id_v = id_v;
		this.synthese_vulnerabilite = synthese_vulnerabilite;
		this.description_vulnerabilite = description_vulnerabilite;
		this.niv_gravite = niv_gravite;
		this.url_source = url_source;
		this.date_creation = date_creation;
	}
	
	public Menace() {
		
	}	
}
