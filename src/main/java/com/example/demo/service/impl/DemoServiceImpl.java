package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.DemoMapper;
import com.example.demo.entry.Demo;
import com.example.demo.entry.DemoExample;
import com.example.demo.service.DemoService;
import com.example.demo.util.OperatorEnum;
import com.example.demo.util.PageQueryModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * DemoService实现
 * Created by lhb on 2022/5/12.
 */
@Service
@Transactional
public class DemoServiceImpl  implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoMapper demoMapper;

    public long countByExample(DemoExample example) {
        return demoMapper.countByExample(example);
    }

    public int deleteByExample(DemoExample example) {
        return demoMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return demoMapper.deleteByPrimaryKey(id);
    }

    public int insert(Demo record) {
        return demoMapper.insert(record);
    }

    public int insertSelective(Demo record) {
        return demoMapper.insertSelective(record);
    }

    public List<Demo> selectByExample(Demo record) {
        DemoExample example = buildExample(record);
        return demoMapper.selectByExample(example);
    }

    public PageInfo<Demo> selectListPageByExample(Demo record, PageQueryModel pageQueryModel) {
        DemoExample example = buildExample(record, pageQueryModel);
        example.setOrderByClause(pageQueryModel.getOrderBy());
        PageHelper.startPage(pageQueryModel.getPageNum(), pageQueryModel.getPageSize());
        PageInfo<Demo> pageInfo = new PageInfo<>(demoMapper.selectByExample(example));
        return pageInfo;
    }

    public Demo selectByPrimaryKey(Long id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(Demo record, DemoExample example) {
        return demoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Demo record, DemoExample example) {
        return demoMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(Demo record) {
        return demoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Demo record) {
        return demoMapper.updateByPrimaryKey(record);
    }

    private DemoExample buildExample(Demo record) {
        DemoExample example = new DemoExample();
        DemoExample.Criteria criteria = example.createCriteria();
        // 查询参数

        if (record.getId() != null) {
            criteria.andIdEqualTo(record.getId());
        }
        if (StringUtils.isNotBlank(record.getName())) {
            criteria.andNameEqualTo(record.getName());
        }
        if (record.getAge() != null) {
            criteria.andAgeEqualTo(record.getAge());
        }


        return example;
    }

    public DemoExample buildExample(Demo record, PageQueryModel pageQueryModel) {
        DemoExample example = buildExample(record);
        DemoExample.Criteria criteria = example.getOredCriteria().get(0);
        // todo ......
        if (StringUtils.isNotEmpty(pageQueryModel.getConditionJson())) {
            List<PageQueryModel.ConditionModel> conditionModelList = JSON.parseArray(pageQueryModel.getConditionJson(), PageQueryModel.ConditionModel.class);
            boolean isOR = false;
            int nOR = 1;
            for (PageQueryModel.ConditionModel conditionModel : conditionModelList) {
                if (conditionModel.getOperator().equals(OperatorEnum.OR)) {
                    DemoExample.Criteria criteriaOR = example.or();
                    isOR = true;
                    nOR++;
                } else if (isOR) {
                    Method method = ReflectionUtils.findMethod(DemoExample.Criteria.class, conditionModel.getConditionMethodName());
                    ReflectionUtils.invokeMethod(method, example.getOredCriteria().get(nOR));
                } else {
                    Method method = ReflectionUtils.findMethod(DemoExample.Criteria.class, conditionModel.getConditionMethodName());
                    ReflectionUtils.invokeMethod(method, criteria);
                }
            }
        }
        return example;
    }


}