package com.github.rkruk.findmenow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user-panel")
public class UserPanelPageController {

    @GetMapping
    public String showUserPanelPage() {
        return "/WEB-INF/views/user-panel.jsp";
    }
}
