package com.heygis.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.heygis.mapper.SourceMapper;
import com.heygis.pojo.Condition;
import com.heygis.pojo.ResourcePageBean;
import com.heygis.pojo.Sources;
import com.heygis.service.ResourceService;
import com.heygis.utils.HeyGisResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 资源业务层实现类
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private SourceMapper sourceMapper;

    /**
     * 根据资源类型分页查询资源信息
     * @param type
     * @return
     */
    @Override
    public HeyGisResult queryResourcesByType(Integer type,Integer page) {
        //创建PageBean
        ResourcePageBean pageBean = new ResourcePageBean();
        //设置当前页
        pageBean.setCurrentPage(page);
        //查询总条数并设置
        Long totalCount =  sourceMapper.queryResourcesCount(type);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        pageBean.setTotalPage();
        //分页查询资源并设置
        Integer size = ResourcePageBean.size;
        List<Sources> sources = sourceMapper.queryResourcesByType(type,(page-1)*size,size);
        pageBean.setSources(sources);
        if(sources.size()>0){
            return HeyGisResult.build(200,"资源查询成功",pageBean);
        }
        return HeyGisResult.build(202,"未查询到资源");
    }

    /**
     * 根据条件分页查询资源信息
     * @param condition
     * @return
     */
    @Override
    public HeyGisResult queryResourcesByCondition(Condition condition) {
        Integer type = condition.getType();
        Integer page = condition.getPage();
        Integer size = ResourcePageBean.size;
        List<Sources> sources = null;
        //创建PageBean
        ResourcePageBean pageBean = new ResourcePageBean();
        //设置当前页
        pageBean.setCurrentPage(page);
        //查询总条数并设置
        Long totalCount =  sourceMapper.queryResourcesCount(type);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        pageBean.setTotalPage();

        //按上传时间
        if(condition.getConditionId()==1){
            sources = sourceMapper.queryResourcesByTime(type,(page-1)*size,size);
            pageBean.setSources(sources);
        }
        //按下载次数
        if(condition.getConditionId()==2){
            sources = sourceMapper.queryResourcesByDownloadTimes(type,(page-1)*size,size);
            pageBean.setSources(sources);
        }
        //按字母顺序
        if(condition.getConditionId()==3){
            sources = sourceMapper.queryResourcesByAlpha(type,(page-1)*size,size);
            pageBean.setSources(sources);
        }
        //按文件大小
        if(condition.getConditionId()==4){
            sources = sourceMapper.queryResourcesBySize(type,(page-1)*size,size);
            pageBean.setSources(sources);
        }
        //返回结果集
        if(sources.size()>0){
            return HeyGisResult.build(200,"按条件:"+condition.getConditionName()+"查询成功",pageBean);
        }
        return HeyGisResult.build(202,"按条件"+condition.getConditionName()+"未查询到资源");
    }

    /**
     * 根据关键字模糊查询资源信息
     * @param type
     * @param keyWord
     * @return
     */
    @Override
    public HeyGisResult queryResourcesByKeyWord(Integer type, String keyWord) {
        keyWord = "%"+keyWord+"%";
        List<Sources> sources = sourceMapper.queryResourcesByKeyWord(type,keyWord);
        if(sources.size()>0){
            return  HeyGisResult.build(200,"关键词查询成功",sources);
        }
        return HeyGisResult.build(202,"该关键字未查询到资源");
    }
}
