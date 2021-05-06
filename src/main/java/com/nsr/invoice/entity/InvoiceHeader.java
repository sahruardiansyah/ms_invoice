package com.nsr.invoice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "invoice_header")
public class InvoiceHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer typeId;
    private String invoiceNo;
    private Integer vendorId;
    private String cinemaId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd")
    private Date invoiceDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd")
    private Date invoicePeriode;
    private Double ppn;
    private Integer materai;
    private Integer amountTotal;
    private Boolean status;
    private String keterangan;
}
