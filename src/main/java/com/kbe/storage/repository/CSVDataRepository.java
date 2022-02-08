package com.kbe.storage.repository;

import com.kbe.storage.model.CSVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public interface CSVDataRepository extends JpaRepository<CSVEntity, UUID> {
}
