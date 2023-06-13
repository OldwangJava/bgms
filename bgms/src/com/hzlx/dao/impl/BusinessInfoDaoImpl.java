package com.hzlx.dao.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.utils.BaseDao;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class BusinessInfoDaoImpl extends BaseDao<BusinessInfo> implements BusinessInfoDao {
    @Override
    public BusinessInfo getBusinessInfoByUserNameAndPassword(String userName, String password) {
        String sql = "select * from t_business_info where user_name=? and `password`=?";
        return selectOne(sql,BusinessInfo.class,userName,password);
    }

    @Override
    public List<BusinessInfo> getBusinessAll(String keyword) {
        String sql = "select * from t_business_info";
        if (!StringUtils.isNullOrEmpty(keyword)){
            sql = " where business_name like concat('%',?,'%')";
            return selectListForObject(sql,BusinessInfo.class,keyword);
        }
        return selectListForObject(sql,BusinessInfo.class);
    }

    @Override
    public BusinessInfo getBusById(String id) {
        String sql="select * from t_business_info where id=?";
        return selectOne(sql,BusinessInfo.class,id);
    }

    @Override
    public int addBus(String busName, String password, String businessName, String tel, String address,String id) {
        String sql = "insert into t_business_info values (default,?,?,?,?,?,null,now(),default)";
        return executeUpdate(sql,busName,password,businessName,tel,address);
    }

    @Override
    public int updateBus(String busName, String encryptPwd, String businessName, String tel, String address,String id) {
        String sql="update t_business_info set bus_name=?,password=?,business_name=?,tel=?,address=? where id=?";
        return executeUpdate(sql,busName,encryptPwd,businessName,tel,address,id);
    }

    @Override
    public int batchUpdateBusStatus(String[] ids, Integer sta) {
        String sql="update t_business_info set `status`=? where id in (";
        for (int i = 0; i < ids.length; i++) {
            if (i==ids.length-1){
                sql+="?";
            }else {
                sql+="?,";
            }
        }
        sql+= ")";
        return executeUpdate(sql,sta,ids);
    }

    @Override
    public int deleteBusById(String[] ids) {
        String sql="delete from t_business_info  where id in (";
        for (int i = 0; i < ids.length; i++) {
            if (i==ids.length-1){
                sql+="?";
            }else {
                sql+="?,";
            }
        }
        sql+= ")";
        return executeUpdate(sql,ids);
    }
}
