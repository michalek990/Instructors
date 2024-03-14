package com.example.instructors.Document;

import com.example.instructors.City.CityMapper;
import com.example.instructors.City.CityRepository;
import com.example.instructors.City.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExportDataService {

    private final ResourceLoader resourceLoader;
    private final CityRepository cityRepository; // Załóżmy, że takie repozytorium istnieje
    private final CityMapper cityMapper;

    public byte[] generatePdf() throws Exception {
        // Pobierz dane z bazy danych
        List<CityResponse> cities = cityRepository.findAll().stream().map(cityMapper::mapToResponse).collect(Collectors.toList());

        // Wczytaj szablon HTML jako String
        Resource resource = resourceLoader.getResource("classpath:templates/pdf.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
        String currentMonth = dateFormat.format(Calendar.getInstance().getTime());

        htmlContent = htmlContent.replace("    <title>Raport za miesiąc {miesiac}</title>\n", currentMonth);
        StringBuilder rows = new StringBuilder();
        for (CityResponse city : cities) {
            rows.append("<tr>")
                    .append("<td>").append(city.getId()).append("</td>")
                    .append("<td>").append(city.getName()).append("</td>")
                    .append("</tr>");
        }
        htmlContent = htmlContent.replace("<!-- Tutaj wstaw wiersze tabeli z danymi -->", rows.toString());

        // Utwórz PDF
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();

        return outputStream.toByteArray();
    }
}
