package com.bz.mc.service;

import com.bz.mc.model.admission.AdmissionBooking;


import java.util.Optional;

public interface AdmissionService {

    AdmissionBooking saveAdmission(AdmissionBooking admissionBooking);

    Optional<AdmissionBooking> getAdmission(Long id);

    Optional<AdmissionBooking> findAdmissionById(Long id);
}
