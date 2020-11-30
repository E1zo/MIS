package com.yi.controller;

import com.yi.pojo.*;
import com.yi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cost")
public class CostController {
    @Autowired
    PatientService patientService;
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    DrugService drugService;
    @Autowired
    PrescriptionMedicationService prescriptionMedicationService;
    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CostService costService;

    @RequestMapping("/cost")
    public String toCost(){

        return "/outpatient/cost";
    }

    @RequestMapping("/search")
    public String search(Integer caseid, Model model, HttpSession session){
        session.setAttribute("caseid",caseid);
        model.addAttribute("caseid",caseid);
        Patient patient =patientService.findPatientByCaseId(caseid);

        OutPatient outPatient=outPatientService.findOutPatientByPatientId(patient.getPatientid());
        session.setAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("outpatientid",outPatient.getOutpatientid());
        model.addAttribute("patient",patient);

        //找医生
        Doctor doc=doctorService.queryDocById(outPatient.getDoctorid());
        departmentService.queryDptById(doc.getDepartmentid());
        model.addAttribute("doctor",doc);
        Integer outpatientid= (Integer) session.getAttribute("outpatientid");
        Prescription pres=prescriptionService.queryPrescriptionByOutPatientId(outpatientid);
        List<PrescriptionMedication> presm = prescriptionMedicationService.queryPrescriptionMedicationByPrescriptionId(pres.getPrescriptionid());
        model.addAttribute("prescription",presm);
        Cost cost=costService.queryCostByOutpatientid(outpatientid);


        model.addAttribute("cost",cost);

        //统计总价
        int total=0;
        for(int i=0;i<presm.size();i++){
            total+=presm.get(i).getTotal();
        }
        total+=doc.getRegistrationfee();

        cost.setTotal(total);
        costService.updateCostTotal(cost);

        //显示余额
        model.addAttribute("balance",patient.getBalance());
        return "/outpatient/cost";
    }

    @RequestMapping("/giveMoney")
    public String giveMoney(@RequestParam("total")Integer total, HttpSession session,Model model){
        Integer caseid=(Integer) session.getAttribute("caseid");
        Integer outpatientid=(Integer) session.getAttribute("outpatientid");
        Patient patient =patientService.findPatientByCaseId(caseid);

       patient.setBalance(patient.getBalance()-total);
       int res=patientService.updatePatient(patient);


        Cost cost=new Cost(outpatientid,"1");
        int resu=costService.updateCost(cost);


        if(res>0&&resu>0){
            model.addAttribute("msg","缴费成功");
        }else {
            model.addAttribute("msg","缴费失败");
        }

        return "/outpatient/cost";
    }

}
