package com.zhuzhuhe.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages="com.zhuzhuhe.tools.dao")
@EnableConfigurationProperties
public class ToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsApplication.class, args);
	}

}
