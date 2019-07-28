package com.heygis.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.heygis.cms.pojo.ImagesSources;
import com.heygis.cms.service.SystemImageService;
import com.heygis.cms.service.SystemResourceService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.web.bind.annotation.*;

/**
 * cms系统 - 公共管理之图片管理 控制层
 */
@RestController
@RequestMapping("/system")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SystemImageController {

    @Reference
    private SystemImageService systemImageService;

    /**
     * cms系统 增加图片资源
     * @param token
     * @param imagesSources
     * @return
     */
    @RequestMapping("/addImageResource")
    public HeyGisResult addImageResource(@CookieValue("cms-user-token")String token,
                                         @RequestBody ImagesSources imagesSources){
        //System.out.println(imagesSources);
        if(imagesSources!=null) {
            return systemImageService.addImageResource(token, imagesSources);
        }
        return  HeyGisResult.build(202,"图片资源获取失败");
    }

    /**
     * cms系统 查询图片资源
     * @return
     */
    @RequestMapping("/getImageSources")
    public HeyGisResult getImageSources(){
        return systemImageService.getImageSources();
    }

    /**
     * cms系统 根据ImgID查询图片资源
     * @param imgID
     * @return
     */
    @RequestMapping("/getImageResourceByImgID")
    public HeyGisResult getImageResourceByImgID(@RequestParam(value = "imgID",required = true) String imgID){

        if(imgID!=null&&!imgID.equals("")){
            return systemImageService.getImageResourceByImgID(imgID);
        }
        return HeyGisResult.build(202,"imgID获取失败");
    }

    /**
     * cms系统 更新图片资源信息
     * @param token
     * @param imagesSources
     * @return
     */
    @RequestMapping("/updateImageResource")
    public HeyGisResult updateImageResource(@CookieValue("cms-user-token") String token,
                                            @RequestBody ImagesSources imagesSources){
        if(imagesSources!=null){
            return systemImageService.updateImageResource(token,imagesSources);
        }

        return HeyGisResult.build(202,"图片资源获取失败");
    }

    /**
     * cms系统 根据图片id删除图片
     * @param imgID
     * @return
     */
    @RequestMapping("/deletImageResourceByImgID")
    public HeyGisResult deletImageResourceByImgID(@RequestParam(value = "imgID",required = true) String imgID){
        if(imgID!=null&&!imgID.equals("")){
            return systemImageService.deletImageResourceByImgID(imgID);
        }
        return HeyGisResult.build(202,"imgID获取失败");
    }

}
