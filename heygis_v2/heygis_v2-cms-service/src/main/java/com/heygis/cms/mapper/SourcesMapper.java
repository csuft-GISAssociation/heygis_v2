package com.heygis.cms.mapper;

import com.heygis.cms.pojo.Sources;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源表持久类
 */
@Mapper
public interface SourcesMapper {

    /**
     * 查询资源
     * @return
     */
    List<Sources> querySources();

    /**
     * 插入资源
     * @param sources
     * @return
     */
    Integer insertSources(Sources sources);

    /**
     * 根据id查询资源
     * @param id
     * @return
     */
    Sources querySourcesByID(Integer id);

    /**
     * 根据id更新资源信息
     * @param sources
     * @return
     */
    Integer updateSourcesByID(Sources sources);

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    Integer deleteSourcesByID(Integer id);
}
