package com.yi.controller;

import com.yi.mapper.PatientMapper;
import com.yi.mapper.UserMapper;
import com.yi.service.PatientService;
import com.yi.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping("/patient/registration")
    public String toPatientRegistration(){

        return "/patient/registration";
    }


    @RequestMapping("/registration")
    @ResponseBody
    public String PatientRegistration(String name,  String sex, String age, String sidno, String sidtype, String address, String phone, String companynameaddress, String companyphone,
             String email,
             String firstman,
             String firstquery,
             String firstphone,
             String firstaddress,
             String recorddate,
             String hispass,
             String hisoperate,
             String cardtype,
             double balance,
             double creditlimit,
             Model model
    )

    {


      int res= patientService.insertPatient(name,  sex, age,sidno, sidtype, address, phone, companynameaddress, companyphone,
            email,
          firstman,
          firstquery,
           firstphone,
            firstaddress,
             recorddate,
           hispass,
             hisoperate,
             cardtype,
             balance,
           creditlimit
           );
        if(res>0){
            model.addAttribute("msg","登记陈坤");
        }

        return "index";


    }

}
