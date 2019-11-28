package com.github.rkruk.findmenow.utils;


import com.github.rkruk.findmenow.daos.PlaceDAO;
import com.github.rkruk.findmenow.daos.SchemeDAO;
import com.github.rkruk.findmenow.daos.UserDAO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.models.User;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public SchemeDAO convert(Scheme scheme) {
        return new SchemeDAO(
                scheme.getId(),
                scheme.getName(),
                scheme.getFileName(),
                scheme.getDescription(),
                scheme.getActive());
    }

    public UserDAO convert(User user) {
        Long placeId = null;
        if (user.getPlace() != null) {
            placeId = user.getPlace().getId();
        }
        return new UserDAO(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getActive(),
                user.getRole(),
                placeId);
    }

    public PlaceDAO convert(Place place) {
        Long schemeId = null;
        if (place.getScheme() != null) {
            schemeId = place.getScheme().getId();
        }
        return new PlaceDAO(
                place.getId(),
                place.getName(),
                place.getDescription(),
                place.getCoordinateX(),
                place.getCoordinateY(),
                schemeId);
    }
}
