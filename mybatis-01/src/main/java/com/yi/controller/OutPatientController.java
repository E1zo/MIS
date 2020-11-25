package com.yi.controller;

import com.yi.pojo.OutPatient;
import com.yi.pojo.Patient;
import com.yi.service.OutPatientService;
import com.yi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OutPatientController {
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    PatientService patientService;

    @RequestMapping("/outpatient/outpatient")
    public String toOutpatient(){
        return "/outpatient/outpatient";
    }
    @RequestMapping("/outpatient/toregistration")
    public String toOutpatientRegistration(){
        return "/outpatient/registration";
    }

    @RequestMapping("/outpatient/Registration")

    public String Registration(Integer caseid, Model model){

        Patient patient =patientService.findPatientById(outPatientService.findPatientIdByCaseId(caseid));
        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patientname",patient.getPatientname());
        model.addAttribute("patientage",patient.getAge());
        model.addAttribute("patientsex",patient.getSex());
        model.addAttribute("patientaddress",patient.getAddress());
        model.addAttribute("patientphone",patient.getPhone());
        model.addAttribute("patientfirstman",patient.getFirstman());
        model.addAttribute("patientfirstquery",patient.getFirstquery());
        model.addAttribute("patientfirstphone",patient.getFirstphone());
        return "/outpatient/registration.html";
    }



}
