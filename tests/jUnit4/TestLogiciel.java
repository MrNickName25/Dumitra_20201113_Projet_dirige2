package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import vulnerabilities.Logiciel;

public class TestLogiciel{

	Logiciel l0;
	Logiciel l1=new Logiciel();
	Logiciel l2=new Logiciel(1,"Safari","v3");

	@Test
	public void testConstructeurNull() {
	}
	@Test
	public void testConstructeurNotNullV1() {
		assertNotNull(l1);
		assertNotNull(l2);
	}
		
	@Test
	public void testGetId_l() {
		assertEquals(1,l2.getId_l());
	}

	@Test
	public void testGetNom_logiciel() {
		assertEquals("Safari",l2.getNom_logiciel());
	}

	@Test
	public void testGetVersion_logiciel() {
		assertEquals("v3",l2.getVersion_logiciel());
	}
	
	@Test
	public void testSetId_l() {
		l1.setId_l(5);
		assertEquals(5,l1.getId_l());
	}

	@Test
	public void testSetNom_logiciel() {
		l1.setNom_logiciel("Chrome");
		assertEquals("Chrome",l1.getNom_logiciel());
	}

	@Test
	public void testSetVersion_logiciel() {
		l1.setVersion_logiciel("v86.3");
		assertEquals("v86.3",l1.getVersion_logiciel());
	}
	
}