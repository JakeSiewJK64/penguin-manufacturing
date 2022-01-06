package com.penguin_manufacturing.penguin.Models;

public class VerifyResponse {

  private String username;
  private int role;

  public VerifyResponse(String username, int role) {
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

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }
}
