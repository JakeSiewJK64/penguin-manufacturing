package com.penguin_manufacturing.penguin.Models;

public class AuthenticationResponse {
  private String jwt;

  public String getJwt() {
    return this.jwt;
  }

  public AuthenticationResponse(String jwt) {
    this.jwt = jwt;
  }

  public AuthenticationResponse() {
  }
}