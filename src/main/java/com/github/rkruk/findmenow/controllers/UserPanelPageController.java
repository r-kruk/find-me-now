package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.models.User;
import com.github.rkruk.findmenow.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-panel")
public class UserPanelPageController {

    private final UserRepository userRepository;

    public UserPanelPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showUserPanelPage() {
        return "/WEB-INF/views/user-panel.jsp";
    }

//    @GetMapping
//    public User getUser(@PathVariable Long id) {
//        User one = userRepository.getOne(id);
//        return one;
//    }
}
