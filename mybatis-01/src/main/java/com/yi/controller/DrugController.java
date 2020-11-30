package com.yi.controller;

import com.yi.pojo.*;
import com.yi.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DrugController {

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

    //查看所有药品页面（查询所有药品）
    @RequestMapping("/allDrug")
    public String list(Model model){
        List<Drug> list = drugService.queryAllDrug();
        model.addAttribute("drugList",list);
        return "admin/allDrug";
    }

    //跳转到 添加药品 页面
    @RequestMapping("/toAddDrug")
    public String toAddDrug(){
        return "admin/addDrug";
    }

    //添加药品
    @RequestMapping("/addDrug")
    public String addDrug(Drug drug){
        drugService.insertDrug(drug);
        return "redirect:/admin/allDrug";
    }

    //跳转到 修改药品信息 页面
    @RequestMapping("/toUpdateDrug")
    public String toUpdateDrug(int drugid,Model model){
        Drug drug = drugService.queryDrugById(drugid);
        model.addAttribute("QDrug",drug);
        return "admin/updateDrug";
    }

    //修改药品
    @RequestMapping("/updateDrug")
    public String updateDrug(Drug drug){
        drugService.updateDrug(drug);
        return "redirect:/admin/allDrug";
    }

    //删除药品
    @RequestMapping("/deleteDrug")
    public String deleteDrug(int drugid){
        drugService.deleteDrugById(drugid);
        return "redirect:/admin/allDrug";
    }

    //取药
    @RequestMapping("/takeDrug")
    public String takeDrug(Drug drug){
        drugService.takeDrug(drug);
        return "redirect:/admin/allDrug";
    }

    //获取药品数量
    /*@RequestMapping("/getDrugNumber")
    public String getDrugNumber(int quantity){
        String msg = "";

        if(quantity == 0){
            msg = "药品数量不足，不能进行取药操作！";
        }

        return msg;
    }*/
    //查询病历号
    @RequestMapping("/search")
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

        //查询所有药品库存
        List<Drug> list = drugService.queryAllDrug();
        model.addAttribute("drugList",list);

        return "/admin/allDrug";
    }

    @RequestMapping("/giveDrug")
    public String Doctor(@RequestParam(value = "drugid")Integer[] drugid, @RequestParam(value = "number")Integer[] number, Model model, HttpSession session) {
       //取到所有药品
        List<Integer> list = drugService.queryAllDrugId();
        List<Drug>  drugs=drugService.queryAllDrug();

        for(int i=0;i<drugid.length;i++) {
             if (drugs.get(drugid[i]-1).getQuantity() - number[i]< 0) {
                    model.addAttribute("msg", "数量不够了哥");
                }
             else {
                    Drug drug = new Drug(drugid[i], drugs.get(drugid[i]-1).getQuantity() - number[i]);
                    drugService.updateDrugQuantity(drug);
                    model.addAttribute("msg", "太对了哥");
                }


       }

        //获取病人信息
        Integer caseid = (Integer) session.getAttribute("caseid");
        Patient patient = patientService.findPatientByCaseId(caseid);
        OutPatient outPatient = outPatientService.findOutPatientByPatientId(patient.getPatientid());
        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outPatient.getOutpatientid());
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
        model.addAttribute("prescription", presm);

        List<Drug>  drug=drugService.queryAllDrug();
        model.addAttribute("drugList",drug);
        return "/admin/allDrug";
    }
}
