package com.yi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DrugStoreController {

    @RequestMapping("/toDrugStorePage")
    public String toDrugStorePage(){
        return "/drugStore/drugStore";
    }

}
