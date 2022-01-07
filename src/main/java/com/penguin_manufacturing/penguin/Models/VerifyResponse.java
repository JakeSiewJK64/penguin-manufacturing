package com.penguin_manufacturing.penguin.Models;

public class VerifyResponse {

  private String username;
  private String role;
  private String email;
  private String firstname;
  private String lastname;

  public VerifyResponse() {
  }

  public VerifyResponse(String username, String role, String email, String firstname, String lastname) {
    this.username = username;
    this.role = role;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
