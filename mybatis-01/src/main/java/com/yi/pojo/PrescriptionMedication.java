package com.yi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionMedication {
    private Integer serialid ;
    private Integer prescriptionid;
    private Integer drugid;
    private Integer number;
    private Integer total;

    public PrescriptionMedication(Integer prescriptionid, Integer drugid, Integer number, Integer total) {
        this.prescriptionid = prescriptionid;
        this.drugid = drugid;
        this.number = number;
        this.total = total;
    }
}
