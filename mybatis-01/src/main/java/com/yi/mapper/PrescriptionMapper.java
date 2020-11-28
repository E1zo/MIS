package com.yi.mapper;

import com.yi.pojo.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PrescriptionMapper {
   Prescription queryPrescriptionByOutPatientId(Integer outpatientid);
}
