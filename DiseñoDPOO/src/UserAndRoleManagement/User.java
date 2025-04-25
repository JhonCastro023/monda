package UserAndRoleManagement;

public abstract class User {

	
	private String username;
    private String name;
    private String email;
    private String rol;

    public User(String username, String name, String email, String password, String rol) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
	
