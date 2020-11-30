package com.yi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cost {

    private Integer serialid;

    private Integer outpatientid;


    private Integer patientid;


    private Integer drugcost;


    private Integer registrationcost;


    private Integer total;


    private String state;

    public Cost(Integer outpatientid, String state) {
        this.outpatientid = outpatientid;
        this.state = state;
    }
    public Cost(Integer outpatientid, Integer total) {
        this.outpatientid = outpatientid;
        this.total = total;
    }

    public Integer getSerialid() {
        return serialid;
    }


    public void setSerialid(Integer serialid) {
        this.serialid = serialid;
    }


    public Integer getOutpatientid() {
        return outpatientid;
    }

    public void setOutpatientid(Integer outpatientid) {
        this.outpatientid = outpatientid;
    }

    public Integer getPatientid() {
        return patientid;
    }


    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }


    public Integer getDrugcost() {
        return drugcost;
    }


    public void setDrugcost(Integer drugcost) {
        this.drugcost = drugcost;
    }


    public Integer getRegistrationcost() {
        return registrationcost;
    }


    public void setRegistrationcost(Integer registrationcost) {
        this.registrationcost = registrationcost;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}