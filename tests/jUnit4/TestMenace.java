package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import vulnerabilities.Menace;

public class TestMenace{

	Menace m0;
	Menace m1=new Menace();
	Menace m2=new Menace(1,"Pb de security","donnees de test",4,"www.adefinir.com","2020-11-13");
	
	@Test
	public void testConstructeurNull() {
	}
	@Test
	public void testConstructeurNotNullV1() {
		assertNotNull(m1);
		assertNotNull(m2);
	}
		
	@Test
	public void testGetId_v() {
		assertEquals(1,m2.getId_v());
	}

	@Test
	public void testGetSynthese_vulnerabilite() {
		assertEquals("Pb de security",m2.getSynthese_vulnerabilite());
	}

	@Test
	public void testGetDescription_vulnerabilite() {
		assertEquals("donnees de test",m2.getDescription_vulnerabilite());
	}
	
	@Test
	public void testGetNiv_gravite() {
		assertEquals(4,m2.getNiv_gravite());
	}

	@Test
	public void testGetUrl_source() {
		assertEquals("www.adefinir.com",m2.getUrl_source());
	}
	
	@Test
	public void testGetDate_creation() {
		assertEquals("2020-11-13",m2.getDate_creation());
	}
	
	@Test
	public void testSetId_v() {
		m1.setId_v(10);
		assertEquals(10,m1.getId_v());
	}

	@Test
	public void testSetSynthese_vulnerabilite() {
		m1.setSynthese_vulnerabilite("a definir");
		assertEquals("a definir",m1.getSynthese_vulnerabilite());
	}

	@Test
	public void testSetDescription_vulnerabilite() {
		m1.setDescription_vulnerabilite("a definir");
		assertEquals("a definir",m1.getDescription_vulnerabilite());
	}
	
	@Test
	public void testSetNiv_gravite() {
		m1.setNiv_gravite(2);
		assertEquals(2,m1.getNiv_gravite());
	}

	@Test
	public void testSetUrl_source() {
		m1.setUrl_source("a definir");
		assertEquals("a definir",m1.getUrl_source());
	}
	
	@Test
	public void testSetDate_creation() {
		m1.setDate_creation("a definir");
		assertEquals("a definir",m1.getDate_creation());
	}
}