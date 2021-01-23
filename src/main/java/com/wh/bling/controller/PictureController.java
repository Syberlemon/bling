package com.wh.bling.controller;

import com.alibaba.fastjson.JSONObject;
import com.wh.bling.bean.Picture;
import com.wh.bling.bean.PictureReq;
import com.wh.bling.mapper.PictureMapper;
import com.wh.bling.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;

/**
 * @author froid
 * @date: 2020/10/12 0:07
 * 第一步倒是可以存一个相对路径，然后数据库存一下路径前缀，这样来整理照片
 * 想整理自己的本地照片，打算学一下fastdfs之后，还是用fastdfs搞
 */
@RestController
public class PictureController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PictureMapper pictureMapper;

    @RequestMapping("/getPicture/{id}")
    public Picture getPicture(@RequestParam("id")String id) {
        return pictureMapper.getPictureById(id);
    }

    @RequestMapping("/getPictureList")
    public List<Picture> getPictureList(@RequestParam("pictureReq") PictureReq pictureReq) {
        Map<String, Object> params = BeanUtil.beanToMap(pictureReq);
        return pictureMapper.getAllPicture(params);
    }

    @RequestMapping("/getPictureByPath")
    public List<Picture> getPictureByPath(@RequestParam("filePath")String filePath) {
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
                log.info(JSONObject.toJSONString(picture));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            list.add(picture);
        }
        return list;
    }

    @RequestMapping("addPicture")
    public void addPicture(Picture picture) {
        pictureMapper.addPicture(picture);

    }
}
