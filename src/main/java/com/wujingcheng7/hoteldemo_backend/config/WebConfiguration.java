package com.wujingcheng7.hoteldemo_backend.config;

import com.wujingcheng7.hoteldemo_backend.config.Interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/*","/books_display/*","/personal_info/*")
                .excludePathPatterns("/login","/index","/register","/login_backend","/hotels_display");
    }

}
