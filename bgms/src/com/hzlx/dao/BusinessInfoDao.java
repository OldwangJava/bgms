package com.hzlx.dao;

import com.hzlx.entity.BusinessInfo;
import com.hzlx.utils.BaseDao;

import java.util.List;

public interface BusinessInfoDao {
    BusinessInfo getBusinessInfoByUserNameAndPassword(String userName,String password);

    List<BusinessInfo>getBusinessAll(String keyword);

    BusinessInfo getBusById(String id);

    int addBus(String busName,String password,String businessName,String tel,String address,String id);

    int updateBus(String busName,String encryptPwd,String businessName,String tel,String address,String id);

    int batchUpdateBusStatus(String[] ids, Integer sta);

    int deleteBusById(String[] ids);
}
