package users;

import java.io.Serializable;

public class User implements Serializable {

	public long id_u;
	public String nom, username, password, role;
	
	public long getId_u() {
		return id_u;
	}

	public void setId_u(long id_u) {
		this.id_u = id_u;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public User(long id_u, String nom, String username, String password, String role) {
		this.id_u = id_u;
		this.nom = nom;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
		
	}
	
}
