package com.yi.controller;

import com.yi.pojo.Department;
import com.yi.pojo.Drug;
import com.yi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //查看所有部门页面（查询所有部门）
    @RequestMapping("allDepartment")
    public String list(Model model){
        List<Department> list = departmentService.queryAllDpt();

        for(int i=0;i<list.size();i++){
            model.addAttribute("list", list.get(i));
        }

        return "allDepartment";
    }

    //跳转到 添加部门 页面
    @RequestMapping("/toAddDepartment")
    public String toAddDrug(){
        return "addDepartment";
    }

    //添加部门
    @RequestMapping("/addDepartment")
    public String addDrug(Department department){
        departmentService.insertDpt(department);
        return "redirect:/admin/allDepartment";
    }

    //跳转到 修改部门信息 页面
    @RequestMapping("/toUpdateDepartment")
    public String toUpdateDrug(int departmentid,Model model){
        Department department = departmentService.queryDptById(departmentid);
        model.addAttribute("QDpt",department);
        return "updateDepartment";
    }

    //修改部门
    @RequestMapping("/updateDepartment")
    public String updateDepartment(Department department){
        departmentService.updateDpt(department);
        return "redirect:/admin/allDepartment";
    }

    //删除部门
    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(int departmentid){
        departmentService.deleteDptById(departmentid);
        return "redirect:/admin/allDepartment";
    }
}
