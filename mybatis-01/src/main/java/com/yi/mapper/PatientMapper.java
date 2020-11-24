package com.yi.mapper;

import com.yi.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface PatientMapper {
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


  public Patient findPatientById(Integer patientid);
}
