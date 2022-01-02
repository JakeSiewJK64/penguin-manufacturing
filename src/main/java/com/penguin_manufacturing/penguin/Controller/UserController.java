package com.penguin_manufacturing.penguin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.UserModel;
import com.penguin_manufacturing.penguin.Services.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RestController
public class UserController {

  @Autowired
  private UserService _userService;

  @GetMapping(value = "/users")
  public List<UserModel> getUsers() {
    return _userService.getAllUsers();
  }
}
