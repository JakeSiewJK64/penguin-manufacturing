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
  @Column(name = "userid")
  private int userid;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private int role;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "email")
  private String email;

  public String getemail() {
    return email;
  }

  public String getfirstname() {
    return this.firstname;
  }

  public String getlastname() {
    return this.lastname;
  }

  public int getuserid() {
    return this.userid;
  }

  public String getusername() {
    return this.username;
  }

  public int getrole() {
    return this.role;
  }

  public String getpassword() {
    return this.password;
  }

  public void setpassword(String password) {
    this.password = password;
  }

  public void setusername(String name) {
    this.username = name;
  }

  public void setuserid(int id) {
    this.userid = id;
  }

  public void setrole(int role) {
    this.role = role;
  }

  public void setFirstName(String firstName) {
    this.firstname = firstName;
  }

  public void setLastName(String lastname) {
    this.lastname = lastname;
  }

  public void setemail(String email) {
    this.email = email;
  }
}