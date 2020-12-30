package com.wh.bling.controller;

import com.wh.bling.bean.Picture;
import com.wh.bling.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author froid
 * @date: 2020/10/12 0:07
 * 第一步倒是可以存一个相对路径，然后数据库存一下路径前缀，这样来整理照片
 * 想整理自己的本地照片，打算学一下fastdfs之后，还是用fastdfs搞
 */
@RestController
public class PictureController {
    @Autowired
    private PictureMapper pictureMapper;

    @RequestMapping("/getPicture/{id}")
    public Picture getPicture(@RequestParam("id")String id) {
        System.out.println("id:"+id);
        return pictureMapper.getPictureById(id);
    }

    public void addPicture(String filePath) {
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Picture> list = new ArrayList<>();
        for (int i = 0; i < fileList.length; i++) {
            File f = fileList[i];
            Picture picture = new Picture();
            picture.setPath(f.getAbsolutePath());
            Path p = Paths.get(f.getAbsolutePath());
            try {
                BasicFileAttributes att = Files.readAttributes(p, BasicFileAttributes.class);
                picture.setCreateTime(sdf.format(att.creationTime().toMillis()));
//                System.out.println(JSONObject.toJSONString(picture));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            list.add(picture);
            if ((i + 1 ) % 100 == 0 || i+1 == fileList.length) {
                pictureMapper.addPicture(list);
                list = new ArrayList<>();
            }
        }
    }
}
