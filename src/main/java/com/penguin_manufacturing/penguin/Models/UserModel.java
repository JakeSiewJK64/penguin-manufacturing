package com.penguin_manufacturing.penguin.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "users")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Number id;

  @Column(name = "user_name")
  private String user_name;

  @Column(name = "user_password")
  private String user_password;

  @Column(name = "role")
  private Number user_role;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "last_name")
  private String last_name;

  @Column(name = "image_url")
  private String image_url;

}
