package com.kbe.storage.helper;

import com.kbe.storage.model.CSVEntity;
import com.kbe.storage.repository.CSVDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CSVImporter {

    private final String CSV_FILE_NAME = "all_informations.csv";
    private final String[] CSV_HEADER = {"id", "url", "upvotes", "downvotes", "upvoteRate", "downvoteRate", "title", "author", "description", "topic", "fileSize", "imageWidth", "imageHeight", "frameCount", "duration"};

    CSVDataRepository csvDataRepository;

    @Autowired
    public CSVImporter(CSVDataRepository csvDataRepository) {
        this.csvDataRepository = csvDataRepository;
    }

    public void generateCSV() throws IOException {
        CSVFormat format = CSVFormat.Builder.create().setHeader(CSV_HEADER).setSkipHeaderRecord(true).build();

        Reader reader = new FileReader(CSV_FILE_NAME);
        Iterable<CSVRecord> records = format.parse(reader);

        List<CSVEntity> csvEntities = new ArrayList<>();
        for (CSVRecord record : records) {
            int headerIndex = 0;

            csvEntities.add(new CSVEntity(
                    UUID.fromString(record.get(CSV_HEADER[headerIndex++])),
                    record.get(CSV_HEADER[headerIndex++]),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    Float.parseFloat(record.get(CSV_HEADER[headerIndex++])),
                    Float.parseFloat(record.get(CSV_HEADER[headerIndex++])),
                    record.get(CSV_HEADER[headerIndex++]),
                    record.get(CSV_HEADER[headerIndex++]),
                    record.get(CSV_HEADER[headerIndex++]),
                    record.get(CSV_HEADER[headerIndex++]),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    Integer.parseInt(record.get(CSV_HEADER[headerIndex++])),
                    record.get(CSV_HEADER[headerIndex++])
            ));
        }
        reader.close();

        csvDataRepository.deleteAll();
        csvDataRepository.saveAll(csvEntities);
    }
}
