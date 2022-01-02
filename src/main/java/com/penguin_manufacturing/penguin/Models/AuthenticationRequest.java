package com.penguin_manufacturing.penguin.Models;

public class AuthenticationRequest {
  private String username;
  private String password;

  public String getusername() {
    return this.username;
  }

  public void setusername(String username) {
    this.username = username;
  }

  public String getpassword() {
    return this.password;
  }

  public void setpassword(String password) {
    this.password = password;
  }

  public AuthenticationRequest() {
  }

  public AuthenticationRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }
}