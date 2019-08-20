package com.cg.frs;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
//import org.testng.annotations.Test;

import org.junit.jupiter.api.Test;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Test;

import com.cg.capgapp.fms.service.IAddPassengerDetailsImpl;

public class MobileNoTest {
	IAddPassengerDetailsImpl i1 = new IAddPassengerDetailsImpl();
	
	@Test
	public void mobileNoNotEmptyTest() {
		//assertThat("vishal", "vishal");
		//fail("Not yet implemented");
	}
	
	@Test
	public void mobileNoLengthTest() {
		assertEquals(true,i1.fullName("9983077144"));
	}
	
	@Test
	public void noSymbolTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void noSpaceTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void noLetterTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void notStartWithZeroTest() {
		fail("Not yet implemented");
	}

	@Test
	public void notNegativeTest() {
		fail("Not yet implemented");
	}
}
