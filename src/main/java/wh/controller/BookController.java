package wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import wh.mapper.BookMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Air
 * Date:  2020/9/3
 * 是希望对自己的书能够做到一目了然，二刷三刷也能够层层递进，留下总结和收获，不过过一阵子再读还是和新书一样，那之前就真的白读了
 */
@RestController
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    public void addBook(String filePath) {
        File file = new File(filePath);
        List<String> content = txt2String(file);
        for (String s: content) {
            Map<String, Object> params = new HashMap();
            if(s.contains("（") && !(s.contains("上") || s.contains("全集"))){
                //拆分作者
                String[] res = s.split("（");
                params.put("name", res[0]);
                if(res[1].contains("）")){
                    String[] res2 = res[1].split("）");
                    if(res2.length > 1){
                        params.put("writer", res2[0]);
                        params.put("remark", res2[1]);
                    }else{
                        params.put("writer", res2[0]);
                    }
                }
            }
            else {
                params.put("name", s);
                params.put("writer", "");
                params.put("remark", "");
            }
            bookMapper.addBook(params);
        }

    }

    private static List<String> txt2String(File file){
        List<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行，去掉空行
                if("".equals(s)){
                    continue;
                }
                list.add(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
