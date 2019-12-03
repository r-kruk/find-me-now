package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dtos.UserDTO;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user-details")
public class UserDetailsPageController {

    private UserService userService;

    public UserDetailsPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserDetailsPage(Model model,
                                      Long id,
                                      @RequestParam(name = "tab", required = false, defaultValue = "0") Long activeTab) {
        UserDTO userDTO = userService.getOne(id);
        model.addAttribute("activeTab", activeTab);
        model.addAttribute("userDTO", userDTO);
        return "/WEB-INF/views/user-details.jsp";
    }
}
