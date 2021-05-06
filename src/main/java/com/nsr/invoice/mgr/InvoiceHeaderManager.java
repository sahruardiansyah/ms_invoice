package com.nsr.invoice.mgr;

import com.nsr.invoice.entity.InvoiceHeader;
import com.nsr.invoice.repository.InvoiceHeaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceHeaderManager {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceHeaderManager.class);
    @Autowired
    InvoiceHeaderRepository invoiceHeaderRepository;

    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader){
        return invoiceHeaderRepository.save(invoiceHeader);
    }
    public InvoiceHeader updateInvoiceHeader(InvoiceHeader invoiceHeader){
        return invoiceHeaderRepository.save(invoiceHeader);
    }
    public List<InvoiceHeader>getIvoiceHeaderByTypeId(Integer typeId){
        return invoiceHeaderRepository.getInvoiceHeaderByTypeId(typeId);
    }
    public List<InvoiceHeader>getAllInvoice(){
        return invoiceHeaderRepository.findAll();
    }
}
