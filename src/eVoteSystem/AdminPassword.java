package eVoteSystem;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AdminPassword {
		HashMap<String, String> store = new HashMap<>();
		
		/**
		 * Stores a secure hash of password
		 * 
		 * @param username
		 * @param password
		 * @throws NoSuchAlgorithmException
		 * @throws NoSuchProviderException
		 * @throws InvalidKeySpecException 
		 */
		public void storeUser(String username, String password) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
		{
	        String securePassword = getSecurePassword(password);
	        
	        store.put(username, securePassword);
		}
		
		/**
		 * Validates user against stored username and passwords
		 * 
		 * @param username
		 * @param passwordIn
		 * @return valid login
		 * @throws NoSuchAlgorithmException
		 * @throws NoSuchProviderException
		 * @throws InvalidKeySpecException 
		 */
		public boolean validateUser(String username, String passwordIn) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
		{
			//
			String storedPassword = store.get(username);
			
			if(storedPassword != null)
	        {
				//Seperate 
				String[] parts = storedPassword.split(":");
				int numOfIterations = Integer.parseInt(parts[0]);
				byte[] salt = fromHex(parts[1]);
				byte[] hash = fromHex(parts[2]);
	        
	        	PBEKeySpec spec = new PBEKeySpec(passwordIn.toCharArray(), salt, numOfIterations, hash.length * 8);
	        	SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        	byte[] testHash = skf.generateSecret(spec).getEncoded();
	         
	        	int diff = hash.length ^ testHash.length;
	        	for(int i = 0; i < hash.length && i < testHash.length; i++)
	        	{
	            	diff |= hash[i] ^ testHash[i];
	        	}
	        	return diff == 0;
	        }
	        
	        return false;
	        
		}
		
		/**
		 * Generates a secure hash based on password passed in
		 * 
		 * @param passwordToHash
		 * @param salt
		 * @return
		 * @throws NoSuchProviderException 
		 * @throws NoSuchAlgorithmException 
		 * @throws InvalidKeySpecException 
		 */
	    private static String getSecurePassword(String password) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
	    {
	        int numOfIterations = 1000;
	        byte[] salt = getSalt();
	         
	        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, numOfIterations);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] hash = skf.generateSecret(spec).getEncoded();
	        return numOfIterations + ":" + toHex(salt) + ":" + toHex(hash);
	    }
	    
	    /**
	     * Generates salt bytes in order to avoid collisions in hashed passwords.
	     * 
	     * @return		Byte array
	     * @throws NoSuchAlgorithmException
	     * @throws NoSuchProviderException
	     */
	    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
	    {
	        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
	        
	        byte[] salt = new byte[16];
	        
	        random.nextBytes(salt);
	        
	        return salt;
	    }
	    
	    /**
	     * Convert a byte array into a string
	     * 
	     * @param array		byte array to convert
	     * @return			string from array
	     * @throws NoSuchAlgorithmException
	     */
	    private static String toHex(byte[] array) 
	    {
	        BigInteger bi = new BigInteger(1, array);
	        String hex = bi.toString(16);
	        int paddingLength = (array.length * 2) - hex.length();
	        if(paddingLength > 0)
	        {
	            return String.format("%0"  +paddingLength + "d", 0) + hex;
	        }else{
	            return hex;
	        }
	    }
	    
	    /**
	     * Convert a string into a byte array
	     * 
	     * @param hex	string to convert
	     * @return		byte array of string
	     * @throws NoSuchAlgorithmException
	     */
	    private static byte[] fromHex(String hex) 
	    {
	        byte[] bytes = new byte[hex.length() / 2];
	        for(int i = 0; i<bytes.length ;i++)
	        {
	            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	        }
	        return bytes;
	    }
	    
}
