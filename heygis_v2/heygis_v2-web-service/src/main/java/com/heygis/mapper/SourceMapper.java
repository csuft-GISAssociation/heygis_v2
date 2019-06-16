package com.heygis.mapper;

import com.heygis.pojo.Sources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源持久层
 */
@Mapper
public interface SourceMapper {

    /**
     * 根据资源类型查询该资源总条数
     * @return
     */
    Long queryResourcesCount(Integer type);


    /**
     * 根据资源类型type分页查询资源信息
     * @param type
     * @return
     */
    List<Sources> queryResourcesByType(@Param("type") Integer type, @Param("start") Integer start, @Param("end") Integer end);


    /**
     * 按上传时间排序分页查询资源信息
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Sources> queryResourcesByTime(@Param("type") Integer type, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 按下载次数排序分页查询资源信息
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Sources> queryResourcesByDownloadTimes(@Param("type") Integer type, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 按字母顺序排序分页查询资源信息
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Sources> queryResourcesByAlpha(@Param("type") Integer type, @Param("start") Integer start, @Param("end") Integer end);

    /**
     *按文件大小排序分页查询资源信息
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Sources> queryResourcesBySize(@Param("type") Integer type, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 根据关键字模糊查询
     * @param type
     * @param keyWord
     * @return
     */
    List<Sources> queryResourcesByKeyWord(@Param("type") Integer type, @Param("keyWord") String keyWord);
}
