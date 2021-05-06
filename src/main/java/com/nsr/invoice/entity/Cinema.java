package com.nsr.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cinema")
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class Cinema {
	@Id
	@NotBlank(message = "Bioskop id is mandatory !")
	private String id;
	private Integer uniqueId;
	@NotEmpty(message = "Bioskop name is mandatory !")
	private String nama;
	private String email;
	private Integer noHp;
	private Integer tipe;
	private Integer kota;
	private String alamat;
	private String keterangan;
	
	
}
