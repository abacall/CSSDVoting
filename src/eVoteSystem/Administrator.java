package eVoteSystem;
import java.util.ArrayList;
import java.util.List;

public class Administrator {
	
	private String userName;
	private String password;
	private ArrayList<String> actionLog;
	
	public Administrator(String uN, String pass) {
		userName = uN;
		password = pass;
		actionLog = new ArrayList<String>();
	}
	
	public boolean validateUser(String uN, String pass) {
		if((uN.equals(userName))&&(pass.equals(password)))
			return true;
		else
			return false;
	}
	
	public void setup() {
		
	}
	
	public void logAdministratorAction(String action) {
		actionLog.add(action);
	}
	
	public String getUserName()
	{
		return userName;
	}
}
