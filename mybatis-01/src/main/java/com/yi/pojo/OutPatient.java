package com.yi.pojo;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutPatient {

    private Integer outpatientid;
    private Integer patientid;
    private Integer departmentid;
    private Integer doctorid;
    private Date time;
    private Boolean iscancel;
    
}