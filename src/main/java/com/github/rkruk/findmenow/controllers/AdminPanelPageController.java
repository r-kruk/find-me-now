package com.github.rkruk.findmenow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin-panel")
public class AdminPanelPageController {

    @GetMapping
    public String showAdminPanelPage() {
        return "/WEB-INF/views/admin-panel.jsp";
    }
}
