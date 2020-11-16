package jUnit4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;

import connexion.Connecteur;

public class TestConnection {
	Connection c;
	Connecteur co;
	
	@Test
	public void before() {
		co.getConnection().toString();
		//c.connection = SybaseDBConnection.getConnection("ase");
	}

}
