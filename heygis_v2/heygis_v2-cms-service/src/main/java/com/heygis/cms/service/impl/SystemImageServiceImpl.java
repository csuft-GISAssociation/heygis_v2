package com.heygis.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.heygis.cms.mapper.ImageSourcesMapper;
import com.heygis.cms.pojo.ImagesSources;
import com.heygis.cms.pojo.Users;
import com.heygis.cms.service.SystemImageService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * cms系统 图片管理 业务层实现类
 */
@Service
public class SystemImageServiceImpl implements SystemImageService {

    @Autowired
    private ImageSourcesMapper imageSourcesMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * cms系统 增加图片资源
     * @param token
     * @param imagesSources
     * @return
     */
    @Override
    public HeyGisResult addImageResource(String token, ImagesSources imagesSources) {
        //从redis中取出用户信息
        String key = "CMS-SESSION:"+token;
        String user_json = redisTemplate.boundValueOps(key).get();
        //token未过期
        if(user_json!=null&&!user_json.equals("")){
            Users user = null;
            Gson gson = new Gson();
            user = gson.fromJson(user_json, Users.class);
            imagesSources.setUploader(user.getUid());
            try{
                Integer i = imageSourcesMapper.insertImageResource(imagesSources);
                return HeyGisResult.build(200,"图片资源添加成功");
                //暂不采取
                /*if(i>0){
                    return HeyGisResult.build(200,"图片资源添加成功");
                }*/
            }
            catch (Exception e){
                e.printStackTrace();
                return HeyGisResult.build(201,"图片资源添加失败");
            }
        }
        return HeyGisResult.build(201,"token过期");
    }

    /**
     * cms系统 查询图片资源
     * @return
     */
    @Override
    public HeyGisResult getImageSources() {
        try {
            List<ImagesSources> imagesSourcesList = imageSourcesMapper.queryImageSources();
            if(imagesSourcesList!=null&&imagesSourcesList.size()>0){
                return HeyGisResult.build(200,"图片资源查询成功",imagesSourcesList);
            }else {
                return HeyGisResult.build(200,"图片资源查询为空");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"图片资源查询失败");
        }
    }

    /**
     * cms系统 根据imgID查询图片资源信息
     * @param imgID
     * @return
     */
    @Override
    public HeyGisResult getImageResourceByImgID(String imgID) {
        try{
            ImagesSources imagesSources =  imageSourcesMapper.queryImageSourceByImgID(Integer.parseInt(imgID));
            if(imagesSources!=null){
                return HeyGisResult.build(200,"单个图片资源查询成功",imagesSources);
            }else {
                return HeyGisResult.build(200,"单个图片资源查询为空");
            }
        }
        catch (Exception e){
            return HeyGisResult.build(201,"单个图片资源查询失败");
        }
    }

    /**
     * cms系统 更新图片资源
     * @param imagesSources
     * @return
     */
    @Override
    public HeyGisResult updateImageResource(String token ,ImagesSources imagesSources) {
        //从redis中取出用户信息
        String key = "CMS-SESSION:"+token;
        String user_json = redisTemplate.boundValueOps(key).get();
        //token未过期
        if(user_json!=null&&!user_json.equals("")){
            Users user = null;
            Gson gson = new Gson();
            user = gson.fromJson(user_json, Users.class);
            imagesSources.setUploader(user.getUid());
            try{
                Integer i = imageSourcesMapper.updateImageResource(imagesSources);
                return HeyGisResult.build(200,"图片资源更新成功");
                //暂不采取
                /*if(i>0){
                    return HeyGisResult.build(200,"图片资源更新成功");
                }*/
            }
            catch (Exception e) {
                e.printStackTrace();
                return HeyGisResult.build(201, "图片资源更新失败");
            }
        }
        return HeyGisResult.build(201,"token过期");
    }

    /**
     * cms系统 根据imgID删除图片资源
     * @param imgID
     * @return
     */
    @Override
    public HeyGisResult deletImageResourceByImgID(String imgID) {
        try {
            Integer i = imageSourcesMapper.deletImageResourceByImgID(Integer.parseInt(imgID));
            return HeyGisResult.build(200,"删除图片资源信息成功");
            //暂不采取
            /*if(i>0){
                return HeyGisResult.build(200,"删除图片资源信息成功");
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"删除图片资源信息失败");
        }
    }


}
