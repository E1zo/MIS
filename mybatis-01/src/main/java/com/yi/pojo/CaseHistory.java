package com.yi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseHistory {

    private Integer caseid;


    private Integer doctorid;


    private Integer patientid;


    private String sickinfo;

    private Date recorddate;


    public Integer getCaseid() {
        return caseid;
    }


    public void setCaseid(Integer caseid) {
        this.caseid = caseid;
    }


    public Integer getDoctorid() {
        return doctorid;
    }


    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }


    public Integer getPatientid() {
        return patientid;
    }


    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }


    public String getSickinfo() {
        return sickinfo;
    }


    public void setSickinfo(String sickinfo) {
        this.sickinfo = sickinfo == null ? null : sickinfo.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }


    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}