package com.nsr.invoice.mgr;

import com.nsr.invoice.entity.Vendor;
import com.nsr.invoice.exception.ResourceNotFoundException;
import com.nsr.invoice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorManager {
    @Autowired
    VendorRepository vendorRepository;


    public Vendor addOrUpdateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor getVendorById(Integer vendorId) {
        // TODO Auto-generated method stub
        return vendorRepository.findById(vendorId).orElseThrow(()->new ResourceNotFoundException(String.format("vendor with id: %s not found",vendorId)));
    }

    public List<Vendor> getAllVendor() {
        // TODO Auto-generated method stub
        return (List<Vendor>) vendorRepository.findAll();
    }

    public void deleteVendorById(Integer vendorId) {
        // TODO Auto-generated method stub
        vendorRepository.deleteById(vendorId);
    }

}
