package com.example.instructors.Components.Data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data-loader")
public class DataLoaderController {

    private final DataLoader dataLoader;
    @GetMapping("/load-data")
    public ResponseEntity<String> loadData() {
        try {
            dataLoader.executeDataScript();
            return ResponseEntity.ok("Dane zostały pomyślnie załadowane.");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Wystąpił błąd podczas ładowania danych: " + e.getMessage());
        }
    }

    @GetMapping("/clear-data")
    public ResponseEntity<String> clearData() {
        try {
            dataLoader.clearDatabase();
            return ResponseEntity.ok("Baza danych została pomyślnie wyczyszczona.");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Wystąpił błąd podczas czyszczenia bazy danych: " + e.getMessage());
        }
    }
}
