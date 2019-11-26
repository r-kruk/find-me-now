package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.DAOs.SchemeDAO;
import com.github.rkruk.findmenow.services.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scheme-details")
public class SchemeDetailsPageController {

    SchemeService schemeService;

    @Autowired
    public SchemeDetailsPageController(SchemeService schemeService) {
        this.schemeService = schemeService;
    }

    @GetMapping
    public String showSchemeDetailsPage(Model model, Long id) {
        SchemeDAO schemeDAO = schemeService.getSchemeDAOById(id);
        model.addAttribute("schemeDAO", schemeDAO);
        return "/WEB-INF/views/scheme-details.jsp";
    }
}
