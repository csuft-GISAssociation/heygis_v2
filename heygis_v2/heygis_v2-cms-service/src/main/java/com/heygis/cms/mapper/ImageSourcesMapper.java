package com.heygis.cms.mapper;

import com.heygis.cms.pojo.ImagesSources;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 图片资源表持久类
 */
@Mapper
public interface ImageSourcesMapper {
    /**
     * 增加图片资源信息
     * @param imagesSources
     * @return
     */
    Integer insertImageResource(ImagesSources imagesSources);

    /**
     * 查询图片资源信息
     * @return
     */
    List<ImagesSources> queryImageSources();

    /**
     * 根据imgID查询图片资源信息
     * @param imgID
     * @return
     */
    ImagesSources queryImageSourceByImgID(Integer imgID);

    /**
     * 更新图片资源信息
     * @param imagesSources
     * @return
     */
    Integer updateImageResource(ImagesSources imagesSources);

    /**
     * 根据imgID删除图片资源
     * @param imgID
     * @return
     */
    Integer deletImageResourceByImgID(Integer imgID);
}
