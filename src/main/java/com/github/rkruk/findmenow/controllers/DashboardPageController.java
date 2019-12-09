package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dtos.OccupiedPlaceInSchemeDTO;
import com.github.rkruk.findmenow.dtos.PlaceDTO;
import com.github.rkruk.findmenow.dtos.SchemeDTO;
import com.github.rkruk.findmenow.dtos.UserDTO;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.PlaceRepository;
import com.github.rkruk.findmenow.services.PlaceService;
import com.github.rkruk.findmenow.services.SchemeService;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class DashboardPageController {

    private PlaceService placeService;
    private UserService userService;
    private SchemeService schemeService;


    @Autowired
    public DashboardPageController(PlaceService placeService, SchemeService schemeService, UserService userService) {
        this.placeService = placeService;
        this.schemeService = schemeService;
        this.userService = userService;
    }

    @GetMapping
    public String showDashboardPage (Model model,
                                     @RequestParam(required = false, defaultValue = "0", name = "id") Long visibleSchemeId,
                                     @RequestParam(required = false, defaultValue = "-1", name = "x") Long coordinateX,
                                     @RequestParam(required = false, defaultValue = "-1", name = "y") Long coordinateY,
                                     @RequestParam(required = false, defaultValue = "", name = "lastName") String lastName) {
        List<SchemeDTO> allActiveSchemeDTOS = schemeService.getAllActiveSchemeDTOs();
        model.addAttribute("allActiveSchemeDTOS", allActiveSchemeDTOS);
        if (visibleSchemeId.equals(0L)) {
            visibleSchemeId = allActiveSchemeDTOS.get(0).getId();
        }
        model.addAttribute("visibleSchemeId", visibleSchemeId);
        model.addAttribute("coordinateX", coordinateX);
        model.addAttribute("coordinateY", coordinateY);
        model.addAttribute("lastName", lastName);
        return "/WEB-INF/views/dashboard.jsp";
    }

    @PostMapping
    public String userToBeFound(String search) {
        OccupiedPlaceInSchemeDTO occupiedPlaceInSchemeDTO = userService.getPlaceIdOfSearchedUser(search);
        PlaceDTO placeDTO = placeService.getPlaceDTOById(occupiedPlaceInSchemeDTO.getPlaceId());
        SchemeDTO schemeDTO = schemeService.getSchemeDTOById(occupiedPlaceInSchemeDTO.getSchemeId());
        UserDTO userDTO = userService.getOne(occupiedPlaceInSchemeDTO.getUserId());
        Long coordinateX = placeDTO.getCoordinateX();
        Long coordinateY = placeDTO.getCoordinateY();
        Long schemeId = schemeDTO.getId();
        String lastName = userDTO.getLastName();

        return "redirect:/?id=" + schemeId + "&x=" + coordinateX + "&y=" + coordinateY + "&lastName=" + lastName;
    }

}
