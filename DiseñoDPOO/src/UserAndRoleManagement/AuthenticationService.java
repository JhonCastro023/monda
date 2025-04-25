package UserAndRoleManagement;

public class AuthenticationService {

	    public boolean validate(String username, String password) {
	    	
	        return username != null && password != null && !username.isEmpty() && !password.isEmpty();
	    }

	    public boolean registerUser(UserProfileManagement userManagement, String username, String name, String email, String password, String rol) {
	        if (validate(username, password)) {
	            userManagement.createUser(username, name, email, password);
	            return true;
	        }
	        return false;
	    }
	}

	

