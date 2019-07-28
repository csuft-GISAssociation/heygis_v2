package com.heygis.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.service.SystemService;
import com.heygis.cms.utils.HeyGisResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * cms 系统管理控制层
 */
@RestController
@RequestMapping("/system")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SystemController {

    @Reference
    private SystemService systemService;

    /**
     * cms系统 登录
     * @param user
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public HeyGisResult login(@RequestBody Users user, HttpServletResponse response){
        if(user!=null){
            //登录
            HeyGisResult result = systemService.login(user);
            //取出token，写到cookied中
            String token = (String) result.getData();
            Cookie cookie = new Cookie("cms-user-token",token);
            //设置cookie过期时间为2个小时
            cookie.setMaxAge(60*60*2);
            cookie.setPath("/");
            response.addCookie(cookie);
            return result;
        }
        return HeyGisResult.build(202,"账号，密码获取失败");
    }

    /**
     * cms系统 登出
     * @param token
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    public  HeyGisResult logout(@CookieValue("cms-user-token") String token, HttpServletResponse response){
        if(token!=null&&!token.equals("")){
            //清除cookie
            Cookie cookie = new Cookie("user-token",token);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return systemService.logout(token);
        }
        return HeyGisResult.build(202,"token过期");
    }

    /**
     * cms 系统 根据token获取管理员用户信息
     * @param token
     * @return
     */
    @RequestMapping("/getUserInfoByToken")
    public  HeyGisResult getUserInfoByToken(@CookieValue("cms-user-token") String token){
        if(token!=null&&!token.equals("")){
            return systemService.getUserInfoByToken(token);
        }
        return HeyGisResult.build(202,"token过期");
    }

    /**
     * cms系统 查询管理员用户
     * @return
     */
    @RequestMapping("/getManageUser")
    public HeyGisResult getManageUser(){
        return systemService.getManageUser();
    }

    /**
     * cms系统 根据uid删除管理员用户
     * @param uid
     * @return
     */
    @RequestMapping("/deleteManageUserByUid")
    public  HeyGisResult deleteManageUserByUid(@RequestParam(value = "uid",required = true) String uid){
        if(uid!=null&&!uid.equals("")){
           return systemService.deleteManageUserByUid(uid);
        }
        return  HeyGisResult.build(202,"uid获取失败");
    }

    /**
     * cms系统 添加管理员
     * @param user
     * @return
     */
    @RequestMapping("/addManageUser")
    public HeyGisResult addManageUser( @RequestBody Users user){
        System.out.println(user);
        if(user!=null){
            return  systemService.addManageUser(user);
        }
        return HeyGisResult.build(202,"用户信息获取失败");
    }
}
