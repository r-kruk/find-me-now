package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.dtos.PlaceDTO;
import com.github.rkruk.findmenow.dtos.SchemeDTO;
import com.github.rkruk.findmenow.dtos.UserDTO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.models.User;
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

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user-panel")
public class UserPanelPageController {

    private final UserService userService;
    private PlaceService placeService;
    private SchemeService schemeService;


    @Autowired
    public UserPanelPageController(UserService userService, PlaceService placeService, SchemeService schemeService) {
        this.userService = userService;
        this.placeService = placeService;
        this.schemeService = schemeService;
    }

    @GetMapping
    public String showUserPanelPage(Model model,
                                    Principal principal,
                                    @RequestParam(name = "tab", required = false, defaultValue = "0") Long activeTab) {
        String username = principal.getName();
        Long id = userService.getIdOfLoggedUser(username);
        UserDTO userDTO = userService.getOne(id);
        PlaceDTO placeDTO = null;
        SchemeDTO schemeDTO = null;
        if (userDTO.getPlaceId() != null) {
            placeDTO = placeService.getPlaceDTOById(userDTO.getPlaceId());
        }
        if (placeDTO != null && placeDTO.getSchemeId() != null) {
            schemeDTO = schemeService.getSchemeDTOById(placeDTO.getSchemeId());
        }
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("activeTab", activeTab);
        model.addAttribute("placeDTO", placeDTO);
        model.addAttribute("schemeDTO", schemeDTO);
        return "/WEB-INF/views/user-panel.jsp";
    }

    @GetMapping("/deactivate-user")
    public String deactivateUser(Principal principal,
                                 Long id) {
        String username = principal.getName();
        Long loggedUserId = userService.getIdOfLoggedUser(username);
        if (loggedUserId.equals(id)) {
            userService.deactivateUser(id);
        }
        else {
            return "redirect:/";
        }
        return "redirect:/logout";
    }

    @GetMapping("/take-place")
    public String showTakePlacePage(Model model,
                                    @RequestParam(required = false, defaultValue = "0", name = "id") Long visibleSchemeId) {
        List<SchemeDTO> allActiveSchemeDTOS = schemeService.getAllActiveSchemeDTOs();
        model.addAttribute("allActiveSchemeDTOS", allActiveSchemeDTOS);
        model.addAttribute("visibleSchemeId", visibleSchemeId);
        List<PlaceDTO> availablePlaceDTOS = placeService.getAllFreePlaceDTOBySchemeId(visibleSchemeId);
        model.addAttribute("availablePlaceDTOS", availablePlaceDTOS);

        // TODO: 03.12.2019 Create JSP page ("take-place.jsp" will be good)
        return "/WEB-INF/views/take-place.jsp";
    }

    @PostMapping("/take-place")
    public String takePlace(Principal principal, String placeName) {
        PlaceDTO placeDTO = placeService.getPlaceDTOByName(placeName);
        String username = principal.getName();
        Long id = userService.getIdOfLoggedUser(username);
        UserDTO userDTO = userService.getOne(id);
        userService.bookPlaceForUser(userDTO, placeDTO);

        // TODO: 03.12.2019 Make user able to take place
        return "redirect:/user-panel";
    }


}
