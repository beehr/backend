package com.boushib.recruitment.dao;

import com.boushib.recruitment.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
  int signup(User user);
  Optional<User> getUserById(UUID id);
  int updateUser(UUID id, User user);
  int deleteUser(UUID id);
  List<User> getUsers();
}
