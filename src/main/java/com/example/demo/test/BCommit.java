package com.example.demo.test;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * <ul>
 * <li>文件包名 : com.example.demo.test</li>
 * <li>创建时间 : 2022/8/12 0012 15:44</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author zhengyu
 */
@Service
public class BCommit implements ICommit {

    @PostConstruct
    public void init(){
    CommitStratoryFactory.register(CommonStant.Commit.COMMIT_B,this);
    }

    /**
     * Description TODO
     *
     * @param name 相关名称
     * @return void
     **/
    @Override
    public void commit(String name) {
        System.out.println("B commit "+name);
    }
}
