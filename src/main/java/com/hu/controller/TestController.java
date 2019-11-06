package com.hu.controller;

import com.hu.common.JsonData;
import com.hu.dao.SysAclModuleMapper;
import com.hu.exception.ParamException;
import com.hu.exception.PermissionException;
import com.hu.model.SysAclModule;
import com.hu.param.TestVo;
import com.hu.util.BeanValidator;
import com.hu.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author hzq
 * @description test
 * @date 2019/11/4
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    SysAclModuleMapper moduleMapper;

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
        throw new PermissionException("test exception");
//        return JsonData.success("hello");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException, IOException {
        log.info("validate");
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(module);
        log.info(str);
        SysAclModule mo = JsonMapper.string2Obj(str, new TypeReference<SysAclModule>(){});
        log.info(mo.getName());
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
