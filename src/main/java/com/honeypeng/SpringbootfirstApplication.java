package com.honeypeng;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication()
@EnableCaching//启用redis注解
//@ImportResource(locations = {"classpath:config.xml"})
public class SpringbootfirstApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ServletWebServerApplicationContext context = new ServletWebServerApplicationContext();
		SpringApplication.run(SpringbootfirstApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(SpringbootfirstApplication.class);
	}
}
