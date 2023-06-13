package com.hzlx.service.impl;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.BaseResult;
import com.hzlx.utils.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BusinessInfoServiceImpl implements BusinessInfoService {
    BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();

    @Override
    public void getBusList(HttpServletRequest request,HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        request.setAttribute(BgmsConfig.BUS_LIST,businessInfoDao.getBusinessAll(keyword));
        request.setAttribute(BgmsConfig.KEYWORD,keyword);
    }

    @Override
    public String getBus(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id ==null){
            return BaseResult.error(20002,"商家id不能为空");
        }
        BusinessInfo businessInfo = businessInfoDao.getBusById(id);
        return BaseResult.success(businessInfo);
    }

    @Override
    public String addbus(HttpServletRequest request, Integer a) {
        String id = request.getParameter("id");
        String busName = request.getParameter("busName");
        String businessName = request.getParameter("businessName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String encryptPwd = MD5Utils.encryptMD5(password,busName);
        int rows;
        if (a == 1){
            rows=businessInfoDao.addBus(busName,encryptPwd,businessName,tel,address,id);
            if (rows>0){
                return BaseResult.success();
            }else {
                return BaseResult.error(20005,"新增商家失败");
            }
        }else {
            rows=businessInfoDao.updateBus(busName,encryptPwd,businessName,tel,address,id);
            if (rows>0){
                return BaseResult.success();
            }else {
                return BaseResult.error(20005,"修改商家失败");
            }
        }
    }

    @Override
    public String enableBus(HttpServletRequest request) {
        Integer sta = Integer.parseInt(request.getParameter("sta"));
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");
        int rows= businessInfoDao.batchUpdateBusStatus(ids,sta);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20003,"更改商家失败");
        }

    }

    @Override
    public String deleteBus(HttpServletRequest request) {
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");

        int rows=businessInfoDao.deleteBusById(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20003,"删除商家失败");
        }
    }


}
