package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Xiao
 * @Date: 2019/2/26 0026 :21:02
 * @Description:
 */
@Controller
@RequestMapping("/")
public class testController {
    @RequestMapping("/home")
    public @ResponseBody String testBoot(){
        return "boot测试";
    }
}
