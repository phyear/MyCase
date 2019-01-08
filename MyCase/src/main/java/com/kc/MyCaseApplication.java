package com.kc;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

@SpringBootApplication
@EnableTransactionManagement 
public class MyCaseApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(MyCaseApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(MyCaseApplication.class, args);
	}
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper=new PageHelper();
		Properties p = new Properties();
			p.setProperty("offsetAsPageNum", "true");
			 p.setProperty("rowBoundsWithCount", "true");
			p.setProperty("reasonable", "true");
			p.setProperty("returnPageInfo", "check");
			p.setProperty("params", "count=countSql");
			pageHelper.setProperties(p);

		return pageHelper;
		
	}
}
