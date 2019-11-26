package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.DAOs.SchemeDAO;
import com.github.rkruk.findmenow.models.Scheme;
import com.github.rkruk.findmenow.repositories.SchemeRepository;
import com.github.rkruk.findmenow.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchemeService {

    private SchemeRepository schemeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SchemeService(SchemeRepository schemeRepository, ModelMapper modelMapper) {
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }

    public List<SchemeDAO> getAllSchemeDAOs() {
        List<Scheme> allSchemes = schemeRepository.findAll();
        List<SchemeDAO> allSchemesDAO = new ArrayList<>();
        for (Scheme scheme : allSchemes) {
            allSchemesDAO.add(modelMapper.convert(scheme));
        }
        return allSchemesDAO;
    }

    public SchemeDAO getSchemeDAOById(Long id) {
        return modelMapper.convert(schemeRepository.getOne(id));
    }

    public List<SchemeDAO> getAllActiveSchemeDAOs() {
        List<Scheme> allActiveSchemes = schemeRepository.findAllByActiveIsTrue();
        List<SchemeDAO> allActiveSchemesDAO = new ArrayList<>();
        for (Scheme scheme : allActiveSchemes) {
            allActiveSchemesDAO.add(modelMapper.convert(scheme));
        }
        return allActiveSchemesDAO;
    }
}
