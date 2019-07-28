package com.heygis.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.cms.pojo.Sources;
import com.heygis.cms.service.SystemResourceService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.web.bind.annotation.*;

/**
 * cms系统 - 公共管理之资源管理 控制层
 */
@RestController
@RequestMapping("/system")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SystemResourceController {

    @Reference
    private SystemResourceService systemResourceService;

    /**
     * cms系统 查询资源
     * @return
     */
    @RequestMapping("/getSources")
    public HeyGisResult getSources(){
        return  systemResourceService.getSources();
    }

    /**
     * cms系统 新增资源
     * @param sources
     * @return
     */
    @RequestMapping("/addSources")
    public HeyGisResult addSources(@RequestBody Sources sources){
        System.out.println(sources);
        if(sources!=null){
            return systemResourceService.addSources(sources);
        }
        return  HeyGisResult.build(202,"资源获取失败");
    }

    /**
     * cms系统 根据id查询资源
     * @param id
     * @return
     */
    @RequestMapping("/getSourcesByID")
    public  HeyGisResult getSourcesByID(@RequestParam(value = "id",required = true) Integer id){
        if(id!=null){
            return systemResourceService.getSourcesByID(id);
        }
        return HeyGisResult.build(202,"id获取失败");
    }

    /**
     * cms系统 根据id更新资源
     * @param sources
     * @return
     */
    @RequestMapping("/updateSources")
    public HeyGisResult updateSources(@RequestBody Sources sources){
        if(sources!=null){
            return systemResourceService.updateSources(sources);
        }
        return HeyGisResult.build(202,"资源获取失败");
    }

    /**
     * cms系统 根据id删除资源
     * @param id
     * @return
     */
    @RequestMapping("/deleteSources")
    public HeyGisResult deleteSources(@RequestParam(value = "id",required = true) Integer id){
        if(id!=null){
            return systemResourceService.deleteSourcesByID(id);
        }
        return HeyGisResult.build(202,"id获取失败");
    }
}
