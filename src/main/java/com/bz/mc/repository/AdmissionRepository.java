package com.bz.mc.repository;

import com.bz.mc.model.admission.AdmissionBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<AdmissionBooking,Long> {


}
