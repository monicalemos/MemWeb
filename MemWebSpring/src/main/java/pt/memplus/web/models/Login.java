package pt.memplus.web.models;

public class Login {
//	@NotNull
//	@NotBlank
	private String username;
//	@NotNull
//	@NotBlank
//	@Length(min=6)
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
