package com.ft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}

// 打war包时配置
//@SpringBootApplication
//public class BookApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(BookApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(BookApplication.class);
//	}
//}
