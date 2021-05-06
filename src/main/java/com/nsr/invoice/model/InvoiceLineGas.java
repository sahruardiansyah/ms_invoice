package com.nsr.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineGas {
    @NotBlank(message = "Invoice no is mandatory!")
    private String invoiceNo;
    private Integer awal;
    private Integer akhir;
    private Integer airUsage;
    private Integer tarif;
    private String lineKeterangan;
    private Integer amountLine;
}
