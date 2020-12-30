package wh.mapper;

import org.apache.ibatis.annotations.Mapper;
import wh.bean.Picture;

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
