package com.yuin.smalltools.controller;


import com.yuin.smalltools.common.distributedLock.RedissionFactoryBean;
import com.yuin.smalltools.common.result.Result;
import com.yuin.smalltools.common.result.ResultEnum;
import com.yuin.smalltools.entity.trans.TransInfoVo;
import com.yuin.smalltools.service.TransService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/videos")
public class YouGetController {

    @Autowired
    TransService transService;

    @RequestMapping("/transfer")
    @ResponseBody
    public Result transfer(@RequestParam String transUrl){
        String[] urls = transService.sendUrl(transUrl);
        if (urls!=null) {
            return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getDesc(),urls);
        } else {
            return new Result(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getDesc());
        }
    }
}
