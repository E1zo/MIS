package com.yi.service;

import com.yi.pojo.OutPatient;
import com.yi.pojo.Patient;
import org.springframework.stereotype.Service;

@Service
public interface OutPatientService {

    public Integer findPatientIdByCaseId(Integer caseid);
    public OutPatient findOutPatientByPatientId(Integer patientid);
    public  int insertOutPatientBypatientId(OutPatient outPatient);
}
