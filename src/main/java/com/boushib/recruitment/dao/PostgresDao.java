package com.boushib.recruitment.dao;

import com.boushib.recruitment.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresDao implements UserDao {
  @Override
  public int signup(User user) {
    return 0;
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return Optional.empty();
  }

  @Override
  public int updateUser(UUID id, User user) {
    return 0;
  }

  @Override
  public int deleteUser(UUID id) {
    return 0;
  }

  @Override
  public List<User> getUsers() {
    return List.of(new User(UUID.randomUUID(), "el hassane", "contact@boushib.com", "123456", "male", "admin"));
  }
}
