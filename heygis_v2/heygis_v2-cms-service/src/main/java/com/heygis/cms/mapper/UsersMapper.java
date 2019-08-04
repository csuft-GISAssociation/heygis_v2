package com.heygis.cms.mapper;

import com.heygis.cms.pojo.Users;
import com.heygis.cms.pojo.UsersInfo;
import com.heygis.cms.utils.HeyGisResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表持久类
 */
@Mapper
public interface UsersMapper {
    /**
     * 系统用户登录
     * @param user
     * @return
     */
    Users querySystemUserByAccountAndPassWord(Users user);

    /**
     * 查询管理员信息
     * @return
     */
    List<Users> queryManageUser();

    /**
     * 根据uid删除管理员
     * @param uid
     * @return
     */
    Integer deleteUserByUid(Integer uid);

    /**
     * 添加管理员
     * @param user
     * @return
     */
    Integer addManageUser(Users user);

    /**
     * 查询用户信息
     * @return
     */
    List<UsersInfo> queryUserList();

    /**
     * 根据uid删除用户
     * @param uid
     * @return
     */
    Integer deleteUserByUid1(Integer uid);

    /**
     * 根据uid删除用户信息
     * @param uid
     * @return
     */
    Integer deleteUserInfoByUid(Integer uid);

    /**
     * 根据nickname模糊查询用户信息
     * @param searchInfo
     * @return
     */
    List<UsersInfo> queryUserInfoByNickName(String searchInfo);
}
