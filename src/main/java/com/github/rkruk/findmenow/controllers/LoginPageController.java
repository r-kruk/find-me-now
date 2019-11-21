package com.github.rkruk.findmenow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "/WEB-INF/views/login-page.jsp";
    }

    @GetMapping("/logout")
    public String showPageAfterLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
