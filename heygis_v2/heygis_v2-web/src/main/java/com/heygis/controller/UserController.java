package com.heygis.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.pojo.TempUser;
import com.heygis.pojo.Users;
import com.heygis.pojo.UsersInfo;
import com.heygis.service.UserService;
import com.heygis.utils.HeyGisResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 判断是否登录
     * @return
     */
    @RequestMapping("/isLogin")
    public HeyGisResult isLogin(@CookieValue("user-token") String token){
        //System.out.println(token);
        if(token!=null&&!token.equals("")){
            return  userService.checkLogin(token);
        }
        return HeyGisResult.build(203,"token不存在");

    }

    /**
     * 用户进行登录
     */
    @RequestMapping("/login")
    public HeyGisResult login(@RequestBody Users user, HttpServletResponse response){
        //System.out.println(user);
        if(user!=null){
            //登录
            HeyGisResult result = userService.login(user);
           //取出token，写到cookied中
           String token = (String) result.getData();
           Cookie cookie = new Cookie("user-token",token);
           //设置cookie过期时间为2个小时
           cookie.setMaxAge(60*60*2);
           cookie.setPath("/");
           response.addCookie(cookie);
           return result;
        }
        return  HeyGisResult.build(201,"用户账号密码获取失败");
    }

    /**
     * 用户进行退出
     * @param token
     * @return
     */
    @RequestMapping("/logout")
    public HeyGisResult logout(@CookieValue("user-token") String token,HttpServletResponse response){
        if(token!=null&&!token.equals("")) {
             HeyGisResult result = userService.logout(token);
             //清除cookie
            Cookie cookie = new Cookie("user-token",token);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return result;
        }
        return HeyGisResult.build(203,"token不存在");
    }

    /**
     *  邮箱校验
     * @param user
     * @return
     */
    @RequestMapping("/checkEmail")
    public HeyGisResult checkEmail(@RequestBody  Users user){
        String account = user.getAccount();
        if(account!=null&&!account.equals("")){
           return userService.checkEmail(account);
        }
        return HeyGisResult.build(202,"账户为空");
    }

    /**
     * 昵称校验
     * @param usersInfo
     * @return
     */
    @RequestMapping("/checkNickName")
    public HeyGisResult checkNickName(@RequestBody UsersInfo usersInfo){
       String nickName = usersInfo.getNickname();
       if(nickName!=null&&!nickName.equals("")){
           return  userService.checkNickName(nickName);
       }
       return HeyGisResult.build(202,"昵称不能为空");
    }

    /**
     * 用户注册
     * @param tempUser
     * @return
     */
    @RequestMapping("/register")
    public HeyGisResult register(@RequestBody TempUser tempUser){
        //System.out.println(tempUser.createUser());
        //System.out.println(tempUser.createUserInfo());
        if(tempUser!=null){
           return userService.register(tempUser);
        }
        return  HeyGisResult.build(202,"注册信息不能为空");
    }

    /**
     * 根据token获取用户基本信息
     * @param token
     * @return
     */
    @RequestMapping("/getSelfInfo")
    public HeyGisResult getSelfInfo(@CookieValue("user-token") String token){
        if(token!=null&&!token.equals("")){
           return userService.getSelfInfo(token);
        }
        return  HeyGisResult.build(203,"token不存在");
    }

    /**
     * 根据uid更新用户信息
     * @param usersInfo
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public HeyGisResult updateUserInfo(@RequestBody  UsersInfo usersInfo){
        //System.out.println(usersInfo);
        if(usersInfo!=null){
            return  userService.updateUserInfoByUid(usersInfo);
        }
        return  HeyGisResult.build(202,"用户信息不能为空");
    }

}
