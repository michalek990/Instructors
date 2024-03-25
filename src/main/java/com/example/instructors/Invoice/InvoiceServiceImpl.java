package com.example.instructors.Invoice;

import com.example.instructors.Entity.GymPass;
import com.example.instructors.Entity.Invoice;
import com.example.instructors.Entity.User;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.GymPass.GymPassRepository;
import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import com.example.instructors.User.UserRepository;
import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final UserService userService;
    private final InvoiceMapper invoiceMapper;
    private final UserRepository userRepository;
    private final GymPassRepository gymPassRepository;

    @Override
    public InvoiceResponse createInvoice() {
        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber(UUID.randomUUID().toString());
        invoice.setInvoiceDate(LocalDateTime.now());

        UserDetails loggedUser = userService.getLoggedUser();
        invoice.setCustomer((User) loggedUser);

        List<GymPass> gymPasses = gymPassRepository.getAllByUserId(((User) loggedUser).getId());
        invoice.setGymPasses(gymPasses);
        if(gymPasses.isEmpty()) {
            throw new NotFoundException("You cant generate invoice! You dont have any gym passes!");
        }

        BigDecimal totalAmount = gymPasses.stream()
                .map(GymPass::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        invoice.setAmount(totalAmount);

        invoiceRepository.save(invoice);

        for(GymPass gymPass : gymPasses) {
            gymPass.setInvoice(invoice);
            gymPassRepository.save(gymPass);
        }
        return invoiceMapper.mapToResponse(invoice);
    }

    @Override
    public InvoiceResponse getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .map(invoiceMapper::mapToResponse)
                .orElseThrow(() -> new NotFoundException("Invoice not found!"));
    }

    @Override
    public List<InvoiceResponse> getAllByUserUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found!"));

        List<Invoice> invoices = invoiceRepository.findByCustomer(user);
        return invoices.stream()
                .map(invoiceMapper::mapToResponse)
                .toList();
    }

    @Override
    public Page<InvoiceResponse> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable)
                .map(invoiceMapper::mapToResponse);
    }

    @Override
    public InvoiceResponse updateInvoice(Long id, InvoiceRequest invoiceRequest) {
        Invoice invoiceToUpdate = invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice not found!"));
        invoiceToUpdate.setInvoiceNumber(invoiceRequest.getInvoiceNumber());
        invoiceToUpdate.setInvoiceDate(invoiceRequest.getInvoiceDate());

        invoiceRepository.save(invoiceToUpdate);
        return invoiceMapper.mapToResponse(invoiceToUpdate);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.delete(invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice not found!")));
    }
}
