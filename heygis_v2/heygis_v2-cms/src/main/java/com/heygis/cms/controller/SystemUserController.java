package com.heygis.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.service.SystemService;
import com.heygis.cms.service.SystemUserService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * cms系统 - 会员管理控制层
 */
@RestController
@RequestMapping("/system")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SystemUserController {

    @Reference
    private SystemUserService systemUserService;

    /**
     * cms系统 获取用户列表
     * @return
     */
    @RequestMapping("/getUserList")
    public HeyGisResult getUserList(){
        return systemUserService.getUserList();
    }

    /**
     * cms系统 根据uid删除用户
     * @param uid
     * @return
     */
    @RequestMapping("/deleteUser")
    public HeyGisResult deleteUser(@RequestParam(value = "uid",required = true) Integer uid){
        if(uid!=null){
            return systemUserService.deleteUserByUid(uid);
        }
        return HeyGisResult.build(202,"uid获取失败");
    }

    /**
     * cms系统 根据nickname模糊查询用户信息
     * @param searchInfo
     * @return
     */
    @RequestMapping("/searchUserInfoByNickName")
    public HeyGisResult getUserInfoByNickName(@RequestParam(value = "searchInfo",required = true)String searchInfo){
        if(searchInfo!=null){
            return systemUserService.getUserInfoByNickName(searchInfo);
        }
        return HeyGisResult.build(202,"nickname获取失败");
    }
}
