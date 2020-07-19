package com.boushib.recruitment.dao;

import com.boushib.recruitment.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserData implements UserDao {
  private final List<User> users = new ArrayList<>();

  @Override
  public int signup(User user) {
    UUID id = UUID.randomUUID();
    User userObj = new User( id, user.getName(), user.getEmail(), user.getPassword(), user.getGender(),user.getAccountType());
    users.add(userObj);
    return 1;
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst();
  }

  @Override
  public int updateUser(UUID id, User user) {
    return getUserById(id).map(p -> {
      int index = users.indexOf(p);
      users.set(index, user);
      return 1;
    }).orElse(0);
  }

  @Override
  public int deleteUser(UUID id) {
    Optional<User> user = getUserById(id);
    if(user.isEmpty()) {
      System.out.println("Sorry! User not found!");
      return 0;
    }
    users.remove(user.get());
    return 1;
  }

  @Override
  public List<User> getUsers() {
    return users;
  }
}
