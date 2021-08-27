package com.swan.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swan.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	@Override
	List<AppUser> findAll();

	AppUser findByUserName(String userName);
}
