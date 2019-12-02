package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.daos.SchemeDAO;
import com.github.rkruk.findmenow.daos.UserDAO;
import com.github.rkruk.findmenow.models.User;
import com.github.rkruk.findmenow.repositories.UserRepository;
import com.github.rkruk.findmenow.services.SchemeService;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class DashboardPageController {

    private UserService userService;
    private SchemeService schemeService;

    @Autowired
    public DashboardPageController(SchemeService schemeService, UserService userService) {
        this.schemeService = schemeService;
        this.userService = userService;
    }

    @GetMapping
    public String showDashboardPage (Model model,
                                     @RequestParam(required = false, defaultValue = "0", name = "id") Long visibleSchemeId) {
        List<SchemeDAO> allActiveSchemeDAOs = schemeService.getAllActiveSchemeDAOs();
        model.addAttribute("allActiveSchemeDAOs", allActiveSchemeDAOs);
        model.addAttribute("visibleSchemeId", visibleSchemeId);
        return "/WEB-INF/views/dashboard.jsp";
    }

    @PostMapping
    public String userToBeFound(String search, Long id) {
        Long placeId = userService.getPlaceIdOfSearchedUser(search);
        return "redirect:/?id=" + placeId;
    }

}
