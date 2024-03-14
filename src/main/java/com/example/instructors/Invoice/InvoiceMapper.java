package com.example.instructors.Invoice;

import com.example.instructors.Entity.Invoice;
import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "customer.firstname", source = "customerFirstname")
    @Mapping(target = "customer.lastname", source = "customerLastname")
    Invoice mapToInvoice(InvoiceRequest invoiceRequest);

    @Mapping(target = "customerFirstname", source = "customer.firstname")
    @Mapping(target = "customerLastname", source = "customer.lastname")
    @Mapping(target = "customerEmail" , source = "customer.email")
    @Mapping(target = "instructorFirstname", source = "instructor.firstname")
    @Mapping(target = "instructorLastname", source = "instructor.lastname")
    @Mapping(target = "instructorEmail", source = "instructor.email")
    InvoiceResponse mapToResponse(Invoice invoice);
}
