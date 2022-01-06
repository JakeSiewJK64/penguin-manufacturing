package com.penguin_manufacturing.penguin.Services.Roles;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.ApplicationUserRoles;

public interface IRoleService {
  List<ApplicationUserRoles> getAllApplicationRoles();

  String getRoleById(int id);
}
