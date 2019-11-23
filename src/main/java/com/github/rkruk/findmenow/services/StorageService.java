package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public boolean storeFile(String name, MultipartFile file) {
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

    public Resource getFile(Long id) throws IOException {
        Scheme scheme = schemeRepository.getOne(id);
        return resourceLoader.getResource("file:" + STORAGE_FOLDER + scheme.getFileName());
    }
}
