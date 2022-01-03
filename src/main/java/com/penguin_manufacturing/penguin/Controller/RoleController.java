package com.penguin_manufacturing.penguin.Controller;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.ApplicationUserRoles;
import com.penguin_manufacturing.penguin.Services.Roles.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping(value = "/getAllRoles")
  public List<ApplicationUserRoles> getAllApplicationRoles() {
    return this.roleService.getAllApplicationRoles();
  }
}
