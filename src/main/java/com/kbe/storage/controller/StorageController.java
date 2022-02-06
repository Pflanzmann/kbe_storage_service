package com.kbe.storage.controller;

import com.kbe.storage.model.GifInformation;
import com.kbe.storage.repository.GifInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/information")
public class StorageController {

    GifInformationRepository gifInformationRepository;

    public StorageController(GifInformationRepository gifInformationRepository) {
        this.gifInformationRepository = gifInformationRepository;
    }

    @GetMapping
    public List<GifInformation> getAllInfos() {
        return gifInformationRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<GifInformation> postNewInfos(@RequestBody GifInformation gifInformation) {
        return ResponseEntity.ok(gifInformationRepository.save(gifInformation));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<GifInformation> postNewInfos(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok(gifInformationRepository.getById(id));
    }
}
