package com.yi.controller;

import com.yi.pojo.Department;
import com.yi.pojo.Doctor;
import com.yi.pojo.OutPatient;
import com.yi.pojo.Patient;
import com.yi.service.DepartmentService;
import com.yi.service.DoctorService;
import com.yi.service.OutPatientService;
import com.yi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OutPatientController {
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    PatientService patientService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DoctorService doctorService;

    @RequestMapping("/outpatient/outpatient")
    public String toOutpatient(){
        return "/outpatient/outpatient";
    }
    @RequestMapping("/outpatient/toregistration")
    public String toOutpatientRegistration(){
        return "/outpatient/registration";
    }

    @RequestMapping("/outpatient/search")
    public String search(Integer caseid, Model model, HttpSession session){
        Patient patient =patientService.findPatientById(outPatientService.findPatientIdByCaseId(caseid));
        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        session.setAttribute("patientid",patient.getPatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patient",patient);
        //查出所有医生
        List<Doctor> doctor=doctorService.queryAllDoc();
        model.addAttribute("doctor",doctor);
        return "/outpatient/registration.html";
    }

    @RequestMapping("/outpatient/registration")
    public String registration(Integer doctorid,Model model){

//        int res=outPatientService.insertOutPatientBypatientId();
        System.out.println(doctorid);

//        if(res>0){
//            model.addAttribute("msg","挂号成功");
//        }

        return "index";
    }


}
