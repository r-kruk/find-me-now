package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.daos.PlaceDAO;
import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.repositories.PlaceRepository;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import com.github.rkruk.findmenow.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;
    private SchemeRepository schemeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, SchemeRepository schemeRepository, ModelMapper modelMapper) {
        this.placeRepository = placeRepository;
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }


    public void addPlace(Long schemeId, String name, Long positionX, Long positionY) {
        placeRepository.save(new Place(name, "", schemeRepository.getOne(schemeId), positionX, positionY));
    }

    public List<PlaceDAO> getAllPlaceDAOs() {
        List<Place> allPlaces = placeRepository.findAll();
        List<PlaceDAO> allPlacesDAO = new ArrayList<>();
        for (Place place : allPlaces) {
            allPlacesDAO.add(modelMapper.convert(place));
        }
        return allPlacesDAO;
    }
}
