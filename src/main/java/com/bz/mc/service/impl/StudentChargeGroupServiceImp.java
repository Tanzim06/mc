package com.bz.mc.service.impl;

import com.bz.mc.exception.NotFoundException;
import com.bz.mc.facade.data.StudentChargeGroupData;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.shedule.StudentChargeGroup;
import com.bz.mc.repository.ChargeGroupRepository;
import com.bz.mc.repository.StudentChargeGroupRepository;
import com.bz.mc.service.StudentChargeGroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service

public class StudentChargeGroupServiceImp implements StudentChargeGroupService {
    @NonNull
    private final StudentChargeGroupRepository studentChargeGroupRepository;

//    @Override
//    public StudentChargeGroup getStudentChargeGroup(Long id) {
//        return studentChargeGroupRepository.findById(id).get();
//    }

    @Override
    public StudentChargeGroup getStudentChargeGroup(Long id) {
        return getStudentChargeGroupInfo(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public StudentChargeGroup saveStudentChargeGroup(StudentChargeGroup studentChargeGroup) {
        return studentChargeGroupRepository.save(studentChargeGroup);
    }



    @Override
    public Optional<StudentChargeGroup> findStudentChargeGroupById(Long id) {
        return studentChargeGroupRepository.findById(id);
    }

    @Override
    public Optional<StudentChargeGroup> getStudentChargeGroupInfo(Long id) {
        return findStudentChargeGroupById(id);
    }

    @Override
    public List<StudentChargeGroupData> getStudentChargeGroupData(Long sessionId) {
        return studentChargeGroupRepository.findStudentChargeGroupData(sessionId);
    }
    @Override
    public List<StudentChargeGroup> saveStudentChargeGroups(List<StudentChargeGroup> studentChargeGroupList) {
        return studentChargeGroupRepository.saveAll(studentChargeGroupList);
    }



}
