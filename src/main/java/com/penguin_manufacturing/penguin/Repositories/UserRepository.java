package com.penguin_manufacturing.penguin.Repositories;

import com.penguin_manufacturing.penguin.Models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
  public UserModel getUserByUsername(String username);
}
