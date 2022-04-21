package com.User;

import java.util.List;

import com.User.DTOs.CreateUserDTO;

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

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User registeUser(@RequestBody CreateUserDTO createUserDTO) {
        User newUser = new User(
                createUserDTO.getUsername(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword()
        );
        
        return userRepository.save(newUser);
    }
}
