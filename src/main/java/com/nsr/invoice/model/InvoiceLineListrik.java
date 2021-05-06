package com.nsr.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceLineListrik {
    @NotBlank(message = "Invoice no is mandatory!")
    private String invoiceNo;
    private Integer lwbpAwal;
    private Integer lwbpAkhir;
    private Integer usageLwbp;
    private Integer wbpAwal;
    private Integer tarifLwbp;
    private Integer tarifWbp;
    private Integer wbpAkhir;
    private Integer usageWbp;
    private Integer denda;
    private String lineKeterangan;
    private Integer amountLine;
}
