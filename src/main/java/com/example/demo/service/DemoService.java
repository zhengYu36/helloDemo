package com.example.demo.service;

import com.example.demo.entry.Demo;
import com.example.demo.entry.DemoExample;
import com.example.demo.util.PageQueryModel;
import com.github.pagehelper.PageInfo;

import java.util.List;



/**
* DemoService接口
* Created by lhb on 2022/5/12.
*/
public interface DemoService  {

    public long countByExample(DemoExample example);

    public int deleteByExample(DemoExample example);

    public int deleteByPrimaryKey(Long id);

    public int insert(Demo record);

    public int insertSelective(Demo record);

    public List<Demo> selectByExample(Demo record);

    public PageInfo<Demo> selectListPageByExample(Demo record, PageQueryModel pageQueryModel);

    public Demo selectByPrimaryKey(Long id);

    public int updateByExampleSelective(Demo record, DemoExample example);

    public int updateByExample(Demo record, DemoExample example);

    public int updateByPrimaryKeySelective(Demo record);

    public int updateByPrimaryKey(Demo record);

}