package com.penguin_manufacturing.penguin.Services;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.ApplicationUserRoles;
import com.penguin_manufacturing.penguin.Models.UserModel;
import com.penguin_manufacturing.penguin.Models.VerifyResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<UserModel> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users;",
        BeanPropertyRowMapper.newInstance(UserModel.class));
  }

  @Override
  public VerifyResponse getUserVerification(int userid) {
    UserModel user = this.jdbcTemplate.query("SELECT * FROM users WHERE userid = " + userid,
        BeanPropertyRowMapper.newInstance(UserModel.class)).get(0);
    return new VerifyResponse(
        user.getusername(),
        this.jdbcTemplate.query("SELECT rolename FROM role WHERE roleid = " + user.getrole(),
            BeanPropertyRowMapper.newInstance(ApplicationUserRoles.class)).get(0).getrolename(),
        user.getemail(),
        user.getfirstname(),
        user.getlastname());
  }
}
