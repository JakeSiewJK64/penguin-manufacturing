package com.penguin_manufacturing.penguin.repositories;

import com.penguin_manufacturing.penguin.Models.UserModel;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
  public UserModel getUserById(String user_id);
}
