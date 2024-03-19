package com.example.instructors.Invoice;

import com.example.instructors.Entity.Invoice;
import com.example.instructors.Entity.User;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByCustomer(User customer);
}
