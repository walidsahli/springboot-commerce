package com.project.commerce.Models.Utils;

public class RegisterRequest {
	
private Long id;
	
	private String username;
	
	private String email;
	private String firstName;

	private String lastName;
	
	private String password;
	
	private String phoneNumber;
	private  String role ;

	private double latitude;
	private double longitude;
	private String location;
	
	public RegisterRequest() {

	}
	
	public RegisterRequest(Long id, String username, String email, String firstName, String lastName, String password,
			String phoneNumber, String role, double latitude, double longitude, String location) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
