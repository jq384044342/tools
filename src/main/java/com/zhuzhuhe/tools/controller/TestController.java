package com.zhuzhuhe.tools.controller;

import com.zhuzhuhe.tools.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("getName")
    public String getName(String id){
        String res = "";
        Map<String, Object> params = new HashMap<>();
        params.put("id",id);
        res = testService.getName(params);
        return res;
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
