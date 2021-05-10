package com.nsr.invoice.repository;

import com.nsr.invoice.entity.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Integer> {
    List<InvoiceHeader>getInvoiceHeaderByTypeId(Integer typeId);
    InvoiceHeader getInvoiceHeaderByInvoiceNo(String invoiceNo);
}
