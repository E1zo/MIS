package com.yi.mapper;

import com.yi.pojo.Drug;
import com.yi.pojo.PrescriptionMedication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PrescriptionMedicationMapper {
    List<PrescriptionMedication> queryPrescriptionMedicationByPrescriptionId(Integer prescriptionid);
    int insertPresciptionMedication(PrescriptionMedication prescriptionMedication);
    int updatePresciptionMedication(Integer prescriptionid,Integer drugid,Integer number,Integer total);
    List<Integer> queryAlldrugid();
    List<Integer> queryAllnumber();
}
