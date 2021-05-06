package com.nsr.invoice.mgr;

import com.nsr.invoice.entity.InvoiceLine;
import com.nsr.invoice.model.InvoiceLineListrik;
import com.nsr.invoice.repository.InvoiceLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineManager {
    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    public InvoiceLine createOneLineListrik(InvoiceLineListrik lineListrik){
        InvoiceLine line = new InvoiceLine(lineListrik);
        return invoiceLineRepository.save(line);
    }

    public List<InvoiceLine>getInvoiceLineByType(Integer typeId){
        return invoiceLineRepository.findInvoiceLineByTypeId(typeId);
    }

    public List<InvoiceLine>getInvoiceLineByInvoiceNo(String invoiceNo){
        return invoiceLineRepository.findInvoiceLineByInvoiceNo(invoiceNo);
    }
}
