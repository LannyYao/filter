package com.lanny.filter.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Lanny Yao
 * @date 3/22/2019 10:08 AM
 */
//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Release this statement to know the process order for Filter and Interceptor
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/filter/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/interceptor/**");
    }
}
