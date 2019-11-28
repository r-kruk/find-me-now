package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dao.UserDAO;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user-panel")
public class UserPanelPageController {

    private final UserService userService;
    public UserPanelPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserPanelPage(Model model, Principal principal) {
        String username = principal.getName();
        Long id = userService.getIdOfLoggedUser(username);
        UserDAO userDAO = userService.getOne(id);
        model.addAttribute("userDAO", userDAO);
        return "/WEB-INF/views/user-panel.jsp";
    }

}
