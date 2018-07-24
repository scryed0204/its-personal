package com.liam.its_personnal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liam.its_personnal.model.IpUser;
import com.liam.its_personnal.repository.IpUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private IpUserRepository ipUserRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		IpUser ipUser = ipUserRepository.findByUserName(userName);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("User"));
		User user = new User(ipUser.getUserName(), ipUser.getUserPw(), grantedAuthorities);
		return user;
	}

}
