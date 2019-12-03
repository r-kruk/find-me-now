package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dtos.PlaceDTO;
import com.github.rkruk.findmenow.dtos.SchemeDTO;
import com.github.rkruk.findmenow.services.PlaceService;
import com.github.rkruk.findmenow.services.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/scheme-details")
public class SchemeDetailsPageController {

    private SchemeService schemeService;
    private PlaceService placeService;

    @Autowired
    public SchemeDetailsPageController(SchemeService schemeService, PlaceService placeService) {
        this.schemeService = schemeService;
        this.placeService = placeService;
    }

    @GetMapping
    public String showSchemeDetailsPage(Model model, Long id) {
        SchemeDTO schemeDTO = schemeService.getSchemeDTOById(id);
        List<PlaceDTO> allPlaceDTOS = placeService.getAllPlaceDTOsBySchemeId(id);
        model.addAttribute("schemeDTO", schemeDTO);
        model.addAttribute("allPlaceDTOs", allPlaceDTOS);
        return "/WEB-INF/views/scheme-details.jsp";
    }
}
