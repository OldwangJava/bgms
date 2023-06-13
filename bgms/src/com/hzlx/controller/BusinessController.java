package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/bus")
public class BusinessController {

    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();
    @RequestMapping("/manage")
    public String manage(HttpServletRequest request, HttpServletResponse response){
        businessInfoService.getBusList(request,response);
        return "pages/bus";
    }

    @RequestMapping("/getBus")
    @ResponseBody
    public String getBus(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.getBus(request);
    }
    @ResponseBody
    @RequestMapping("/addbus")
    public String addbus(HttpServletRequest request,HttpServletResponse response){
        Integer a = 1;
        return businessInfoService.addbus(request,a);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(HttpServletRequest request,HttpServletResponse response){
        Integer a=2;
        return businessInfoService.addbus(request ,a);
    }

    @RequestMapping("/enableBus")
    @ResponseBody
    public String enableUsers(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.enableBus(request);
    }

    @RequestMapping("/deleteBus")
    @ResponseBody
    public String deleteUser(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.deleteBus(request);
    }
}
