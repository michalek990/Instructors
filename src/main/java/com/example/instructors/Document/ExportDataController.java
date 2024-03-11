package com.example.instructors.Document;

import lombok.RequiredArgsConstructor;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class ExportDataController {

    @Value("${template.html.path}")
    private String link;

    private final ExportDataService exportDataService;

//    @GetMapping("/generate-pdf")
//    public ResponseEntity<byte[]> generatePDF() throws DocumentException, IOException {
//            String htmlContent = new String(Files.readAllBytes(Paths.get(link)));
//            byte[] pdfContent = exportDataService.htmlToPdf(htmlContent);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DataGenerated.pdf").build());
//
//            return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
//    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePDF() throws Exception {
        byte[] pdfContent = exportDataService.generatePdf(); // Wywołanie metody generującej PDF

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Tutaj można dodać więcej nagłówków, np. Content-Disposition, aby przeglądarka zaczęła pobieranie pliku
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DataGenerated.pdf").build());

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
