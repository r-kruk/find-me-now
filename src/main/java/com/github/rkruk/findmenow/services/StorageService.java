package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private SchemeRepository schemeRepository;

    @Autowired
    public StorageService(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    private static String STORAGE_FOLDER = "c:\\temp\\";

    public boolean store(String name, MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(STORAGE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            schemeRepository.save(new Scheme(name, file.getOriginalFilename()));
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
