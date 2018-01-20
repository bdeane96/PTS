package com.data;

public class GoogleUserProfile {

	private String id;
	private String name;
	private String id_token;
	
	public GoogleUserProfile() {
	}
	
	public GoogleUserProfile(String id, String name, String token) {
		setId(id);
		setName(name);
		setId_token(token);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_token() {
		return id_token;
	}
	public void setId_token(String id_token) {
		this.id_token = id_token;
	}
	
}
