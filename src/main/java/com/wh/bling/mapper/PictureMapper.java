package com.wh.bling.mapper;

import com.wh.bling.bean.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author froid
 * @date: 2020/10/12 0:05
 */
@Mapper
public interface PictureMapper {
    void batchAddPicture(List<Picture> list);

    void addPicture(Picture picture);

    Picture getPictureById(String id);

    List<Picture> getAllPicture(Map<String, Object> params);
}
