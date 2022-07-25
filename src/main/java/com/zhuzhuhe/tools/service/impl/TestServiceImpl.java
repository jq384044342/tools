package com.zhuzhuhe.tools.service.impl;

import com.zhuzhuhe.tools.dao.TestMapper;
import com.zhuzhuhe.tools.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public String getName(Map<String, Object> params) {
        return testMapper.getName(params);
    }
}
