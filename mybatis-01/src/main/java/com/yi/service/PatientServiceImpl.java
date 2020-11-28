package com.yi.service;

import com.yi.mapper.PatientMapper;
import com.yi.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;


    public int insertPatient(String name,String sex, String age, String sidno, String sidtype, String address, String phone,
                                String companynameaddress,
                                String companyphone,
                                String email,
                                String firstman,
                                String firstquery,
                                String firstphone,
                                String firstaddress,
                                String recorddate,
                                String hispass,
                                String hisoperate,
                                String cardtype,
                             double balance,
                             double creditlimit)
    {
        return patientMapper.insertPatient(name,sex,age,sidno,sidtype,address,phone,
                companynameaddress,
                companyphone,
                email,
                firstman,
                firstquery,
                firstphone,
                firstaddress,
                recorddate,
                hispass,
                hisoperate,
                cardtype,
                balance,
                creditlimit

        );

    }

    @Override
    public Patient findPatientByCaseId(Integer caseid) {
        return patientMapper.findPatientByCaseId(caseid);
    }

    @Override
    public Patient findPatientById(Integer patientid) {
        return patientMapper.findPatientById(patientid);
    }
}
