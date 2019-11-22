package com.github.rkruk.findmenow.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private static String STORAGE_FOLDER = "c:\\temp\\";

    public boolean store(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(STORAGE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
