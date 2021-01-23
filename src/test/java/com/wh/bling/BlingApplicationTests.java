package com.wh.bling;

import com.alibaba.fastjson.JSONObject;
import com.wh.bling.bean.Picture;
import com.wh.bling.controller.AccountController;
import com.wh.bling.controller.BookController;
import com.wh.bling.controller.PictureController;
import com.wh.bling.req.GetAccountReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlingApplicationTests {

    @Autowired
    private AccountController accountController;

    @Autowired
    private BookController bookController;

    @Autowired
    private PictureController pictureController;

    @Test
    public void getAccount(){
        GetAccountReq req = new GetAccountReq();
        req.setName("qq");
        System.out.println(accountController.getAccount(req));
    }

    @Test
    public void addBook(){
        bookController.addBook("C:\\Users\\Air\\Desktop\\a.txt");
    }

    @Test
    public void readFileName(){
        String filePath = "F:\\Pictures\\target\\2021-01";
        pictureController.getPictureByPath(filePath);
    }

    @Test
    public void addPicutre(){
        Picture picture = new Picture();
        picture.setPath("C:\\Users\\froid\\Desktop\\117APPLE\\BCDX2238.PNG");
        picture.setTag("linux");
        picture.setCreateTime("2021-01-01 00:00:00");
        picture.setDel("0");
        picture.setRemark("linux书里面说根");
        pictureController.addPicture(picture);
    }

    @Test
    public void getPicture(){
        System.out.println(pictureController.getPicture("1"));
    }

}
