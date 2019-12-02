package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.daos.UserDAO;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user-panel")
public class UserPanelPageController {

    private final UserService userService;
    public UserPanelPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserPanelPage(Model model,
                                    Principal principal,
                                    @RequestParam(name = "tab", required = false, defaultValue = "0") Long activeTab) {
        String username = principal.getName();
        Long id = userService.getIdOfLoggedUser(username);
        UserDAO userDAO = userService.getOne(id);
        model.addAttribute("userDAO", userDAO);
        model.addAttribute("activeTab", activeTab);
        return "/WEB-INF/views/user-panel.jsp";
    }

    @GetMapping("/deactivate-user")
    public String deactivateUser(Principal principal,
                                 Long id) {
        // TODO: 02.12.2019 Add implementation for user deactivate
        return "";
    }
}
