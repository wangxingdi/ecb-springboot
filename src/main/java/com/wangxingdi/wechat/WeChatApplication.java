package com.wangxingdi.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(value = {@PropertySource(value = {"classpath:important.properties", "file:config/important.properties"}, encoding = "utf-8", ignoreResourceNotFound = true)})
@MapperScan(basePackages = {"com.wangxingdi.wechat.**.dao"})
@SpringBootApplication
public class WeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatApplication.class, args);
	}

}
