package com.heygis.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.heygis.cms.mapper.ImageSourcesMapper;
import com.heygis.cms.mapper.SourcesMapper;
import com.heygis.cms.pojo.ImagesSources;
import com.heygis.cms.pojo.Sources;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.service.SystemResourceService;
import com.heygis.cms.utils.DateUtil;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * cms系统 资源管理业务层实现类
 */
@Service
public class SystemResourceServiceImpl implements SystemResourceService {

    @Autowired
    private SourcesMapper sourcesMapper;

    /**
     * cms系统 查询资源
     * @return
     */
    @Override
    public HeyGisResult getSources() {
        try{
            List<Sources> sourcesList =  sourcesMapper.querySources();
            if(sourcesList!=null&&sourcesList.size()>0){
                return HeyGisResult.build(200,"资源查询成功",sourcesList);
            }else {
                return HeyGisResult.build(200,"资源查询为空");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"资源查询失败");
        }
    }

    /**
     * cms系统 增加资源
     * @param sources
     * @return
     */
    @Override
    public HeyGisResult addSources(Sources sources) {
        //添加上传时间
        sources.setUpload_time(DateUtil.getStringDateShort());
        //添加下载次数
        sources.setDownload_times(0);
        //新增资源
        try {
            Integer i = sourcesMapper.insertSources(sources);
            return HeyGisResult.build(200,"资源添加成功");
            //暂不采取
            /*if(i>0){
                return HeyGisResult.build(200,"资源添加成功");
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"资源添加失败");
        }
    }

    /**
     * cms系统 根据id查询资源
     * @param id
     * @return
     */
    @Override
    public HeyGisResult getSourcesByID(Integer id) {
        try{
            Sources sources =  sourcesMapper.querySourcesByID(id);
            if(sources!=null){
                return HeyGisResult.build(200,"资源查询成功",sources);
            }else {
                return HeyGisResult.build(200,"资源查询为空");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"资源查询失败");
        }
    }

    /**
     * cms系统 根据资源id更新资源信息
     * @param sources
     * @return
     */
    @Override
    public HeyGisResult updateSources(Sources sources) {
        //修改上传时间
        sources.setUpload_time(DateUtil.getStringDateShort());
        try{
            Integer i =  sourcesMapper.updateSourcesByID(sources);
            return HeyGisResult.build(200,"资源更新成功");
            //暂不采取
           /* if(i>0){
                return HeyGisResult.build(200,"资源更新成功");
            }*/
        }
        catch (Exception e){
            return HeyGisResult.build(201,"资源更新失败");
        }
    }

    /**
     * cms系统 根据id删除资源
     * @param id
     * @return
     */
    @Override
    public HeyGisResult deleteSourcesByID(Integer id) {
        try{
            Integer i = sourcesMapper.deleteSourcesByID(id);
            return HeyGisResult.build(200,"资源删除成功");
            //暂不采取
            /*if(i>0){
                return HeyGisResult.build(200,"资源删除成功");
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"资源删除失败");
        }
    }


}
