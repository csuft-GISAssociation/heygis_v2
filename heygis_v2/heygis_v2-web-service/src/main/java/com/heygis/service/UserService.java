package com.heygis.service;

import java.util.List;

import com.heygis.pojo.TempUser;
import com.heygis.pojo.Users;
import com.heygis.pojo.UsersInfo;
import com.heygis.utils.HeyGisResult;

/**
 * 用户业务层
 */
public interface UserService {


	/**
	 * 判断用户是否登录
	 * @return
	 */
	HeyGisResult checkLogin(String token);

	/**
	 * 用户登录
	 * @return
	 */
	HeyGisResult login(Users user);

	/**
	 * 用户退出
	 * @param token
	 * @return
	 */
	HeyGisResult logout(String token);

	/**
	 * 校验账户是否重复
	 * @param account
	 * @return
	 */
	HeyGisResult checkEmail(String account);

	/**
	 * 校验昵称是否重复
	 * @param nickName
	 * @return
	 */
	HeyGisResult checkNickName(String nickName);

	/**
	 * 用户注册
	 * @param tempUser
	 * @return
	 */
	HeyGisResult register(TempUser tempUser);

    /**
     * 获取用户个人信息
     * @param token
     * @return
     */
    HeyGisResult getSelfInfo(String token);

    /**
     * 根据uid更新用户信息
     * @param usersInfo
     * @return
     */
    HeyGisResult updateUserInfoByUid(UsersInfo usersInfo);

	/**
	 * 根据token更新用户头像
	 * @param token
	 * @param s
	 * @return
	 */
	HeyGisResult updateUserIconByToken(String token, String iconImage);

	List<Users> queryUserList();



}
