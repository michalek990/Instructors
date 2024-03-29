package com.example.instructors.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class LoadDataToRedis {
    @PostConstruct
    public void runScript() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Tutaj podaj ścieżkę do Twojego skryptu
        processBuilder.command("bash", "-c", "src/main/resources/transfer_pg_to_redis.sh");

        try {
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Skrypt zakończył działanie pomyślnie");
            } else {
                // Obsługa błędów
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
