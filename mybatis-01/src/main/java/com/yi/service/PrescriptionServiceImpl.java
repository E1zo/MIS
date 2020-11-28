package com.yi.service;

import com.yi.mapper.PrescriptionMapper;
import com.yi.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    PrescriptionMapper prescriptionMapper;
    public Prescription queryPrescriptionByOutPatientId(Integer outpatientid){
        return prescriptionMapper.queryPrescriptionByOutPatientId(outpatientid);
    }
}
