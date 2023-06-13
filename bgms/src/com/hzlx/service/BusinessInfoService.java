package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BusinessInfoService {
    void getBusList(HttpServletRequest request, HttpServletResponse response);

    String getBus(HttpServletRequest request);

    String addbus(HttpServletRequest request,Integer a);

    String enableBus(HttpServletRequest request);

    String deleteBus(HttpServletRequest request);
}
