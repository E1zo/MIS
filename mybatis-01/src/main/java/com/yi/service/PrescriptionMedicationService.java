package com.yi.service;

import com.yi.pojo.PrescriptionMedication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionMedicationService {
    List<PrescriptionMedication> queryPrescriptionMedicationByPrescriptionId(Integer prescriptionid);
    int insertPresciptionMedication(PrescriptionMedication prescriptionMedication);
    int updatePresciptionMedication(Integer prescriptionid,Integer drugid,Integer number,Integer total);
    List<Integer> queryAlldrugid();
    List<Integer> queryAllnumber();
}
