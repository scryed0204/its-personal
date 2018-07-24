package com.liam.its_personnal.service;

import com.liam.its_personnal.model.IpUser;

public interface UserService {
	
	public void save(IpUser ipUser);
	
	public IpUser findByUserName(String userName);
}
