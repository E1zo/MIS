package com.yi.controller;

import com.yi.pojo.Drug;
import com.yi.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DrugController {

    @Autowired
    DrugService drugService;

    //查看所有药品页面（查询所有药品）
    @RequestMapping("allDrug")
    public String list(Model model){
        List<Drug> list = drugService.queryAllDrug();
        model.addAttribute("list",list);
        return "allDrug";
    }

    //跳转到 添加药品 页面
    @RequestMapping("/toAddDrug")
    public String toAddDrug(){
        return "addDrug";
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
        return "updateDrug";
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
}
