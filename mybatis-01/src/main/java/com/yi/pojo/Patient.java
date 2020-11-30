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
public class Patient {

    private Integer patientid;
    private String sex;
    private String patientname;
    private String age;
    private String sidno;
    private String sidtype;
    private String address;

    public Patient(Integer patientid, double balance) {
        this.patientid = patientid;
        this.balance = balance;
    }

    private String phone;
    private String companynameaddress;
    private String companyphone;
    private String email;
    private String firstman;
    private String firstquery;
    private String firstphone;
    private String firstaddress;
    private String recorddate;
    private String hispass;
    private String hisoperate;
    private String cardtype;
    private double balance;
    private double creditlimit;

}