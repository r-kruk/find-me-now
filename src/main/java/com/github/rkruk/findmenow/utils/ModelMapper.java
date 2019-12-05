package com.github.rkruk.findmenow.utils;


import com.github.rkruk.findmenow.dtos.PlaceDTO;
import com.github.rkruk.findmenow.dtos.SchemeDTO;
import com.github.rkruk.findmenow.dtos.UserDTO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.models.User;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public SchemeDTO convert(Scheme scheme) {
        return new SchemeDTO(
                scheme.getId(),
                scheme.getName(),
                scheme.getFileName(),
                scheme.getDescription(),
                scheme.getActive());
    }

    public UserDTO convert(User user) {
        Long placeId = null;
        if (user.getPlace() != null) {
            placeId = user.getPlace().getId();
        }
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getActive(),
                user.getRole(),
                placeId);
    }

    public PlaceDTO convert(Place place) {
        Long schemeId = null;
        if (place.getScheme() != null) {
            schemeId = place.getScheme().getId();
        }
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getDescription(),
                place.getCoordinateX(),
                place.getCoordinateY(),
                schemeId);
    }



}
