package com.heygis.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.heygis.cms.mapper.UsersMapper;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.service.SystemService;
import com.heygis.cms.utils.EncodeUtil;
import com.heygis.cms.utils.HexAndBytesUtil;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * cms系统 系统管理业务层实现类
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * cms 系统 用户登录
     * @param user
     * @return
     */
    @Override
    public HeyGisResult login(Users user) {
        //密码在前端做MD5，得到16进制字符串，在此转回为字节
        String password = user.getPassword();
        byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(password);
        //将字节使用Base64编码
        password = EncodeUtil.encoderByBase64(pwBytes);
        user.setPassword(password);
        Users loginUser = usersMapper.querySystemUserByAccountAndPassWord(user);
        if(loginUser==null){//用户名和密码错误
            return  HeyGisResult.build(201,"用户名或者密码错误");
        }
        //登录成功
        //生成token
        String token = UUID.randomUUID().toString();
        //将用户信息保存到redis中，key为token，value是用户信息
        String key = "CMS-SESSION:"+token;
        Gson gson = new Gson();
        redisTemplate.boundValueOps(key).set(gson.toJson(loginUser));
        //设置过期时间，为2个小时
        redisTemplate.expire(key,2*60, TimeUnit.MINUTES);
        //返回token
        return HeyGisResult.build(200,"登录成功",token);
    }

    /**
     * cms系统 用户登出
     * @param token
     * @return
     */
    @Override
    public HeyGisResult logout(String token) {
        //清除redis中token为key的用户信息
        String key = "CMS-SESSION:"+token;
        redisTemplate.delete(key);
        return HeyGisResult.build(200,"退出成功");
    }

    /**
     * cms系统 根据token查询用户信息
     * @param token
     * @return
     */
    @Override
    public HeyGisResult getUserInfoByToken(String token) {
        //从redis根据token取出用户信息
        String key = "CMS-SESSION:"+token;
        String user_json = redisTemplate.boundValueOps(key).get();
        Gson gson = new Gson();
        Users user = gson.fromJson(user_json,Users.class);
        if(user!=null){//已登录
            return  HeyGisResult.build(200,"已登录",user);
        }else {//未登录
            return HeyGisResult.build(201, "未登录");
        }
    }

    /**
     * cms系统 查询管理员信息
     * @return
     */
    @Override
    public HeyGisResult getManageUser() {
        try{
            List<Users> usersList = usersMapper.queryManageUser();
            if(usersList!=null&&usersList.size()>0) {
                return HeyGisResult.build(200,"查询管理员信息成功",usersList);
            }else {
                return HeyGisResult.build(200,"查询管理员信息为空");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"查询到管理员信息失败");
        }
    }

    /**
     * cms系统 根据uid删除管理员
     * @param uid
     * @return
     */
    @Override
    public HeyGisResult deleteManageUserByUid(String uid) {
        try{
            Integer i = usersMapper.deleteUserByUid(Integer.parseInt(uid));
            return  HeyGisResult.build(200,"删除管理员用户成功");
            //暂不采用
            /*if(i>0){
                return  HeyGisResult.build(200,"删除管理员用户成功");
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"删除管理员用户失败");
        }
    }

    /**
     * cms系统 添加管理员
     * @param user
     * @return
     */
    @Override
    public HeyGisResult addManageUser(Users user) {
        //默认为普通管理员
        user.setIdentity_id(1);
        //密码在前端做MD5，得到16进制字符串，在此转回为字节
        String password = user.getPassword();
        byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(password);
        //将字节使用Base64编码
        password = EncodeUtil.encoderByBase64(pwBytes);
        user.setPassword(password);
        try{
            Integer i  = usersMapper.addManageUser(user);
            return  HeyGisResult.build(200,"添加管理员用户成功");
            //暂不采用
            /*if(i>0){
                return  HeyGisResult.build(200,"添加管理员用户成功");
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"添加管理员用户失败");
        }


    }
}
