package com.cg.frs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.testng.annotations.Test;

import com.cg.capgapp.fms.service.IAddPassengerDetailsImpl;

public class NameTest {
	IAddPassengerDetailsImpl i1 = new IAddPassengerDetailsImpl();
	
	@Test
	public void nameNotEmptyTest() {
		assertEquals(true,i1.fullName("VishalSinghaniya"));
	}
	
	@Test
	public void noSpecialSymbolTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void typeMismatchTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void nameLengthTest() {
		assertEquals(true,i1.fullName("VishalSinghaniya"));
	}
	
	
}
