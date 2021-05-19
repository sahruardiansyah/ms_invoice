package com.nsr.invoice.controller;

import com.nsr.commons.web.rest.util.RestUtils;
import com.nsr.invoice.entity.Vendor;
import com.nsr.invoice.mgr.VendorManager;
import com.nsr.invoice.model.UpdateVendorRequest;
import com.nsr.invoice.repository.VendorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(path = "/api/vendor")
public class VendorController {
	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	@Autowired
	VendorManager vendorService;
	@Autowired
	VendorRepository vendorRepository;


	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/")
	public ResponseEntity<Object> getAllvendor(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		try {
			if (page != null || size != null) {
				page = (page != null ? page : 0);
				size = (size != null ? size : 10);

				Pageable pageable = PageRequest.of(page, size);
				Page<Vendor> vendorPage = vendorRepository.findAll(pageable);

				return RestUtils.createResponsePage(vendorPage, pageable);
			} else {
				List<Vendor> countryList = vendorRepository.findAll();
				return RestUtils.createResponseOk(countryList);
			}
		}catch (Exception e){
			logger.error("ERROR", e);
			return RestUtils.createResponseBadRequest("");
		}
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{vendorId}")
	public ResponseEntity<Object> getvendorById(@PathVariable Integer vendorId) {
		Vendor vendor = vendorService.getVendorById(vendorId);
		return RestUtils.createResponseOk(vendor);
	}
	

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/")
	public Vendor createvendor(@Valid @RequestBody Vendor vendor) {
		logger.info("create vendor request : "+vendor);
		return vendorService.addOrUpdateVendor(vendor);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/{vendorId}")
	public ResponseEntity<Object> updatevendor(@PathVariable Integer vendorId,@RequestBody UpdateVendorRequest vendor) {
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
		Vendor updated= vendorService.addOrUpdateVendor(data);
		return RestUtils.createResponseOk(updated);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{vendorId}")
	public void deletevendor(@PathVariable Integer vendorId) {
		 vendorService.getVendorById(vendorId);
		 vendorService.deleteVendorById(vendorId);
	}
}
