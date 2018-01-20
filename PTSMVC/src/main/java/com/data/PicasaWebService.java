package com.data;

public class PicasaWebService {
	GoogleUserProfile user;
	String baseURL = "https://picasaweb.google.com/data/feed/api/user/";
	String albumURL = "/albumid/";
	
	public PicasaWebService(GoogleUserProfile user) {
		this.user = user;
	}
}