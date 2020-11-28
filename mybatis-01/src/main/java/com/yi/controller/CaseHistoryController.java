package com.yi.controller;

import com.yi.pojo.*;
import com.yi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CaseHistoryController {
    @Autowired
    CaseHistoryService caseHistoryService;
    @Autowired
    PatientService patientService;
    @Autowired
    PrescriptionMedicationService prescriptionMedicationService;
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    DrugService drugService;

    @RequestMapping("/updatesickInfo")
    public String updatesickInfo(Model model, HttpSession session,String sickinfo){

        Integer caseid=(Integer) session.getAttribute("caseid");
        CaseHistory caseHistory = new CaseHistory(caseid,sickinfo,new Date());
        int res=caseHistoryService.updateCaseHistoryByCaseId(caseHistory);
        if(res>0){
            model.addAttribute("msg","提交病情成昆");
        }


        //获取PrePrescriptionMedication信息
        model.addAttribute("drugs",drugService.queryAllDrug());
        Integer outpatientid= (Integer) session.getAttribute("outpatientid");
        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outpatientid);
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
        model.addAttribute("prescription",presm);
        //获取病人信息
        Patient patient =patientService.findPatientByCaseId(caseid);
        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patient",patient);
        model.addAttribute("caseid",caseid);
        return "/doctor/doctor";
    }

}
