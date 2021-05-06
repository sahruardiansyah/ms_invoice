package com.nsr.invoice.entity;

import com.nsr.invoice.model.InvoiceLineListrik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "invoice_line")
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Invoice no is mandatory!")
    private String invoiceNo;
    private Integer typeId;
    private Integer lwbpAwal;
    private Integer awal;
    private Integer lwbpAkhir;
    private Integer akhir;
    private Integer tarif;
    private Integer tarifLwbp;
    private Integer tarifWbp;
    private Integer manPower;
    private Integer usageLwbp;
    private Integer wbpAwal;
    private Integer wbpAkhir;
    private Integer usageWbp;
    private Integer denda;
    private String lineKeterangan;
    private Integer amountLine;
    private String tipeSpartpart;
    private String merkSparepart;
    private String serialNumber;
    private Integer qty;
    private Integer hargaSatuan;
    private Integer subTotal;
    private String ketegoryService;
    private Integer biayaService;
    private String kategorySewa;
    private String tahunKontrak;
    private String luas;
    private String mataUang;
    private Integer kurs;
    private String tarifUmum;
    private String tarifRate;
    private Integer lob;
    private Integer jumlahPenonton;
    private Integer omzetGross;
    private String pajak;
    private String omzetNett;
    private Integer presentasiBagiHasil;

    public InvoiceLine(InvoiceLineListrik listrik){
        this.lwbpAwal = listrik.getLwbpAwal();
        this.lwbpAkhir = listrik.getLwbpAkhir();
        this.usageLwbp = listrik.getUsageLwbp();
        this.tarifLwbp = listrik.getTarifLwbp();
        this.wbpAwal = listrik.getWbpAwal();
        this.wbpAkhir = listrik.getWbpAkhir();
        this.usageWbp = listrik.getUsageWbp();
        this.tarifWbp = listrik.getTarifWbp();
        this.denda = listrik.getDenda();
        this.lineKeterangan = listrik.getLineKeterangan();
        this.amountLine= listrik.getAmountLine();
        this.invoiceNo=listrik.getInvoiceNo();
    }
}
