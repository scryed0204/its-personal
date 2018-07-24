package com.liam.its_personnal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liam.its_personnal.model.IpUser;

public interface IpUserRepository extends JpaRepository<IpUser, Long> {
	
	IpUser findByUserName(String userName);

}
