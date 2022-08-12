package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <ul>
 * <li>文件包名 : com.example.demo.test</li>
 * <li>创建时间 : 2022/8/12 0012 15:54</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author zhengyu
 */
@SpringBootTest
class TestTest {

    @Test
    void sayInfo() {
        CommitStratoryFactory.get("ccommit").commit("xxxx");
    }
}