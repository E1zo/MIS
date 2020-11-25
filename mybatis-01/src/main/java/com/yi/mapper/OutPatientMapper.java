package com.yi.mapper;

import com.yi.pojo.OutPatient;
import com.yi.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OutPatientMapper {

    public Integer findPatientIdByCaseId(Integer caseid);
    public OutPatient findOutPatientByPatientId(Integer patientid);
    public int insertOutPatientByPatient(OutPatient outPatient);
}
