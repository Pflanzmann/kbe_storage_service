package com.kbe.storage.controller;

import com.kbe.storage.helper.CSVImporter;
import com.kbe.storage.model.GifInformation;
import com.kbe.storage.repository.GifInformationRepository;
import com.kbe.storage.sftp.FileTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/information")
public class StorageController {

    private GifInformationRepository gifInformationRepository;
    private FileTransferService fileTransferService;
    private CSVImporter csvImporter;

    @Autowired
    public StorageController(GifInformationRepository gifInformationRepository, FileTransferService fileTransferService, CSVImporter csvImporter) {
        this.fileTransferService = fileTransferService;
        this.gifInformationRepository = gifInformationRepository;
        this.csvImporter = csvImporter;
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

    @GetMapping("/export")
    @ResponseBody
    public ResponseEntity<String> exportData() {
        fileTransferService.downloadFile("all_informations.csv", "all_informations.csv");

        try {
            csvImporter.generateCSV();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Successfully imported");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> exportData(@PathVariable(value = "id") UUID id) {
        gifInformationRepository.deleteById(id);

        return ResponseEntity.ok("Successfully deleted");
    }
}
