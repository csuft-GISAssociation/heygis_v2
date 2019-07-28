package com.heygis.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.cms.service.SystemFeedBackService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cms系统 - 公共管理之意见管理 控制层
 */
@RestController
@RequestMapping("/system")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SystemFeedBackController {

    @Reference
    private SystemFeedBackService systemFeedBackService;

    /**
     * cms系统 查询意见信息
     * @return
     */
    @RequestMapping("/getFeedBack")
    public HeyGisResult getFeedBack(){
        return systemFeedBackService.getFeedBack();
    }


}
