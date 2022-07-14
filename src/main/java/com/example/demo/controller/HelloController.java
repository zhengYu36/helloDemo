package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <ul>
 * <li>文件包名 : com.example.demo</li>
 * <li>创建时间 : 2022/6/23 0023 14:10</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author zhengyu
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/say/{info}")
    public String sayHello(@PathVariable String info){
        return "aaa world,"+info;
    }
}
