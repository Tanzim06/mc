package com.bz.mc.service;

import com.bz.mc.facade.data.StudentChargeGroupData;
import com.bz.mc.model.charge.ChargeItem;
import com.bz.mc.model.shedule.StudentChargeGroup;

import java.util.List;
import java.util.Optional;

public interface StudentChargeGroupService {

    StudentChargeGroup getStudentChargeGroup(Long id);
    StudentChargeGroup saveStudentChargeGroup(StudentChargeGroup studentChargeGroup);

    public List<StudentChargeGroup> saveStudentChargeGroups(List<StudentChargeGroup> studentChargeGroupList);

    Optional<StudentChargeGroup> findStudentChargeGroupById(Long id);
    Optional <StudentChargeGroup> getStudentChargeGroupInfo(Long id);

    List<StudentChargeGroupData> getStudentChargeGroupData(Long sessionId);


}
