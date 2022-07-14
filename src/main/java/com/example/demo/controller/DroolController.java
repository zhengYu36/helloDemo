package com.example.demo.controller;

import com.example.demo.entry.Contract;
import com.example.demo.entry.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <ul>
 * <li>文件包名 : com.example.demo.controller</li>
 * <li>创建时间 : 2022/7/14 0014 13:59</li>
 * <li>修改记录 : 无</li>
 * 参考url:  https://blog.csdn.net/An1090239782/article/details/107219876
 *    https://www.zhihu.com/question/47063882
 *
 *    上面两个url要结合起看.
 * </ul>
 * 类说明： 规则引擎
 *
 * @author zhengyu
 */
@RestController
@RequestMapping("/drool")
public class DroolController {

    @Resource
    private KieSession kieSession;

    @RequestMapping("/test")
    public String test() {
        // 构建Fact对象，规则引擎的working memory中用到的JavaBean
        Order order = new Order();
        order.setOriginalPrice(160.0);

        //注意: insert 是匹配到规则  fireAllRules是执行规则

        // 将数据交给规则引擎，规则引擎根据Fact进行匹配
        kieSession.insert(order);

        //这里这个ct是指的返回值
/*        Contract ct = new Contract();
        kieSession.insert(ct);*/

        // 执行规则引擎，出发规则
        kieSession.fireAllRules();
        //System.out.print(order);

        return order.toString();
    }
}
