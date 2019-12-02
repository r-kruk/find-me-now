package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.daos.SchemeDAO;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import com.github.rkruk.findmenow.utils.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    public StorageService(SchemeRepository schemeRepository, ResourceLoader resourceLoader, ModelMapper modelMapper) {
        this.schemeRepository = schemeRepository;
        this.resourceLoader = resourceLoader;
        this.modelMapper = modelMapper;
    }

    private static String STORAGE_FOLDER = "c:\\temp\\";

    public SchemeDAO storeFile(String name,
                               MultipartFile file,
                               @RequestParam(required = false, defaultValue = "") String description) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(STORAGE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return modelMapper.convert(
                    schemeRepository.save(new Scheme(name, file.getOriginalFilename(), description, false)));
        } catch (IOException e) {
            return null;
        }
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
