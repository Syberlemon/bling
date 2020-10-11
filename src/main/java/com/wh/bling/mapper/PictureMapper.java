package com.wh.bling.mapper;

import com.wh.bling.bean.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author froid
 * @date: 2020/10/12 0:05
 */
@Mapper
public interface PictureMapper {
    void addPicture(List<Picture> list);

    Picture getPictureById(String id);
}
