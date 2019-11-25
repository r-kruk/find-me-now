package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceService (PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
