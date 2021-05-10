package com.nsr.invoice.controller;

import com.nsr.commons.exception.NsrException;
import com.nsr.commons.web.rest.util.RestUtils;
import com.nsr.invoice.entity.InvoiceLine;
import com.nsr.invoice.mgr.InvoiceHeaderManager;
import com.nsr.invoice.mgr.InvoiceLineManager;
import com.nsr.invoice.model.InvoiceLineAir;
import com.nsr.invoice.model.InvoiceLineGas;
import com.nsr.invoice.model.InvoiceLineListrik;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice/line")
public class InvoiceLineController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceLineController.class);

    @Autowired
    InvoiceHeaderManager invoiceHeaderManager;


    @Autowired
    InvoiceLineManager invoiceLineManager;


    @PostMapping("/listrik")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> createInvoiceListrikLine(@RequestBody InvoiceLineListrik lineListrik){
        try {
            InvoiceLine line = invoiceLineManager.createOneLineListrik(lineListrik);
            logger.info("input : "+line);
            return RestUtils.createResponseCreated(line);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }

    @PostMapping("/air")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> createInvoiceAirLine(@RequestBody InvoiceLineAir lineAir){
        try {
            InvoiceLine line = invoiceLineManager.createOneLineAir(lineAir);
            logger.info("input : "+line);
            return RestUtils.createResponseCreated(line);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }

    @PostMapping("/gas")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> createInvoiceGasLine(@RequestBody InvoiceLineGas lineGas){
        try {
            InvoiceLine line = invoiceLineManager.createOneLineGas(lineGas);
            logger.info("input : "+line);
            return RestUtils.createResponseCreated(line);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }
    @GetMapping("/{invoiceNo}")
    public ResponseEntity<Object>getInvoiceLineByInvoiceNo(@PathVariable String invoiceNo){
        try {
            List<InvoiceLine> invoiceLines= invoiceLineManager.getInvoiceLineByInvoiceNo(invoiceNo);
           logger.info("input : "+invoiceNo);
           return RestUtils.createResponseOk(invoiceLines);
        }catch (NsrException e){
            return RestUtils.createResponseDataNotFound(404,"Invoice Line not found");
        }
    }
}
