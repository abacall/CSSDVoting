package eVoteSystem;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class for storing administrator details
 */
public class Administrator {
	
	private String userName;
	private String password;
	private ArrayList<String> actionLog;
	
	
	/**
	 * Constructor for administrator class
	 * 
	 *  @param username
	 *  @param password
	 */
	public Administrator(String uN, String pass) {
		userName = uN;
		
		try {
			password = AdminPassword.generateHash(pass);
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		actionLog = new ArrayList<String>();
	}
	
	/**
	 * Validates an administrator based on username and password
	 */
	public boolean validateUser(String uN, String pass) {
		
		boolean validUsername = uN.equals(userName);
		boolean validPassword = false;
		
		try {
			validPassword = AdminPassword.validatePassword(password, pass);
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return (validUsername && validPassword);
	}
	
	/**
	 * (Deprecated) Sets up a new election.
	 *
	 */
	public void setup() {
		
	}
	
	/**
	 * Logs an administrators action.
	 */
	public void logAdministratorAction(String action) {
		actionLog.add(action);
	}
	
	/**
	 * Returns the administrator username
	 */
	public String getUserName()
	{
		return userName;
	}
}
