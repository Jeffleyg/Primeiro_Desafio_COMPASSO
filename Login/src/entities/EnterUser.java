package entities;

public class EnterUser {
	
	private String username;
	private String password;
	
	public EnterUser() {
	}

	public EnterUser(String users, String password) {
		super();
		this.username = users;
		this.password = password;
	}

	public String getUsers() {
		return username;
	}

	//public void setUsers(String users) {
		//this.username = users;
//	}

	public String getPassword() {
		return password;
	}

	//public void setPassword(String password) {
		//this.password = password;
	//}
	
	// como vamos entrar user e login nós não precisa os setPassword e setUsers
	
	
}
