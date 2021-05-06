package com.nsr.invoice.controller;

import com.nsr.invoice.entity.Vendor;
import com.nsr.invoice.mgr.VendorManager;
import com.nsr.invoice.model.UpdateVendorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/vendor")
public class VendorController {
	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	@Autowired
	VendorManager vendorService;


	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/")
	public List<Vendor> getAllvendor() {
		return vendorService.getAllVendor();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{vendorId}")
	public Vendor getvendorById(@PathVariable Integer vendorId) {
		return vendorService.getVendorById(vendorId);
	}
	

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/")
	public Vendor createvendor(@Valid @RequestBody Vendor vendor) {
		logger.info("create vendor request : "+vendor);
		return vendorService.addOrUpdateVendor(vendor);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PutMapping("/{vendorId}")
	public Vendor updatevendor(@PathVariable Integer vendorId,@RequestBody UpdateVendorRequest vendor) {
		logger.info("id request : "+vendorId);
		Vendor data = vendorService.getVendorById(vendorId);
		data.setVendorAddress(vendor.getVendorAddress());
		data.setVendorName(vendor.getVendorName());
		data.setVendorRepresentation(vendor.getVendorRepresentation());
		data.setEmail(vendor.getEmail());
		data.setKota(vendor.getKota());
		data.setPostCode(vendor.getPostCode());
		data.setTelepon(vendor.getTelepon());
		logger.info("update vendor request : "+vendor);
		return vendorService.addOrUpdateVendor(data);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{vendorId}")
	public void deletevendor(@PathVariable Integer vendorId) {
		 vendorService.getVendorById(vendorId);
		 vendorService.deleteVendorById(vendorId);
	}
}
