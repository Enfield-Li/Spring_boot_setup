package com.User;

import com.User.dto.CreateUserDTO;
import com.User.dto.UpdateUserDTO;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User findUserById(Long id) {
    return userRepository
      .findById(id)
      .orElseThrow(
        () ->
          new IllegalStateException("Student with id " + id + " does not exist")
      );
  }

  public User findUserByEmail(Long id) {
    return userRepository
      .findByEmailWithQuery(id)
      .orElseThrow(
        () ->
          new IllegalStateException("Student with id " + id + " does not exist")
      );
  }

  public User findUserByUsername(String username) {
    return userRepository
      .findByUsername(username)
      .orElseThrow(
        () ->
          new IllegalStateException(
            "Student with username " + username + " does not exist"
          )
      );
  }

  public User registeUser(@RequestBody CreateUserDTO createUserDTO) {
    Optional<User> userWIthEmail = userRepository.findByEmail(
      createUserDTO.getEmail()
    );
    Optional<User> userWithUsername = userRepository.findByUsername(
      createUserDTO.getUsername()
    );

    if (
      userWIthEmail.isPresent() || userWithUsername.isPresent()
    ) throw new IllegalStateException("User already exist");

    User newUser = new User(
      createUserDTO.getUsername(),
      createUserDTO.getEmail(),
      createUserDTO.getPassword()
    );

    return userRepository.save(newUser);
  }

  public Boolean deleteUser(Long id) {
    boolean userExist = userRepository.existsById(id);

    if (!userExist) throw new IllegalStateException("User does not exist..");

    userRepository.deleteById(id);
    return true;
    // try {
    //   userRepository.deleteById(id);
    //   return true;
    // } catch (Exception e) {
    //   throw new IllegalStateException("Invalid id");
    // }
  }

  @Transactional
  public User updateUser(Long id, UpdateUserDTO updateUserDTO) {
    User user = userRepository
      .findById(id)
      .orElseThrow(
        () ->
          new IllegalStateException("Student with id " + id + " does not exist")
      );

    if (updateUserDTO.getUsername() != null) {
      user.setUsername(updateUserDTO.getUsername());
    }

    if (updateUserDTO.getEmail() != null) {
      user.setEmail(updateUserDTO.getEmail());
    }

    if (updateUserDTO.getPassword() != null) {
      user.setPassword(updateUserDTO.getPassword());
    }

    return user;
    // Second way:
    // if (
    //   username != null &&
    //   username.length() > 0 &&
    //   !Objects.equals(user.getUsername(), username)
    // ) {
    //   user.setUsername(username);
    // }

    // if (
    //   email != null &&
    //   email.length() > 0 &&
    //   !Objects.equals(user.getEmail(), email)
    // ) {
    //   Optional<User> userOptional = userRepository.findByEmail(email);

    //   if (userOptional.isPresent()) {
    //     throw new IllegalStateException("Email taken");
    //   }

    //   user.setEmail(email);
    // }

    // return user;
  }
}
