package wh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author froid
 * Date:  2020/12/26
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello springboot";
    }
}
