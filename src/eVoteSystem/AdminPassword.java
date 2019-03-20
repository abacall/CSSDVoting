package eVoteSystem;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AdminPassword {
		
		/**
		 * Stores a secure hash of password
		 * 
		 * @param username
		 * @param password
		 * @throws NoSuchAlgorithmException
		 * @throws NoSuchProviderException
		 * @throws InvalidKeySpecException 
		 */
		public static String generateHash(String password) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
		{
	        return getSecurePassword(password);
	        
	        
		}
		
		/**
		 * Validates password against passed in hash
		 * 
		 * @param username
		 * @param passwordIn
		 * @return valid login
		 * @throws NoSuchAlgorithmException
		 * @throws NoSuchProviderException
		 * @throws InvalidKeySpecException 
		 */
		public static boolean validatePassword(String storedPassword ,String passwordIn) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException
		{
			
				//Seperate stored string into component parts
				String[] parts = storedPassword.split(":");
				//Iterations to prevent brute force attack
				int numOfIterations = Integer.parseInt(parts[0]);
				//Same salt every time or password will never match
				byte[] salt = fromString(parts[1]);
				//Stored hash
				byte[] hash = fromString(parts[2]);
	        
				//Create instance of specification object
	        	PBEKeySpec spec = new PBEKeySpec(passwordIn.toCharArray(), salt, numOfIterations, 64 * 8);
	        	//Create instance for PBKDF2 algorithm
	        	SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        	
	        	//Generate hash for passed in password
	        	byte[] testHash = skf.generateSecret(spec).getEncoded();
	         
	        	//Check hash lengths are the same
	        	boolean diff = hash.length == testHash.length;
	        	
	        	//Check every item in the byte array are the same
	        	for(int i = 0; i < hash.length && i < testHash.length; i++)
	        	{
	            	diff = hash[i] == testHash[i];
	        	}
	        	
	        	return diff;
		}
		
		/**
		 * Generates a secure hash based on string passed in
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
	    	//Default number of iterations
	        int numOfIterations = 1000;
	        //Get random salt
	        byte[] salt = getSalt();
	         
	        //Create instance of specification object
	        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, numOfIterations, 64 * 8);
	        //Create instance for PBKDF2 algorithm
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        
	        //Generate hash
	        byte[] hash = skf.generateSecret(spec).getEncoded();
	        
	        //Return string with meta-data added
	        return numOfIterations + ":" + toString(salt) + ":" + toString(hash);
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
	    	//SecureRandom for cryptographically strong random number
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
	    private static String toString(byte[] array) 
	    {
	    	//Create int from array
	        BigInteger bi = new BigInteger(1, array);
	        //Create string with base 16
	        String hex = bi.toString(16);
	        //Calculate if padding is needed
	        int paddingLength = (array.length * 2) - hex.length();
	        //If padding is needed then fill out with 'd'
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
	    private static byte[] fromString(String hex) 
	    {
	    	//Create empty byte array
	        byte[] bytes = new byte[hex.length() / 2];
	        
	        for(int i = 0; i<bytes.length ;i++)
	        {
	        	//Convert from base 16 back to original byte
	            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	        }
	        
	        return bytes;
	    }
	    
}
