package com.nsr.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVendorRequest {
	private String vendorName;
	private String vendorAddress;
	private String email;
	private String vendorRepresentation;
	private String telepon;
	private String postCode;
	private String kota;


}
