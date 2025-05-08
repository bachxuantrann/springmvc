package com.java_spring.springmvc.service.UserService;

import com.java_spring.springmvc.domain.User;
import com.java_spring.springmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hello from service";
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User newUser) {
        User user = this.userRepository.findById(id).orElse(null);
        user.setEmail(newUser.getEmail());
        user.setAddress(newUser.getAddress());
        user.setFullName(newUser.getFullName());
        user.setPhone(newUser.getPhone());
        user.setAvatar(newUser.getAvatar());
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
