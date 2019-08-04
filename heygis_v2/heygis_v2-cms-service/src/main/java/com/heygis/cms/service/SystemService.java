package com.heygis.cms.service;

import com.heygis.cms.pojo.Users;
import com.heygis.cms.utils.HeyGisResult;

/**
 * cms系统 系统管理 业务层
 */
public interface SystemService {
    /**
     * cms系统 管理员用户登陆
     * @param users
     * @return
     */
    HeyGisResult login(Users users);

    /**
     * cms系统 管理员用户登出
     * @param token
     * @return
     */
    HeyGisResult logout(String token);

    /**
     * cms系统 根据token取出管理员用户信息
     * @param token
     * @return
     */
    HeyGisResult getUserInfoByToken(String token);

    /**
     * cms系统 查询管理员基本信息
     * @return
     */
    HeyGisResult getManageUser();

    /**
     * cms系统 根据uid删除管理员用户
     * @param uid
     * @return
     */
    HeyGisResult deleteManageUserByUid(String uid);

    /**
     * cms系统 添加管理员用户
     * @param user
     * @return
     */
    HeyGisResult addManageUser(Users user);
}
