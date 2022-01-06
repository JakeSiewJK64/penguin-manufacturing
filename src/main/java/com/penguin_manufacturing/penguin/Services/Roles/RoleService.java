package com.penguin_manufacturing.penguin.Services.Roles;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.ApplicationUserRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<ApplicationUserRoles> getAllApplicationRoles() {
    return this.jdbcTemplate.query("SELECT * FROM role",
        BeanPropertyRowMapper.newInstance(ApplicationUserRoles.class));
  }

  @Override
  public String getRoleById(int id) {
    ApplicationUserRoles role = this.jdbcTemplate.query("SELECT rolename FROM role WHERE roleid = " + id,
        BeanPropertyRowMapper.newInstance(ApplicationUserRoles.class)).get(0);
    return role.getrolename();

  }
}
