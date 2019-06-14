package com.heygis.mapper;

import java.util.List;

import com.heygis.pojo.Users;
import com.heygis.pojo.UsersInfo;
import com.heygis.utils.HeyGisResult;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户持久层
 */
@Mapper
public interface UserMapper {

	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	Users queryUserByAccountAndPassWord(Users user);

	/**
	 * 校验账户是否重复
	 * @param account
	 * @return
	 */
	Integer checkAccount(String account);

    /**
     * 校验昵称是否重复
     * @param nickName
     * @return
     */
    Integer checkNickName(String nickName);

    /**
     * 插入用户表
     * @param user
     * @return
     */
    Integer insertUsers(Users user);

    /**
     * 插入用户信息表
     * @param userInfo
     * @return
     */
    Integer insertUsersInfo(UsersInfo userInfo);

    /**
     * 根据uid查询用户信息表
     * @param uid
     * @return
     */
    UsersInfo queryUserInfoByUid(Integer uid);

    /**
     * 根据uid更新用户表信息
     * @param usersInfo
     * @return
     */
    Integer updateUserInfoByUid(UsersInfo usersInfo);

	/**
	 * 根据uid更新用户头像
	 * @param usersInfo
	 * @return
	 */
	Integer updateUserIconByUid(UsersInfo usersInfo);

	List<Users> queryUserList();




    ;
}
