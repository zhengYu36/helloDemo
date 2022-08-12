package com.example.demo.test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>文件包名 : com.example.demo.test</li>
 * <li>创建时间 : 2022/8/12 0012 15:45</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author zhengyu
 */

public class CommitStratoryFactory {

    private static Map<String,ICommit> COM_RES = new HashMap<>();


    public static void register(String code,ICommit ic){
        if(StringUtils.isNotEmpty(code)){
            COM_RES.put(code,ic);
        }
    }

    public static ICommit get(String code){
        return COM_RES.get(code);
    }
}
