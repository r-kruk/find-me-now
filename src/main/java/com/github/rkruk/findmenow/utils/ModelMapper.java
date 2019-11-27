package com.github.rkruk.findmenow.utils;

import com.github.rkruk.findmenow.DAOs.SchemeDAO;
import com.github.rkruk.findmenow.DAOs.UserDAO;
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
                placeId);
    }
}
