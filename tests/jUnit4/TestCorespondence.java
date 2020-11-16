package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import vulnerabilities.Corespondence;

public class TestCorespondence {

	Corespondence c0;
	Corespondence c1=new Corespondence();
	Corespondence c2=new Corespondence(1,2,3);

	@Test
	public void testConstructeurNull() {
	}
	@Test
	public void testConstructeurNotNullV1() {
		assertNotNull(c1);
		assertNotNull(c2);
	}
	
	@Test
	public void testGetId_c() {
		assertEquals(1,c2.getId_c());
	}

	@Test
	public void testGetId_index_logiciel() {
		assertEquals(3,c2.getId_index_logiciel());
	}

	@Test
	public void testGetId_index_vulnerabilite() {
		assertEquals(2,c2.getId_index_vulnerabilite());
	}
	
	@Test
	public void testSetId_c() {
		c1.setId_c(100);
		assertEquals(100,c1.getId_c());
	}
	
	@Test
	public void testSetId_index_logiciel() {
		c1.setId_index_logiciel(100);
		assertEquals(100,c1.getId_index_logiciel());
	}

	@Test
	public void testSetId_index_vulnerabilite() {
		c1.setId_index_vulnerabilite(2);
		assertEquals(2,c1.getId_index_vulnerabilite());
	}
}
