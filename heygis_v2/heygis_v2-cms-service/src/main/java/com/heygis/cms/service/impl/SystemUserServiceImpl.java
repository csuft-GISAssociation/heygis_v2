package com.heygis.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heygis.cms.mapper.UsersMapper;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.pojo.UsersInfo;
import com.heygis.cms.service.SystemUserService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * cms系统 用户管理业务层实现类
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * cms系统 获取用户列表
     * @return
     */
    @Override
    public HeyGisResult getUserList() {
        try{
            List<UsersInfo> list = usersMapper.queryUserList();
            return HeyGisResult.build(200,"查询用户信息成功",list);
            //暂不采用
            /*if(list!=null&&list.size()>0){
                return HeyGisResult.build(200,"查询用户信息成功",list);
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"查询用户信息失败");
        }
    }

    /**
     * cms系统 根据uid删除用户
     * @param uid
     * @return
     */
    @Override
    public HeyGisResult deleteUserByUid(Integer uid) {
        try{
            //先删除user_info表
            Integer i = usersMapper.deleteUserInfoByUid(uid);
            //再删除users表
            Integer j = usersMapper.deleteUserByUid1(uid);
            return HeyGisResult.build(200,"用户信息删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"用户信息删除失败");
        }
    }

    /**
     * cms系统 根据nickname模糊查询用户信息
     * @param searchInfo
     * @return
     */
    @Override
    public HeyGisResult getUserInfoByNickName(String searchInfo) {
        List<UsersInfo> list =  usersMapper.queryUserInfoByNickName(searchInfo);
        try {
            if (list != null && list.size() > 0) {
                return HeyGisResult.build(200, "用户信息查询成功", list);
            } else {
                return HeyGisResult.build(200, "用户信息查询为空");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return HeyGisResult.build(201, "用户信息查询失败");
        }
    }
}
