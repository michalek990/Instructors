package com.example.instructors.Document;

import com.example.instructors.Entity.User;
import com.example.instructors.Invoice.InvoiceService;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportDataService {

    private final ResourceLoader resourceLoader;
    private final InvoiceService invoiceService;
    private final UserService userService;
    public byte[] generatePdf() throws Exception {
        User loggedUser = (User) userService.getLoggedUser();
        Resource resource = resourceLoader.getResource("classpath:templates/pdf.html");

        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));
        htmlContent = htmlContent.replace("<!--{date}-->", new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime()));
        htmlContent = htmlContent.replace("<!--{customerFirstname}-->", loggedUser.getFirstname());
        htmlContent = htmlContent.replace("<!--{customerLastname}-->", loggedUser.getLastname());

        List<InvoiceResponse> invoices = invoiceService.getAllByUserUsername(loggedUser.getUsername());
        BigDecimal totalAmount = invoices.stream().map(InvoiceResponse::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        StringBuilder invoiceRows = new StringBuilder();
        for (InvoiceResponse invoice : invoices) {
            invoiceRows.append("<tr>")
                    .append("<td>").append(invoice.getInvoiceNumber()).append("</td>")
                    .append("<td>").append(invoice.getInvoiceDate()).append("</td>")
                    .append("<td>").append(invoice.getAmount()).append("$</td>")
                    .append("</tr>");
        }
        htmlContent = htmlContent.replace("<!--{faktury}-->", invoiceRows.toString());
        htmlContent = htmlContent.replace("<!--{totalAmount}-->", totalAmount.toString());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        return outputStream.toByteArray();
    }
}
