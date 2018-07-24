package com.liam.its_personnal.service;

public interface SecurityService {
	
	public String findLoggedUserName();
	
	public void autologin(String userName, String userPw);

}
