package com.penguin_manufacturing.penguin.Services;

import java.util.ArrayList;

import com.penguin_manufacturing.penguin.Models.UserModel;
import com.penguin_manufacturing.penguin.Repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  public UserModel loadUserModelByUsername(String username) throws UsernameNotFoundException {

    UserModel user = this.userRepository.getUserByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("user " + username + " does not exist.");
    }
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user;

    user = this.userRepository.getUserByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User " + username + " does not exist");
    }
    return new User(user.getusername(), user.getpassword(), new ArrayList<>());
  }
}
