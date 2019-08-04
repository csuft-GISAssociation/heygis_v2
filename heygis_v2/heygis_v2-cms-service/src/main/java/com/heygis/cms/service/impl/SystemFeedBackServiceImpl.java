package com.heygis.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heygis.cms.mapper.FeedBackMapper;
import com.heygis.cms.pojo.FeedBack;
import com.heygis.cms.service.SystemFeedBackService;
import com.heygis.cms.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * cms系统 意见管理 业务实现类
 */
@Service
public class SystemFeedBackServiceImpl implements SystemFeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * cms系统 查询意见信息
     * @return
     */
    @Override
    public HeyGisResult getFeedBack() {
        List<FeedBack> feedBackList = null;
        try{
            feedBackList = feedBackMapper.queryFeedBack();
        }
        catch (Exception e){
            e.printStackTrace();
            return HeyGisResult.build(201,"查询意见信息失败");
        }
        if(feedBackList!=null&&feedBackList.size()>0){
            return HeyGisResult.build(200,"查询意见信息成功",feedBackList);
        }else {
            return HeyGisResult.build(200,"查询意见信息为空");
        }
    }
}
