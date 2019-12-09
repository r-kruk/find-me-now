package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dtos.PlaceDTO;
import com.github.rkruk.findmenow.dtos.SchemeDTO;
import com.github.rkruk.findmenow.dtos.UserDTO;
import com.github.rkruk.findmenow.services.PlaceService;
import com.github.rkruk.findmenow.services.SchemeService;
import com.github.rkruk.findmenow.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user-details")
public class UserDetailsPageController {

    private UserService userService;
    private PlaceService placeService;
    private SchemeService schemeService;

    public UserDetailsPageController(UserService userService,
                                     PlaceService placeService,
                                     SchemeService schemeService) {
        this.userService = userService;
        this.placeService = placeService;
        this.schemeService = schemeService;
    }

    @GetMapping
    public String showUserDetailsPage(Model model,
                                      Long id,
                                      @RequestParam(name = "tab", required = false, defaultValue = "0") Long activeTab) {
        UserDTO userDTO = userService.getOne(id);
        PlaceDTO placeDTO = null;
        SchemeDTO schemeDTO = null;
        List<PlaceDTO> placeDTOS = new ArrayList<>();
        if (userDTO.getPlacesId() != null) {
            List<Long> placesId = userDTO.getPlacesId();
            for (Long placeId : placesId) {
                placeDTOS.add(placeService.getPlaceDTOById(placeId));
            }

            if (placeDTO != null && placeDTO.getSchemeId() != null) {
                schemeDTO = schemeService.getSchemeDTOById(placeDTO.getSchemeId());
            }
        }
        model.addAttribute("activeTab", activeTab);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("placeDTO", placeDTO);
        model.addAttribute("schemeDTO", schemeDTO);
        return "/WEB-INF/views/user-details.jsp";
    }
}
