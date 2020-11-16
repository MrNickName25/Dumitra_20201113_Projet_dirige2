package jUnit4;

import static org.junit.Assert.*;

import org.junit.Test;

import vulnerabilities.Solution;

public class TestSolution {

	Solution s0;
	Solution s1=new Solution();
	Solution s2=new Solution(1,"Installation patch",5,4);
	
	@Test
	public void testConstructeurNull() {
	}
	@Test
	public void testConstructeurNotNullV1() {
		assertNotNull(s1);
		assertNotNull(s2);
	}
		
	@Test
	public void testGetId_s() {
		assertEquals(1,s2.getId_s());
	}

	@Test
	public void testGetDescription_solution() {
		assertEquals("Installation patch",s2.getDescription_solution());
	}

	@Test
	public void testGetId_index_logiciel() {
		assertEquals(4,s2.getId_index_logiciel());
	}
	
	@Test
	public void testGetId_index_vulnerabilite() {
		assertEquals(5,s2.getId_index_vulnerabilite());
	}
	
	@Test
	public void testSetId_s() {
		s1.setId_s(5);
		assertEquals(5,s1.getId_s());
	}

	@Test
	public void testSetDescription_solution() {
		s1.setDescription_solution("Install KB10-xxx");
		assertEquals("Install KB10-xxx",s1.getDescription_solution());
	}

	@Test
	public void testSetId_index_logiciel() {
		s1.setId_index_logiciel(8);
		assertEquals(8,s1.getId_index_logiciel());
	}
	
	@Test
	public void testSetId_index_vulnerabilite() {
		s1.setId_index_vulnerabilite(7);
		assertEquals(7,s1.getId_index_vulnerabilite());
	}

}
