package com.heygis.cms.service;

import com.heygis.cms.pojo.ImagesSources;
import com.heygis.cms.pojo.Sources;
import com.heygis.cms.utils.HeyGisResult;

/**
 * cms系统 资源管理 业务层
 */
public interface SystemResourceService {

    /**
     * cms系统 查询资源
     * @return
     */
    HeyGisResult getSources();

    /**
     * cms系统 增加资源
     * @param sources
     * @return
     */
    HeyGisResult addSources(Sources sources);

    /**
     * cms系统 根据id查询资源
     * @param id
     * @return
     */
    HeyGisResult getSourcesByID(Integer id);

    /**
     * cms系统 更新资源
     * @param sources
     * @return
     */
    HeyGisResult updateSources(Sources sources);

    /**
     * cms系统 根据id删除资源
     * @param id
     * @return
     */
    HeyGisResult deleteSourcesByID(Integer id);
}
