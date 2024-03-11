package com.example.instructors.Document;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ExportDataService {

    @Value("${pdf.css.path}")
    private String cssPath;
    private final ResourceLoader resourceLoader;

    public byte[] generatePdf() throws Exception {
        // Wczytaj plik HTML z folderu resources/templates
        Resource resource = resourceLoader.getResource("classpath:templates/pdf.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();

        return outputStream.toByteArray();
    }
}
