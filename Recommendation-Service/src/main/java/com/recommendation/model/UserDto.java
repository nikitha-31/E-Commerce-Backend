package com.recommendation.model;

public class UserDto {
	private long id;
	private String password;
	private String email;
	private String role;
	private String fullname;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public UserDto(long id, String password, String email, String role, String fullname) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.role = role;
		this.fullname = fullname;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", email=" + email + ", role=" + role + ", fullname="
				+ fullname + "]";
	}
	

}
