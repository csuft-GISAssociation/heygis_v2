package com.heygis.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.pojo.Condition;
import com.heygis.service.ResourceService;
import com.heygis.utils.HeyGisResult;
import org.springframework.web.bind.annotation.*;

/**
 * 资源控制层
 */
@RestController
@RequestMapping("/resource")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ResourceController {

    @Reference
    private ResourceService resourceService;

    /**
     * 根据资源类型type 查询
     * @param type
     * @return
     */
    @RequestMapping("/getSource")
    public HeyGisResult getSource(@RequestParam(value = "type",required = true) Integer type,
                                  @RequestParam(value ="page",required = true) Integer page){
        //System.out.println(type);
        if(type!=null){
            return  resourceService.queryResourcesByType(type,page);
        }
        return  HeyGisResult.build(201,"资源类型type获取失败");
    }

    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    @RequestMapping("/getSourceByCon")
    public HeyGisResult getSourceByCondition( @RequestBody Condition condition){
        //System.out.println(condition);
        if(condition!=null){
          return  resourceService.queryResourcesByCondition(condition);
        }
        return  HeyGisResult.build(201,"获取条件信息失败");
    }

    /**
     * 根据关键词查询
     * @param type
     * @param keyWord
     * @return
     */
    @RequestMapping("/getSourceByKeyWord")
    public HeyGisResult getSourceByKeyWord(@RequestParam(value = "type",required = true) Integer type,
                      @RequestParam(value = "keyWord",required = true) String keyWord){
        if(type!=null) {
           return resourceService.queryResourcesByKeyWord(type,keyWord);
        }
        return  HeyGisResult.build(201,"获取资源失败");
    }


}
