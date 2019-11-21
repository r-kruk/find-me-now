package com.github.rkruk.findmenow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardPageController {

    @GetMapping
    public String showDashboardPage () {
        return "/WEB-INF/views/dashboard.jsp";
    }
}
