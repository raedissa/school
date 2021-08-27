package com.swan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swan.model.AppUser;
import com.swan.model.UserRole;
import com.swan.model.repo.AppUserRepository;
import com.swan.model.repo.UserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

//	@Autowired
//	private AppRoleRepository appRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final AppUser appUser = userRepository.findByUserName(userName);

		if (appUser == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		System.out.println("Found User: " + appUser);

		// [ROLE_USER, ROLE_ADMIN,..]
		final List<String> roleNames = new ArrayList<String>();

		final List<UserRole> userRoles = userRoleRepository.findByUserId(appUser.getUuid());
		for (final UserRole userRole : userRoles) {
			roleNames.add(userRole.getUserRole());
		}

		final List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (final String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				final GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		final UserDetails userDetails = new User(appUser.getUserName(), appUser.getPassword(), grantList);

		return userDetails;
	}
}
