package com.taitran.program.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taitran.program.entity.UserEntity;


public class GroupUserDetails implements UserDetails{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String userName;
  private String password;  
  private boolean isActive;  
  private List<GrantedAuthority> authorities;

  
  public GroupUserDetails(UserEntity user) {
    this.userName = user.getUserName();
    this.password= user.getPassword();
    this.isActive = user.isActive();
    this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return false;
  }

}
