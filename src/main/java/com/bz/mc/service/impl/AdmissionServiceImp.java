package com.bz.mc.service.impl;

import com.bz.mc.model.admission.AdmissionBooking;
import com.bz.mc.model.batch.BatchInfo;
import com.bz.mc.repository.AdmissionRepository;
import com.bz.mc.service.AdmissionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AdmissionServiceImp implements AdmissionService {
    @NonNull
    private final AdmissionRepository admissionRepository;

    @Transactional
    @Override
    public AdmissionBooking saveAdmission(AdmissionBooking admissionBooking) {
        return admissionRepository.save(admissionBooking);
    }



    @Override
    public Optional<AdmissionBooking> getAdmission(Long id) {
        return findAdmissionById(id);
    }

    @Override
    public Optional<AdmissionBooking> findAdmissionById(Long id) {
        return admissionRepository.findById(id);
    }
}
