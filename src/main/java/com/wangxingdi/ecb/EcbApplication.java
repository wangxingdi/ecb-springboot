package com.wangxingdi.ecb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(value = {@PropertySource(value = {"classpath:important.properties"}, encoding = "utf-8")})
@MapperScan(basePackages = {"com.wangxingdi.**.mapper"})
@SpringBootApplication
public class EcbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcbApplication.class, args);
	}

}
