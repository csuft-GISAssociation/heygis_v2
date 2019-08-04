package com.heygis.cms.service;

import com.heygis.cms.utils.HeyGisResult;

/**
 * cms系统 用户管理
 */
public interface SystemUserService {

    /**
     * cms系统 获取用户信息列表
     * @return
     */
    HeyGisResult getUserList();

    /**
     * cms系统 根据uid删除用户和用户信息
     * @param uid
     * @return
     */
    HeyGisResult deleteUserByUid(Integer uid);

    /**
     * cms系统 根据nickname模糊查询用户信息
     * @param searchInfo
     * @return
     */
    HeyGisResult getUserInfoByNickName(String searchInfo);
}
