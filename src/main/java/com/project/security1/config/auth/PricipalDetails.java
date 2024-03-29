package com.project.security1.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.security1.model.User;

public class PricipalDetails implements UserDetails {
  
  private User user;
  
  public PricipalDetails(User userInfo) {
    this.user = userInfo;
    System.out.println(this.user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collectors = new ArrayList<>();
    collectors.add(()-> {
      return "ROLE_"+user.getRole();
    });
    return collectors;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }
  
}
