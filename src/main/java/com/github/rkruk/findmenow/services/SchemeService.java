package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {

    private SchemeRepository schemeRepository;

    @Autowired
    public SchemeService(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }
}
