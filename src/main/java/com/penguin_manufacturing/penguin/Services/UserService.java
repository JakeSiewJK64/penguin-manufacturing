package com.penguin_manufacturing.penguin.Services;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired
  private JdbcTemplate _jdbcTemplate;

  @Override
  public List<UserModel> getAllUsers() {
    return (List<UserModel>) _jdbcTemplate.query("SELECT * FROM users;",
        BeanPropertyRowMapper.newInstance(UserModel.class));
  }

}
