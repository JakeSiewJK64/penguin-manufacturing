package com.penguin_manufacturing.penguin.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class ApplicationUserRoles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleid;
  private String rolename;
  private String roledescription;

  public String getroledescription() {
    return this.roledescription;
  }

  public String getrolename() {
    return this.rolename;
  }

  public int getroleid() {
    return this.roleid;
  }

  public void setroleid(int id) {
    this.roleid = id;
  }

  public void setrolename(String name) {
    this.rolename = name;
  }
}
