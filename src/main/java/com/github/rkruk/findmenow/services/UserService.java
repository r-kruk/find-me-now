package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.DAOs.UserDAO;
import com.github.rkruk.findmenow.models.User;
import com.github.rkruk.findmenow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password, String firstName, String lastName) {
        userRepository.save(new User(username, "{noop}"+password, firstName, lastName, null));
    }

    public UserDAO getOne(Long id) {
        User user = userRepository.getOne(id);
        UserDAO userDAO = new UserDAO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), null);
        return userDAO;
    }

    public Long getIdOfLoggedUser(String username) {
        User user = userRepository.findByUsernameEquals(username);
        return user.getId();
    }

}
