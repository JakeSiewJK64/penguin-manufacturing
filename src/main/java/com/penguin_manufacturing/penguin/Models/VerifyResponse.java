package com.penguin_manufacturing.penguin.Models;

public class VerifyResponse {

  private String username;
  private String role;

  public VerifyResponse(String username, String role) {
    this.username = username;
    this.role = role;
  }

  public VerifyResponse() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
