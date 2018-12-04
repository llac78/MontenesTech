package com.llac.montenes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.llac.montenes")
public class WebMvcConfig implements WebMvcConfigurer {

	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp().prefix("/WEB-INF/pages/").suffix(".jsp");
	}
}
