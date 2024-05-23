package com.example.Vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Vaccine.Repository.UsersRepo;

@Service
public class OurUserDetailsService implements UserDetailsService{

	@Autowired
    private UsersRepo usersRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usersRepo.findByEmail(username).orElseThrow();
	}
}
