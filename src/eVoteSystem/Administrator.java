package eVoteSystem;
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
		password = pass;
		actionLog = new ArrayList<String>();
	}
	
	/**
	 * Validates an administrator based on username and password
	 */
	public boolean validateUser(String uN, String pass) {
		if((uN.equals(userName))&&(pass.equals(password)))
			return true;
		else
			return false;
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
