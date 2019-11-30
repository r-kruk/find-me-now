package com.github.rkruk.findmenow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/help")
public class HelpPageController {

    @GetMapping
    public String showHelpPage(Model model,
                               @RequestParam(name = "tab", required = false, defaultValue = "0") Long tabNumber) {
        model.addAttribute("tabNumber", tabNumber);
        return "/WEB-INF/views/help.jsp";
    }
}
