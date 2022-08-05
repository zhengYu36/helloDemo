package com.example.demo.controller;

import com.example.demo.BaseController;
import com.example.demo.entry.Demo;
import com.example.demo.service.DemoService;
import com.example.demo.util.PageQueryModel;
import com.example.demo.util.ResponseCode;
import com.example.demo.util.ResponseEntity;
import com.example.demo.validation.groups.New;
import com.example.demo.validation.groups.Update;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* Democontroller
* Created by lhb on 2022/5/12.
*/
@Api(tags  = "Demo")
@RestController
@RequestMapping("/Demo")
public class DemoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    /**
    @ApiOperation("统计")
    @RequestMapping(value = "/count")
    public ResponseEntity<Long> countByExample(DemoExample example){
        ResponseEntity<Long> result = new ResponseEntity<Long>();
        long count = demoService.countByExample(example);
        result.setData(count);
        return result;
    }
        **/

    @ApiOperation("删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Long> deleteByPrimaryKey(@PathVariable("id") Long id){
                    ResponseEntity<Long> result = new ResponseEntity<Long>();
        int s = demoService.deleteByPrimaryKey(id);
        if(s == 0 ){
              result.setCode(ResponseCode.FAIL);
        }

        return result;
    }

    @ApiOperation("新增")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> insert(@Validated({New.class}) Demo record, BindingResult bErrors){
        ResponseEntity<Long> result = new ResponseEntity<Long>();
        if (bErrors.hasErrors()) {
            result.setCode(ResponseCode.REQUESTPARAMERROR);
            result.setMessage(doBindingResult(bErrors));
            return result;
        }
        int s = demoService.insert(record);
        if(s == 0 ){
            result.setCode(ResponseCode.FAIL);
        }
        return result;
    }

    @ApiOperation("列表查询")
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<List<Demo>> selectByExample(Demo record){
        ResponseEntity<List<Demo>> result = new ResponseEntity<List<Demo>>();
        List<Demo> list = demoService.selectByExample(record);
        result.setData(list);
        return result;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/listPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<PageInfo> selectListPageByExample(Demo record, PageQueryModel pageQueryModel){
        ResponseEntity<PageInfo> result = new ResponseEntity<PageInfo>();
        PageInfo list = demoService.selectListPageByExample(record, pageQueryModel);
        result.setData(list);
        return result;
    }

    @ApiOperation("详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Demo> selectByPrimaryKey(@PathVariable("id") Long id){
        ResponseEntity<Demo> result = new ResponseEntity<Demo>();
        Demo demo= demoService.selectByPrimaryKey(id);
        result.setData( demo);
        return result;
    }

    @ApiOperation("修改")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Long> updateByPrimaryKeySelective(@Validated({Update.class}) Demo record, BindingResult bErrors){
        ResponseEntity<Long> result = new ResponseEntity<Long>();
        if (bErrors.hasErrors()) {
            result.setCode(ResponseCode.REQUESTPARAMERROR);
            result.setMessage(doBindingResult(bErrors));
            return result;
        }
        int s = demoService.updateByPrimaryKeySelective(record);
        if(s == 0 ){
            result.setCode(ResponseCode.FAIL);
        }
        return result;
    }

}
