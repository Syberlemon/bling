package com.wh.bling;

import com.wh.bling.controller.AccountController;
import com.wh.bling.controller.BookController;
import com.wh.bling.controller.PictureController;
import com.wh.bling.req.GetAccountReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        String filepath = "F:\\Pictures\\102APPLE";
        pictureController.addPicture(filepath);
    }

    @Test
    public void getPicture(){
        System.out.println(pictureController.getPicture("1"));
    }

}
