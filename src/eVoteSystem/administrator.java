package eVoteSystem;
import java.util.ArrayList;
import java.util.List;

public class administrator {
	
	private String userName;
	private String password;
	private List actionLog;
	
	public administrator(String uN, String pass) {
		userName = uN;
		password = pass;
		actionLog = new ArrayList<String>();
	}
	
	public boolean validateUser(String uN, String pass) {
		return true;
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
