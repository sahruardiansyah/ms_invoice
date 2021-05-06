package com.nsr.invoice.repository;

import com.nsr.invoice.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Integer> {
    List<InvoiceLine> findInvoiceLineByTypeId(Integer typeId);
    List<InvoiceLine> findInvoiceLineByInvoiceNo(String invoiceNo);


}
