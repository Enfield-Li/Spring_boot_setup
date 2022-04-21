package com.User;

import java.util.List;

import com.User.dto.CreateUserDTO;
import com.User.dto.UpdateUserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(path = "{username}")
  public User getUserByUsername(@PathVariable String username) {
    return userService.findUserByUsername(username);
  }

  @PostMapping
  public User register(@RequestBody CreateUserDTO createUserDTO) {
    return userService.registeUser(createUserDTO);
  }

  @DeleteMapping(path = "{id}")
  public Boolean deleteUser(@PathVariable String id) {
    return userService.deleteUser(Long.parseLong(id));
  }

  @PutMapping(path = "{id}")
  public User updateUser(
    @PathVariable String id,
    @RequestBody UpdateUserDTO updateUserDTO
  ) {
    return userService.updateUser(Long.parseLong(id), updateUserDTO);
  }
}
