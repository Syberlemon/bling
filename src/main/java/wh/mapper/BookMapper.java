package wh.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author froid
 * @date 2020/8/25 21:33
 */
@Mapper
public interface BookMapper {
    void addBook(Map<String, Object> map);
}
