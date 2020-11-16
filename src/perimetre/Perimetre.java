package perimetre;

import java.io.Serializable;

 public class Perimetre implements Serializable {
	public long id_index_user;
	public long id_index_logiciel;
	 
	public long getId_index_user() {
		return id_index_user;
	}
	public void setId_index_user(long id_index_user) {
		this.id_index_user = id_index_user;
	}
	public long getId_index_logiciel() {
		return id_index_logiciel;
	}
	public void setId_index_logiciel(long id_index_logiciel) {
		this.id_index_logiciel = id_index_logiciel;
	}

	public Perimetre(long id_index_user, long id_index_logiciel) {
		this.id_index_user = id_index_user;
		this.id_index_logiciel = id_index_logiciel;
	}
	
	public Perimetre() {}
	 
}
