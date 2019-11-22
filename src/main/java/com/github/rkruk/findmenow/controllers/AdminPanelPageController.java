package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin-panel")
public class AdminPanelPageController {

    private StorageService storageService;

    @Autowired
    public AdminPanelPageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public String showAdminPanelPage() {
        return "/WEB-INF/views/admin-panel.jsp";
    }

    @GetMapping("/plans")
    public String showPlansManagementPage() {
        return "/WEB-INF/views/plans.jsp";
    }

    @PostMapping("/plans")
    public String storeFileWithPlan(MultipartFile file) {
        storageService.store(file);
        return "redirect:/admin-panel";
    }
}
