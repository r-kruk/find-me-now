package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private SchemeRepository schemeRepository;
    private ResourceLoader resourceLoader;

    @Autowired
    public StorageService(SchemeRepository schemeRepository, ResourceLoader resourceLoader) {
        this.schemeRepository = schemeRepository;
        this.resourceLoader = resourceLoader;
    }

    private static String STORAGE_FOLDER = "c:\\temp\\";

    public boolean storeFile(String name,
                             MultipartFile file,
                             @RequestParam(required = false, defaultValue = "") String description) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(STORAGE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            schemeRepository.save(new Scheme(name, file.getOriginalFilename(), description, false));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public Resource getFile(Long id) {
        Scheme scheme = schemeRepository.getOne(id);
        try {
            return resourceLoader.getResource("file:" + STORAGE_FOLDER + scheme.getFileName());
        } catch (EntityNotFoundException enfe) {
            return null;
        }
    }
}
