package com.heygis.cms.mapper;

import com.heygis.cms.pojo.FeedBack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源表持久类
 */
@Mapper
public interface FeedBackMapper {

    /**
     * 查询意见信息
     * @return
     */
    List<FeedBack> queryFeedBack();

}
