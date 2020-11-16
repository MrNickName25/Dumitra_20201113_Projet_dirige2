package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import users.User;


public class TestUser {
	User u0;
	User u1=new User();
	User u2=new User(1,"Cristian","Cris","1234","admin");
	
	@Test
	public void testConstructeurNull() {
		assertNull(u0);
	}
	
	@Test
	public void testConstructeurNotNull() {
		assertNotNull(u1);
		assertNotNull(u2);
	}
	
	@Test
	public void testGetId_u() {
		assertEquals(1,u2.getId_u());
	}
	
	@Test
	public void testGetNom() {
		assertEquals("Cristian",u2.getNom());
	}

	@Test
	public void testGetUsername() {
		assertEquals("Cris",u2.getUsername());
	}

	@Test
	public void testGetPassword() {
		assertEquals("1234",u2.getPassword());
	}

	@Test
	public void testGetRole() {
		assertEquals("admin",u2.getRole());
	}
	
	@Test
	public void testSetId_u() {
		u1.setId_u(2);
		assertEquals(2,u1.getId_u());
	}
	
	@Test
	public void testSetNom() {
		u1.setNom("Florin");
		assertEquals("Florin",u1.getNom());
	}

	@Test
	public void testSetUsername() {
		u1.setUsername("florin");
		assertEquals("florin",u1.getUsername());
	}

	@Test
	public void testSetPassword() {
		u1.setPassword("florin");
		assertEquals("florin",u1.getPassword());
	}

	@Test
	public void testSetRole() {
		u1.setRole("user");
		assertEquals("user",u1.getRole());
	}
}
