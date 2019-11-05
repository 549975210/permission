package com.hu.controller;

import com.hu.common.JsonData;
import com.hu.dao.SysAclModuleMapper;
import com.hu.exception.ParamException;
import com.hu.exception.PermissionException;
import com.hu.model.SysAclModule;
import com.hu.param.TestVo;
import com.hu.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hzq
 * @description test
 * @date 2019/11/4
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
        throw new PermissionException("test exception");
//        return JsonData.success("hello");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
