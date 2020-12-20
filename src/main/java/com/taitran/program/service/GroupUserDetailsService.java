package com.taitran.program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.taitran.program.repository.UserRepository;

public class GroupUserDetailsService implements UserDetailsService{
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     userRepository.findByUserName(username);
    return null;
  }

}
