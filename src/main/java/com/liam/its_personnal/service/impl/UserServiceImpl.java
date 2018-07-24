package com.liam.its_personnal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.liam.its_personnal.model.IpUser;
import com.liam.its_personnal.repository.IpUserRepository;
import com.liam.its_personnal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IpUserRepository ipUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(IpUser ipUser) {
		ipUser.setUserPw(bCryptPasswordEncoder.encode(ipUser.getUserPw()));
		ipUserRepository.save(ipUser);		
	}

	@Override
	public IpUser findByUserName(String userName) {
		return ipUserRepository.findByUserName(userName);
	}

}
