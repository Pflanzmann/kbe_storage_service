package com.kbe.storage.controller;

import com.kbe.storage.model.GifInformation;
import com.kbe.storage.repository.GifInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/storage")
public class StorageController {

    GifInformationRepository gifInformationRepository;

    @Autowired
    public StorageController(GifInformationRepository gifInformationRepository) {
        this.gifInformationRepository = gifInformationRepository;
    }

    @GetMapping
    public List<GifInformation> getAllInfos() {
        return gifInformationRepository.findAll();
    }
}
