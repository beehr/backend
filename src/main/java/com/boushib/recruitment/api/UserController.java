package com.boushib.recruitment.api;

import com.boushib.recruitment.models.User;
import com.boushib.recruitment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public int signup(@Valid @NonNull @RequestBody User user){
    return userService.signup(user);
  }

  @GetMapping
  public List<User> getUsers(){
    return userService.getUsers();
  }

  @GetMapping(path = "{id}")
  public Optional<User> getUserById(@PathVariable("id") UUID id){
    return userService.getUserById(id);
  }

  @PutMapping(path = "{id}")
  public int updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User user){
    return userService.updateUser(id, user);
  }

  @DeleteMapping(path = "{id}")
  public int deleteUser(@PathVariable("id") UUID id){
    return userService.deleteUser(id);
  }
}
