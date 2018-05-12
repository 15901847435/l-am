package com.example.admin;


import com.example.admin.configure.Meshsite3Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class AdminApplication {

	/**
	 * SiteMesh 配置
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		Meshsite3Filter siteMeshFilter = new Meshsite3Filter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
