package com.yi.service;

import com.yi.pojo.Patient;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface PatientService {
    public int insertPatient(String name,  String sex, String age, String sidno, String sidtype, String address, String phone, String companynameaddress, String companyphone,
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
                                double creditlimit
                            );

    public Patient findPatientByCaseId(Integer caseid);

    public Patient findPatientById(Integer patientid);
}
