package com.penguin_manufacturing.penguin.Services;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.UserModel;

public interface IUserService {
  List<UserModel> getAllUsers();
}
