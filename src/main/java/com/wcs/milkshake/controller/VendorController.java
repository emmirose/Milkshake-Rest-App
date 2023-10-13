package com.wcs.milkshake.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.milkshake.entity.Vendor;
import com.wcs.milkshake.repository.VendorRepository;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

  final VendorRepository vendorRepository;

  public VendorController(final VendorRepository vendorRepository) {
    this.vendorRepository = vendorRepository;
  }

  @GetMapping("")
  public List<Vendor> getVendors() {
    return vendorRepository.findAll();
  }

  @GetMapping("/{id}")
  public Vendor getVendor(@PathVariable Long id) {
    Optional<Vendor> vendor = vendorRepository.findById(id);
    if (vendor.isPresent()) {
      return vendor.get();
    } else {
      throw new RuntimeException("Vendor not found with id: " + id);
    }
  }

  @PostMapping("")
  public Vendor createVendor(@RequestBody Vendor vendor) {
    return vendorRepository.save(vendor);
  }

  @PutMapping("/{id}")
  public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
    Optional<Vendor> optionalVendor = vendorRepository.findById(id);
    if (optionalVendor.isPresent()) {
      Vendor updatedVendor = optionalVendor.get();
      updatedVendor.setAge(vendor.getAge());
      updatedVendor.setName(vendor.getName());
      return vendorRepository.save(updatedVendor);
    }
    throw new RuntimeException("Vendor not found with id: " + id);
  }

  @DeleteMapping("/{id}")
  public void deleteVendor(@PathVariable Long id) {
    Optional<Vendor> optionalVendor = vendorRepository.findById(id);
    if (optionalVendor.isPresent()) {
      vendorRepository.delete(optionalVendor.get());
    } else {
      throw new RuntimeException("Vendor not found with id: " + id);
    }

  }
}
