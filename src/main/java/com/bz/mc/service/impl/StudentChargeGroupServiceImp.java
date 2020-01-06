package com.bz.mc.service.impl;

import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.shedule.StudentChargeGroup;
import com.bz.mc.repository.ChargeGroupRepository;
import com.bz.mc.repository.StudentChargeGroupRepository;
import com.bz.mc.service.StudentChargeGroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service

public class StudentChargeGroupServiceImp implements StudentChargeGroupService {
    @NonNull
    private final StudentChargeGroupRepository studentChargeGroupRepository;

    @Override
    public StudentChargeGroup getStudentChargeGroup(Long id) {
        return studentChargeGroupRepository.findById(id).get();
    }


}
