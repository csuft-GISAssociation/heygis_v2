package com.heygis.service.impl;

import java.awt.*;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.heygis.pojo.TempUser;
import com.heygis.pojo.Users;
import com.heygis.pojo.UsersInfo;
import com.heygis.utils.EncodeUtil;
import com.heygis.utils.HexAndBytesUtil;
import com.heygis.utils.HeyGisResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.heygis.mapper.UserMapper;
import com.heygis.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 用户业务层实现类
 */
@Service
public class UserServiceImpl implements UserService {


	//用户持久层对象
	@Autowired
	private UserMapper userMapper;

	//Redis操作对象
	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	/**
	 * 校验用户是否登录
	 * 通过从redis中取出登录状态，来进行判断
	 * @return
	 */
	@Override
	public HeyGisResult checkLogin(String token) {
		String key = "SESSION:"+token;
		String user_json = redisTemplate.boundValueOps(key).get();
		Gson gson = new Gson();
		Users user = gson.fromJson(user_json,Users.class);
		if(user!=null){//已登录
			return  HeyGisResult.build(200,"已登录","logined");
		}else {//未登录
			return HeyGisResult.build(201, "未登录", "nologin");
		}
	}

	/**
	 * 用户进行登录
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
		Users loginUser = userMapper.queryUserByAccountAndPassWord(user);
		if(loginUser==null){//用户名和密码错误
			return  HeyGisResult.build(201,"用户名或者密码错误");
		}
		//登录成功
		//生成token
		String token
				= UUID.randomUUID().toString();
		//将用户信息保存到redis中，key为token，value是用户信息
		String key = "SESSION:"+token;
		Gson gson = new Gson();
		redisTemplate.boundValueOps(key).set(gson.toJson(loginUser));
		//设置过期时间，为2个小时
		redisTemplate.expire(key,2*60,TimeUnit.MINUTES);
		//返回token
		return HeyGisResult.build(200,"登录成功",token);
	}

	/**
	 * 用户进行退出
	 * @param token
	 * @return
	 */
	@Override
	public HeyGisResult logout(String token) {
		//清除redis中token为key的用户信息
		String key = "SESSION:"+token;
		redisTemplate.delete(key);
		return HeyGisResult.build(200,"退出成功");
	}

    /**
     * 校验账户是否重复
     * @param account
     * @return
     */
    @Override
    public HeyGisResult checkEmail(String account) {
        Integer count = userMapper.checkAccount(account);
        if(count>0){//用户已存在
            return  HeyGisResult.build(201,"该邮箱已存在");
        }
        return HeyGisResult.build(200,"该邮箱未存在");
    }

	/**
	 * 校验昵称是否重复
	 * @param nickName
	 * @return
	 */
	@Override
	public HeyGisResult checkNickName(String nickName) {
    	Integer count = userMapper.checkNickName(nickName);
		if(count>0){//昵称已存在
			return  HeyGisResult.build(201,"该昵称已存在",nickName);
		}
		return HeyGisResult.build(200,"该昵称未存在");
	}

	/**
	 * 用户注册
	 * @param tempUser
	 * @return
	 */
	@Override
	public HeyGisResult register(TempUser tempUser) {
		//获得用户实体
		Users user = tempUser.createUser();
		//密码在前端做MD5，得到16进制字符串，在此转回为字节
		String password = user.getPassword();
		byte[] pwBytes = HexAndBytesUtil.HEXtoBytes(password);
		//将字节使用Base64编码
		password = EncodeUtil.encoderByBase64(pwBytes);
		user.setPassword(password);
		//插入用户表，返回影响条数
		Integer i = userMapper.insertUsers(user);
		//System.out.println(user);
		//获取uid
		Integer uid = user.getUid();
		//1.事务控制，若用户表插入失败，会回滚
		//2.用返回影响条数i控制，若i>0，说明插入成功
		Integer j = 0;
		if(i>0){
			//获得用户信息表实体
			UsersInfo userInfo = tempUser.createUserInfo();
			//设置默认属性
			userInfo.setUid(uid);
			userInfo.setAccount(user.getAccount());
			userInfo.setMail(user.getAccount());
			j = userMapper.insertUsersInfo(userInfo);
			if(j > 0){
				return  HeyGisResult.build(200,"用户注册成功");
			}
		}
		return HeyGisResult.build(201,"用户注册失败");
	}

    /**
     * 根据token获取uid，查询用户基本信息
     * @param token
     * @return
     */
    @Override
    public HeyGisResult getSelfInfo(String token) {
        String key = "SESSION:"+token;
        //从redis中取出用户信息
        String userInfo_json = redisTemplate.boundValueOps(key).get();
        if(userInfo_json!=null){
            Gson gson = new Gson();
            Users user = gson.fromJson(userInfo_json,Users.class);
            //根据uid查询用户基本信息
            UsersInfo usersInfo = userMapper.queryUserInfoByUid(user.getUid());
            return HeyGisResult.build(200,"获取用户基本信息成功",usersInfo);
        }
        return HeyGisResult.build(201,"redis过期");
    }

    /**
     * 根据uid更新用户基本信息
     * @param usersInfo
     * @return
     */
    @Override
    public HeyGisResult updateUserInfoByUid(UsersInfo usersInfo) {
        Integer i = userMapper.updateUserInfoByUid(usersInfo);
        if(i>0){
            return HeyGisResult.build(200,"用户基本信息更新成功");
        }
        return HeyGisResult.build(201,"用户基本信息更新失败");
    }

	/**
	 * 根据token更新用户头像
	 * @param token
	 * @param iconImage
	 * @return
	 */
	@Override
	public HeyGisResult updateUserIconByToken(String token, String iconImage) {
		String key = "SESSION:"+token;
		//从redis中取出用户信息
		String user_json = redisTemplate.boundValueOps(key).get();
		if(user_json!=null){
			Gson gson = new Gson();
			Users user = gson.fromJson(user_json,Users.class);
			//创建用户表实体
			UsersInfo usersInfo = new UsersInfo();
			usersInfo.setUid(user.getUid());
			usersInfo.setIcon_img(iconImage);
			//更新用户头像
			Integer i = userMapper.updateUserIconByUid(usersInfo);
			if(i>0){
				return HeyGisResult.build(200,"用户头像更新成功");
			}
		}
		return HeyGisResult.build(202,"用户头像更新失败");
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<Users> queryUserList(){
		return userMapper.queryUserList();
	}

}
