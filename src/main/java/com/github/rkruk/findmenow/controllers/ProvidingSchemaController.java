package com.github.rkruk.findmenow.controllers;

import com.github.rkruk.findmenow.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/scheme")
public class ProvidingSchemaController {

    private StorageService storageService;

    @Autowired
    public ProvidingSchemaController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] showScheme(Long id) throws IOException {
        InputStream in = storageService.getFile(id).getInputStream();
        return FileCopyUtils.copyToByteArray(in);
    }
}
