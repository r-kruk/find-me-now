package com.github.rkruk.findmenow.services;

import com.github.rkruk.findmenow.dtos.SchemeDTO;
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

    public List<SchemeDTO> getAllSchemeDTOs() {
        List<Scheme> allSchemes = schemeRepository.findAll();
        List<SchemeDTO> allSchemesDTO = new ArrayList<>();
        for (Scheme scheme : allSchemes) {
            allSchemesDTO.add(modelMapper.convert(scheme));
        }
        return allSchemesDTO;
    }

    public SchemeDTO getSchemeDTOById(Long id) {
        return modelMapper.convert(schemeRepository.getOne(id));
    }

    public List<SchemeDTO> getAllActiveSchemeDTOs() {
        List<Scheme> allActiveSchemes = schemeRepository.findAllByActiveIsTrue();
        List<SchemeDTO> allActiveSchemesDTO = new ArrayList<>();
        for (Scheme scheme : allActiveSchemes) {
            allActiveSchemesDTO.add(modelMapper.convert(scheme));
        }
        return allActiveSchemesDTO;
    }

    public void activateScheme(Long id) {
        Scheme scheme = schemeRepository.getOne(id);
        scheme.setActive(true);
        schemeRepository.save(scheme);
    }

    public void deactivateScheme(Long id) {
        Scheme scheme = schemeRepository.getOne(id);
        scheme.setActive(false);
        schemeRepository.save(scheme);
    }
}
