package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.DAOs.UserDAO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.models.User;
import com.github.rkruk.findmenow.repositories.UserRepository;
import com.github.rkruk.findmenow.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(String username, String password, String firstName, String lastName, boolean active, String role, Place place) {
        userRepository.save(new User(username, "{noop}"+password, firstName, lastName, true, role, null));
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

}
