package com.nsr.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "vendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Vendor name is mandatory!")
	private String vendorName;
	private String vendorAddress;
	private String email;
	private String vendorRepresentation;
	private String telepon;
	private String postCode;
	private String kota;
}
