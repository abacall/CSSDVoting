package eVoteSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.HashMap;

public class AdminPassword {
		HashMap<String, String> store = new HashMap<>();
		
		public void storeUser(String username, String passwordIn) throws NoSuchAlgorithmException, NoSuchProviderException
		{
			byte[] salt = getSalt();
	         
	        String securePassword = getSecurePassword(passwordIn, salt);
	        
	        store.put(username, securePassword);
	        
	        
		}
		
		public boolean validateUser(String username, String passwordIn) throws NoSuchAlgorithmException, NoSuchProviderException
		{
			byte[] salt = getSalt();
	         
	        String securePassword = getSecurePassword(passwordIn, salt);
	        
	        String storedHash = store.get("username");
	        
	        return securePassword == storedHash;
	        
	        
	        
		}
		
	    private static String getSecurePassword(String passwordToHash, byte[] salt)
	    {
	        String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(salt);
	            //Get the hash's bytes
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
		
	    /*
	     * Generates salt bytes in order to avoid collisions in hashed passwords.
	     * 
	     * */
	    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
	    {
	        //Always use a SecureRandom generator
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
	        //Create array for salt
	        byte[] salt = new byte[16];
	        //Get a random salt
	        sr.nextBytes(salt);
	        //return salt
	        return salt;
	    }
}
