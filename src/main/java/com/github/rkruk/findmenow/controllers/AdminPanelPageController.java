package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.daos.SchemeDAO;
import com.github.rkruk.findmenow.daos.UserDAO;
import com.github.rkruk.findmenow.services.SchemeService;
import com.github.rkruk.findmenow.services.StorageService;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin-panel")
public class AdminPanelPageController {

    private StorageService storageService;
    private SchemeService schemeService;
    private UserService userService;

    @Autowired
    public AdminPanelPageController(StorageService storageService,
                                    SchemeService schemeService,
                                    UserService userService) {
        this.storageService = storageService;
        this.schemeService = schemeService;
        this.userService = userService;
    }

    @GetMapping
    public String showAdminPanelPage(Model model,
                                     @RequestParam(name = "tab", required = false, defaultValue = "0") Long tabNumber) {
        model.addAttribute("tabNumber", tabNumber);
        List<SchemeDAO> allSchemeDAOs = new ArrayList<>();
        List<UserDAO> allUserDAOs = new ArrayList<>();
        if (tabNumber == 0) {
            allSchemeDAOs = schemeService.getAllSchemeDAOs();
        } else if (tabNumber == 1) {
            allUserDAOs = userService.getAllUserDAOs();
        }
        model.addAttribute("allSchemeDAOs", allSchemeDAOs);
        model.addAttribute("allUserDAOs", allUserDAOs);
        return "/WEB-INF/views/admin-panel.jsp";
    }

    @GetMapping("/add-scheme")
    public String showPlansManagementPage() {
        return "/WEB-INF/views/add-scheme.jsp";
    }

    @PostMapping("/add-scheme")
    public String storeFileWithPlan(String name, MultipartFile file, String description) {
        storageService.storeFile(name, file, description);
        return "redirect:/admin-panel";
    }

    @GetMapping("/activate-scheme")
    public String activateScheme(Long id) {
        schemeService.activateScheme(id);
        return "redirect:/admin-panel";
    }

    @GetMapping("/deactivate-scheme")
    public String deactivateScheme(Long id) {
        schemeService.deactivateScheme(id);
        return "redirect:/admin-panel";
    }

    @GetMapping("/activate-user")
    public String activateUser(Long id) {
        userService.activateUser(id);
        return "redirect:/admin-panel";
    }

    @GetMapping("/deactivate-user")
    public String deactivateUser(Long id) {
        userService.deactivateUser(id);
        return "redirect:/admin-panel";
    }
}
