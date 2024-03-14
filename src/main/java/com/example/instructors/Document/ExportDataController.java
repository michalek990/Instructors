package com.example.instructors.Document;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class ExportDataController {

    private final ExportDataService exportDataService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePDF() throws Exception {
        byte[] pdfContent = exportDataService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DataGenerated.pdf").build());

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
