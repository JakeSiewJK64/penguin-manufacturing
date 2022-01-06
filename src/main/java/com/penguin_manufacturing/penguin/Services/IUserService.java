package com.penguin_manufacturing.penguin.Services;

import java.util.List;

import com.penguin_manufacturing.penguin.Models.UserModel;
import com.penguin_manufacturing.penguin.Models.VerifyResponse;

public interface IUserService {
  List<UserModel> getAllUsers();

  VerifyResponse getUserVerification(int userid);
}
