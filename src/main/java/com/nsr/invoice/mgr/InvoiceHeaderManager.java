package com.nsr.invoice.mgr;

import com.nsr.commons.exception.NsrException;
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
        List<InvoiceHeader> headerList= invoiceHeaderRepository.getInvoiceHeaderByTypeId(typeId);
        if (headerList.isEmpty()){
            throw new NsrException(String.format("Invoice with type id : %s not found",typeId));
        }
        return headerList;
    }
    public List<InvoiceHeader>getAllInvoice(){
        return invoiceHeaderRepository.findAll();
    }
    public InvoiceHeader getInvoiceHeaderByInvoiceNo(String invoiceNo){
        InvoiceHeader header= invoiceHeaderRepository.getInvoiceHeaderByInvoiceNo(invoiceNo);
        if (header == null){
            throw new NsrException(String.format("Invoice with number : %s not found",invoiceNo));
        }
        return header;
    }
}
