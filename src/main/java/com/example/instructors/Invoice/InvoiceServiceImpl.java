package com.example.instructors.Invoice;

import com.example.instructors.Components.Aspect.InstructorOnly;
import com.example.instructors.Entity.Invoice;
import com.example.instructors.Entity.User;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import com.example.instructors.User.UserRepository;
import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@InstructorOnly
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final UserService userService;
    private final InvoiceMapper invoiceMapper;
    private final UserRepository userRepository;

    @Override
    public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest) {
        Invoice invoice = invoiceMapper.mapToInvoice(invoiceRequest);

        UserDetails instructor = userService.getLoggedUser();
        invoice.setInstructor((User) instructor);

        User customer = userRepository.findByLastnameAndFirstname(invoiceRequest.getCustomerLastname(), invoiceRequest.getCustomerFirstname())
                .orElseThrow(() -> new NotFoundException("Customer not found!"));
        invoice.setCustomer(customer);

        invoiceRepository.save(invoice);
        return invoiceMapper.mapToResponse(invoice);
    }

    @Override
    public InvoiceResponse getInvoiceById(Long id) {
        return null;
    }

    @Override
    public Page<InvoiceResponse> getAllInvoices(Pageable pageable) {
        return null;
    }

    @Override
    public InvoiceResponse updateInvoice(Long id, InvoiceRequest invoiceRequest) {
        return null;
    }

    @Override
    public void deleteInvoice(Long id) {

    }
}
