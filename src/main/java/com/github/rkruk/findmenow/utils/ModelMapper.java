package com.github.rkruk.findmenow.utils;

import com.github.rkruk.findmenow.DAOs.SchemeDAO;
import com.github.rkruk.findmenow.models.Scheme;
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
}
