package com.aractakip.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {


   private Long id;

   private String username;
   @JsonIgnore
   private String password;
   private String name;
   private String surname;

   private String phoneNumber;
   private Collection<? extends GrantedAuthority> authorities;

   public UserDetailsImpl(
         Long id, String username, String password,
         String name, String surname, String phoneNumber,
         java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.name = name;
      this.surname = surname;
      this.phoneNumber = phoneNumber;
      this.authorities = authorities;
   }

   @Override
   public boolean isAccountNonExpired() {
      return false;
   }

   @Override
   public boolean isAccountNonLocked() {
      return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return false;
   }

   @Override
   public boolean isEnabled() {
      return false;
   }
}