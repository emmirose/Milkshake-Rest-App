package com.wcs.milkshake.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wcs.milkshake.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
