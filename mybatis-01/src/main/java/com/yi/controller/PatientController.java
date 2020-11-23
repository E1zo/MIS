package com.yi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {

    @RequestMapping("/patient/registration")
    public String toPatientRegistration(){

        return "/patient/registration";
    }
}
