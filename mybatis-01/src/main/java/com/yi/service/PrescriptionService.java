package com.yi.service;

import com.yi.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PrescriptionService {
    Prescription queryPrescriptionByOutPatientId(Integer outpatientid);
}
