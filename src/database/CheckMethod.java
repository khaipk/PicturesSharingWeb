package database;

public class CheckMethod {
	public boolean checkLogin(String username, String password) {
		if (username.equals("phamkhai") && password.equals("hagiang")) {
			return true;
		} else return false;
	}
}
