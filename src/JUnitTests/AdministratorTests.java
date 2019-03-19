package JUnitTests;

import static org.junit.Assert.*;
import eVoteSystem.Administrator;

import org.junit.Test;

public class AdministratorTests {

	// Low level administrator affirmations 
	
	@Test
	public void administratorConstruction() {
		Administrator admin = new Administrator("JSmith1999", "newPass");
		// Check admin has been set up correctly
		assertEquals(admin.getUserName(), "JSmith1999");
	}
	
	@Test
	public void administratorValidation() {
		Administrator admin = new Administrator("JSmith1999", "newPass");
		// Test that validate user does not work with incorrect password
		assertFalse(admin.validateUser("JSmith1999", "wrongPass"));
		// Test that validate user works when presented with correct username and password
		assertTrue(admin.validateUser("JSmith1999", "newPass"));
	}

}
