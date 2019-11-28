package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.daos.UserDAO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.models.User;
import com.github.rkruk.findmenow.repositories.UserRepository;
import com.github.rkruk.findmenow.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password, String firstName, String lastName, boolean active, String role, Place place) {
        userRepository.save(new User(username, passwordEncoder.encode(password), firstName, lastName, true, role, null));
    }

    public UserDAO getOne(Long id) {
        User user = userRepository.getOne(id);
        return modelMapper.convert(user);
    }

    public Long getIdOfLoggedUser(String username) {
        User user = userRepository.findByUsernameEquals(username);
        return user.getId();
    }

    public List<UserDAO> getAllUserDAOs() {
        List<User> allUsers = userRepository.findAll();
        List<UserDAO> allUserDAOs = new ArrayList<>();
        for (User user : allUsers) {
            allUserDAOs.add(modelMapper.convert(user));
        }
        return allUserDAOs;
    }

    public void activateUser(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(true);
        userRepository.save(user);
    }

    public void deactivateUser(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(false);
        userRepository.save(user);
    }
}
