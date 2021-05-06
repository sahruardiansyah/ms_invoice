package com.nsr.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCinemaRequest {
	private String nama;
	private String email;
	private Integer noHp;
	private Integer tipe;
	private Integer kota;
	private String alamat;
	private String keterangan;

}
