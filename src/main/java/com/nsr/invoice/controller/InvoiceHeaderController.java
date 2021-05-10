package com.nsr.invoice.controller;

import com.nsr.commons.exception.NsrException;
import com.nsr.commons.web.rest.util.RestUtils;
import com.nsr.invoice.entity.InvoiceHeader;
import com.nsr.invoice.mgr.InvoiceHeaderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice/header")
public class InvoiceHeaderController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceHeaderController.class);

    @Autowired
    InvoiceHeaderManager invoiceHeaderManager;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> createInvoiceHeader(@RequestBody InvoiceHeader invoiceHeader){
        try {
            InvoiceHeader header = invoiceHeaderManager.createInvoiceHeader(invoiceHeader);
            logger.info("input : "+header);
            return RestUtils.createResponseCreated(header);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }

    @GetMapping("/{invoiceNo}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> getInvoiceHeaderByInvoiceNo(@PathVariable String invoiceNo){
        try {
            InvoiceHeader header = invoiceHeaderManager.getInvoiceHeaderByInvoiceNo(invoiceNo);
            logger.info("input : "+invoiceNo);
            return RestUtils.createResponseOk(header);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }

    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> updateInvoiceHeader(@RequestBody InvoiceHeader invoiceHeader){
        try {
            InvoiceHeader header = invoiceHeaderManager.updateInvoiceHeader(invoiceHeader);
            logger.info("input : "+invoiceHeader);
            return RestUtils.createResponseOk(header);
        }catch (NsrException e){
            return RestUtils.createResponseBadRequest(e.getMessage());
        }
    }

    @GetMapping("/type/{typeId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> getInvoiceHeaderByTypeId(@PathVariable Integer typeId){
        try {
            List<InvoiceHeader> header = invoiceHeaderManager.getIvoiceHeaderByTypeId(typeId);
            logger.info("input : "+typeId);
            return RestUtils.createResponseOk(header);
        }catch (NsrException e){
            return RestUtils.createResponseDataNotFound(404,e.getMessage());
        }
    }
}
