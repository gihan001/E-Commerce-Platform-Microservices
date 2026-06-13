package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // මේක එකතු කරන්න
import org.springframework.stereotype.Service;
import com.ecommerce.user.config.JwtUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // SecurityConfig එකෙන් මෙතැනට Inject වේ

    public User registerUser(User user) {
        // ලැබෙන Password එක BCrypt මඟින් Encrypt කර නැවත සකස් කිරීම
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Autowired
    private JwtUtils jwtUtils; // JwtUtils මෙතැනට Inject කරගැනීම

    public String loginUser(String username, String password) {
        java.util.Optional<User> user = userRepository.findByUsername(username);

        // 1. පරිශීලකයා ඉන්නවාදැයි බැලීම සහ Encrypted password එක ගැලපේදැයි බැලීම
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            // 2. දත්ත නිවැරදි නම් රහසිගත JWT ටෝකන් එකක් සාදා ආපසු යැවීම
            return jwtUtils.generateToken(user.get().getUsername(), user.get().getRole());
        }

        return "Invalid Credentials!";
    }
}