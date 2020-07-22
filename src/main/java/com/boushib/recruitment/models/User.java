package com.boushib.recruitment.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.UUID;

public class User {
  private UUID id;
  @NotBlank
  private String name;
  @NotBlank
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String gender;
  private String account_type;
  private Timestamp created_at;
  private Timestamp updated_at;

  public User(
      @JsonProperty("id") UUID id,
      @JsonProperty("name") String name,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password,
      @JsonProperty("gender") String gender,
      @JsonProperty("account_type") String account_type
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.account_type = account_type;
  }

  public User(
      UUID id,
      String name,
      String email,
      String password,
      String gender,
      String account_type,
      Timestamp created_at,
      Timestamp updated_at
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.account_type = account_type;
    this.created_at = created_at;
    this.updated_at = updated_at;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getGender() {
    return gender;
  }

  public String getAccountType() {
    return account_type;
  }

  public Timestamp getCreatedAt() {
    return created_at;
  }

  public Timestamp getUpdatedAt() {
    return updated_at;
  }
}
