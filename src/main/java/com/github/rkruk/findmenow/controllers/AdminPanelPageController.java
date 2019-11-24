package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.DAOs.SchemeDAO;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.services.SchemeService;
import com.github.rkruk.findmenow.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin-panel")
public class AdminPanelPageController {

    private StorageService storageService;
    private SchemeService schemeService;

    @Autowired
    public AdminPanelPageController(StorageService storageService, SchemeService schemeService) {
        this.storageService = storageService;
        this.schemeService = schemeService;
    }

    @GetMapping
    public String showAdminPanelPage(Model model) {
        List<Scheme> allSchemes = schemeService.getAllSchemes();
        List<SchemeDAO> allSchemeDAOs = new ArrayList<>();
        for (Scheme scheme : allSchemes) {
            allSchemeDAOs.add(
                    new SchemeDAO(
                            scheme.getId(),
                            scheme.getName(),
                            scheme.getFileName()));
        }
        model.addAttribute("allSchemeDAOs", allSchemeDAOs);
        return "/WEB-INF/views/admin-panel.jsp";
    }

    @GetMapping("/add-scheme")
    public String showPlansManagementPage() {
        return "/WEB-INF/views/add-scheme.jsp";
    }

    @PostMapping("/add-scheme")
    public String storeFileWithPlan(String name, MultipartFile file) {
        storageService.storeFile(name, file);
        return "redirect:/admin-panel";
    }
}
