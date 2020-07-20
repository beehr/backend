package com.boushib.recruitment.services;

import com.boushib.recruitment.dao.UserDao;
import com.boushib.recruitment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
  private final UserDao userDao;

  @Autowired
  public UserService(@Qualifier("postgres") UserDao userDao) {
    this.userDao = userDao;
  }

  public int signup(User user){
    return userDao.signup(user);
  }

  public List<User> getUsers(){
    return userDao.getUsers();
  }

  public Optional<User> getUserById(UUID id){
    return userDao.getUserById(id);
  }

  public int updateUser(UUID id, User user){
    return userDao.updateUser(id, user);
  }

  public int deleteUser(UUID id){
    return userDao.deleteUser(id);
  }
}
