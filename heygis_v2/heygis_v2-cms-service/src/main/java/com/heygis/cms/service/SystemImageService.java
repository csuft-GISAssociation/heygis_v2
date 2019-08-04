package com.heygis.cms.service;

import com.heygis.cms.pojo.ImagesSources;
import com.heygis.cms.utils.HeyGisResult;

/**
 *  cms系统 图片管理 业务层
 */
public interface SystemImageService {

    /**
     * cms系统 增加图片资源
     * @param token
     * @param imagesSources
     * @return
     */
    HeyGisResult addImageResource(String token, ImagesSources imagesSources);

    /**
     * cms系统 查询图片资源
     * @return
     */
    HeyGisResult getImageSources();

    /**
     * cms系统 根据imgID查询图片资源信息
     * @param imgID
     * @return
     */
    HeyGisResult getImageResourceByImgID(String imgID);

    /**
     * cms系统 更新图片资源信息
     * @param imagesSources
     * @return
     */
    HeyGisResult updateImageResource(String token,ImagesSources imagesSources);

    /**
     * cms系统 根据imgID删除图片资源
     * @param imgID
     * @return
     */
    HeyGisResult deletImageResourceByImgID(String imgID);

}
