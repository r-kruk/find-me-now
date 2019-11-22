package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.models.Place;
import com.github.rkruk.findmenow.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private PlaceRepository placeRepository;

    @Autowired
    public StorageService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    private static String STORAGE_FOLDER = "c:\\temp\\";

    public boolean store(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(STORAGE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            placeRepository.save(new Place("test", file.getOriginalFilename()));
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
