package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    To be added GetMappring by przejsc na registration page
//    to be added Post mapping by dodac dane z formularza do lisy userow
}
