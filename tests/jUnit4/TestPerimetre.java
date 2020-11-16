package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import perimetre.Perimetre;

public class TestPerimetre {
	Perimetre p0;
	Perimetre p1=new Perimetre();
	Perimetre p2=new Perimetre(1,10);

	@Test
	public void testConstructeurNull() {
	}
	@Test
	public void testConstructeurNotNullV1() {
		assertNotNull(p1);
		assertNotNull(p2);
	}
	
	@Test
	public void testGetId_index_logiciel() {
		assertEquals(10,p2.getId_index_logiciel());
	}

	@Test
	public void testGetId_index_user() {
		assertEquals(1,p2.getId_index_user());
	}
	
	@Test
	public void testSetId_index_user() {
		p1.setId_index_user(100);
		assertEquals(100,p1.getId_index_user());
	}
	
	@Test
	public void testSetId_index_logiciel() {
		p1.setId_index_logiciel(100);
		assertEquals(100,p1.getId_index_logiciel());
	}
}
