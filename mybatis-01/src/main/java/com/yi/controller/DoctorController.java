package com.yi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.pojo.*;
import com.yi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DrugService drugService;
    @Autowired
    PrescriptionMedicationService prescriptionMedicationService;
    @Autowired
    PatientService patientService;
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PrescriptionService prescriptionService;
    @RequestMapping("/doctor/doctor")
    public String toDoctor(Model model) {
        model.addAttribute("drugs",drugService.queryAllDrug());
        return "/doctor/doctor";
    }

    @RequestMapping("/doctor/search")
    public String search(Integer caseid, Model model, HttpSession session){
        session.setAttribute("caseid",caseid);
        model.addAttribute("caseid",caseid);
        Patient patient =patientService.findPatientByCaseId(caseid);


        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        session.setAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patient",patient);
        model.addAttribute("drugs",drugService.queryAllDrug());
        Integer outpatientid= (Integer) session.getAttribute("outpatientid");

        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outpatientid);
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
        model.addAttribute("prescription",presm);

        return "/doctor/doctor";
    }

    @RequestMapping(value = "/doctor/cure")
    public String Doctor(@RequestParam(value = "drugid")Integer[] drugid,@RequestParam(value = "number")Integer[] number,Model model,HttpSession session) {

        model.addAttribute("drugs",drugService.queryAllDrug());
        Integer outpatientid= (Integer) session.getAttribute("outpatientid");
        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outpatientid);
        for(int i=0;i<drugid.length;i++){
            List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
            prescriptionMedicationService.updatePresciptionMedication(presm.get(1).getPrescriptionid(),drugid[i],number[i],number[i]*drugService.queryDrugById(drugid[i]).getPrice());
            model.addAttribute("prescription",presm);
        }
        //获取PrePrescriptionMedication信息
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
        model.addAttribute("prescription",presm);
        //获取病人信息
        Integer caseid=(Integer) session.getAttribute("caseid");
        Patient patient =patientService.findPatientByCaseId(caseid);
        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patient",patient);
        model.addAttribute("caseid",caseid);

        return "/doctor/doctor";
    }

    @RequestMapping("/doctor/addDrug")
    public String addDrugintoPrescription(Integer drugid,Model model,HttpSession session){

        List<Integer> a=prescriptionMedicationService.queryAlldrugid();
        model.addAttribute("drugs",drugService.queryAllDrug());
        Integer outpatientid= (Integer) session.getAttribute("outpatientid");
        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outpatientid);
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());



        //当已经有这种药品时，提示已经存在
            if(a.contains(drugid)) {
                model.addAttribute("msg","已经有这种药了噢");
                model.addAttribute("drugs",drugService.queryAllDrug());
                //获取病人信息
                Integer caseid=(Integer) session.getAttribute("caseid");
                Patient patient =patientService.findPatientByCaseId(caseid);
                OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
                model.addAttribute("outpatientid",outPatient.getOutpatientid());
                model.addAttribute("patient",patient);
                model.addAttribute("caseid",caseid);
                presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
                model.addAttribute("prescription",presm);
            }else {
                PrescriptionMedication prescriptionMedication = new PrescriptionMedication(presm.get(1).getPrescriptionid(), drugid, 1, drugService.queryDrugById(drugid).getPrice());

                prescriptionMedicationService.insertPresciptionMedication(prescriptionMedication);
                model.addAttribute("drugs", drugService.queryAllDrug());
                //获取病人信息
                Integer caseid = (Integer) session.getAttribute("caseid");
                Patient patient = patientService.findPatientByCaseId(caseid);
                OutPatient outPatient = outPatientService.findOutPatientByPatientId(patient.getPatientid());
                model.addAttribute("outpatientid", outPatient.getOutpatientid());
                model.addAttribute("patient", patient);
                model.addAttribute("caseid", caseid);
                presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
                model.addAttribute("prescription", presm);
            }



        return "/doctor/doctor";
    }

    //查看所有医生
    @RequestMapping("/admin/allDoctor")
    public String list(Model model){
        List<Doctor> list = doctorService.queryAllDoc();
        model.addAttribute("docList",list);
        return "admin/allDoctor";
    }

    //跳转到 添加医生 页面
    @RequestMapping("/admin/toAddDoctor")
    public String toAddDoctor(){
        return "admin/addDoctor";
    }

    //添加医生信息
    @RequestMapping("/admin/addDoctor")
    public String addDoctor(Doctor doctor){
        doctorService.insertDoc(doctor);
        return "redirect:/admin/allDoctor";
    }

    //跳转到 修改 页面
    @RequestMapping("/admin/toUpdateDoctor")
    public String toUpdateDoctor(int doctorid,Model model){
        Doctor doctor = doctorService.queryDocById(doctorid);
        model.addAttribute("Qdoc",doctor);
        return "admin/updateDoctor";
    }

    //修改页面
    @RequestMapping("/admin/updateDoctor")
    public String updateDoctor(Doctor doctor){
        doctorService.updateDoc(doctor);
        return "redirect:/admin/allDoctor";
    }

    //删除医生
    @RequestMapping("/admin/deleteDoctor")
    public String deleteDoctor(int doctorid){
        doctorService.deleteDocById(doctorid);
        return "redirect:/admin/allDoctor";
    }
}
