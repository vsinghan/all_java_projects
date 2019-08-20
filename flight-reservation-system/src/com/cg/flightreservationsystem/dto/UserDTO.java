package com.cg.flightreservationsystem.dto;

public class UserDTO {

	private String username;
	private String password;

	public UserDTO() {

	}
	// Parameterized Constructor
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getUsername().equals(((UserDTO) obj).getUsername());
	}

}
