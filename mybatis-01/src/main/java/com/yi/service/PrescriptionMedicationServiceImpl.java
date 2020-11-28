package com.yi.service;

import com.yi.mapper.PrescriptionMedicationMapper;
import com.yi.pojo.PrescriptionMedication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrescriptionMedicationServiceImpl implements PrescriptionMedicationService {
@Autowired
PrescriptionMedicationMapper prescriptionMedicationMapper;

public List<PrescriptionMedication> queryPrescriptionMedicationByPrescriptionId(Integer prescriptionid) {
        return prescriptionMedicationMapper.queryPrescriptionMedicationByPrescriptionId(prescriptionid);
    }

    @Override
    public int insertPresciptionMedication(PrescriptionMedication prescriptionMedication) {
        return prescriptionMedicationMapper.insertPresciptionMedication(prescriptionMedication);

    }

    @Override
    public int updatePresciptionMedication(Integer prescriptionid,Integer drugid,Integer number,Integer total) {
        return prescriptionMedicationMapper.updatePresciptionMedication(prescriptionid,drugid,number,total);
    }


    public  List<Integer> queryAlldrugid(){
    return prescriptionMedicationMapper.queryAlldrugid();
    }
     public  List<Integer> queryAllnumber(){
    return prescriptionMedicationMapper.queryAllnumber();
     }

}
