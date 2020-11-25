package com.yi.service;

import com.yi.mapper.OutPatientMapper;
import com.yi.pojo.OutPatient;
import com.yi.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutPatientServiceImpl implements  OutPatientService{
    @Autowired
    OutPatientMapper outpatientMapper;

    public Integer findPatientIdByCaseId(Integer caseid){
        return outpatientMapper.findPatientIdByCaseId(caseid);
    }

    public OutPatient findOutPatientByPatientId(Integer patientid) {
        OutPatient outPatient=outpatientMapper.findOutPatientByPatientId(patientid);
        return outPatient;
    }

    public  int insertOutPatientByPatient(OutPatient outPatient){
        return outpatientMapper.insertOutPatientByPatient(outPatient);
    }
}
