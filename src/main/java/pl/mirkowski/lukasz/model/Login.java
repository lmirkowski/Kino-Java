package pl.mirkowski.lukasz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlogin;
	
	@Column(unique = true)
	private String login;

	private String password;
	
	private String email;
	
	private String role;

	public int getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Login() {
		super();
	}

	public Login(String login, String password, String email, String role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Login(int idlogin, String login, String password, String email, String role) {
		super();
		this.idlogin = idlogin;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [idlogin=" + idlogin + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	

}
