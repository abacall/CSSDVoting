package JUnitTests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Test;

import eVoteSystem.AdminPassword;
import eVoteSystem.Administrator;

public class AdminPasswordTests {
	
	@Test
	public void passwordCorruptTest() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
	{
		String hash = "";
		String testPassword = "testPassword";
		
		hash = AdminPassword.generateHash(testPassword);
		
		assertTrue(AdminPassword.validatePassword(hash, testPassword));
		assertFalse(AdminPassword.validatePassword(hash, "pleaseWork"));
	}
	
	
	public void administratorIntegrationTest()
	{
		String testUsername = "testUsername";
		String testPassword = "testPassword";
		
		Administrator testAdmin = new Administrator(testUsername ,testPassword);
		
		assertTrue(testAdmin.validateUser(testUsername, testPassword));
		assertFalse(testAdmin.validateUser(testUsername, "pleaseWork"));
	}

}
